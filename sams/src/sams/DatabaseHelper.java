/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams;

import com.mysql.jdbc.MysqlDataTruncation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Wepngong
 */
public class DatabaseHelper {

    public Connection connection;
    public ResultSet resultSet;
    public ResultSetMetaData metaData;
    public int numberOfRows;
    public Statement statement;
    public boolean connectedToDatabase;
    public ResultSet result;
    public ResultSetMetaData metadata;
    PreparedStatement ps;

    public DatabaseHelper() throws SQLException, Exception {

        this.numberOfRows = 0;
        this.statement = null;
        this.connectedToDatabase = false;
        this.resultSet = null;
        this.metaData = null;
        this.connection = null;

        initDB();//create the database if it does not exist
        // update database connection status
        connectedToDatabase = true;

//        this.pcName = getPcName() + "-PC";
//        System.out.println("pc name = " + pcName);
    }

    public String getPcName() {
        FileReader in = null;
        String dataFromFile = null;
        int ipVal;

        String ipFileLocation;
        ipFileLocation = "config.txt";
        System.out.println("ip location = " + ipFileLocation);

        try {
            System.out.println("opeinig the input file");
            try {
                in = new FileReader(ipFileLocation);
                System.out.println("input file opened succesfully");
            } catch (FileNotFoundException ex) {
                System.out.println("error opening file \n " + ex.getMessage());
                exit(1);
            }
            dataFromFile = String.valueOf((char) in.read());
            while ((ipVal = in.read()) != -1) {
                dataFromFile += (char) ipVal;
            }
            System.out.println("File value is \n" + dataFromFile);
        } catch (IOException e) {
        }
        return dataFromFile;
    }

    public final void setQuery(String query)
            throws SQLException, IllegalStateException ,MysqlDataTruncation{
        ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // specify query and execute it WATCH OUT: statement.executequery doesnot 
//        run on queries that return number of rows such as inserts, so I use statement.execute()
        //statement.execute(query);
        //resultSet = statement.getResultSet();
        ps.execute();
        resultSet = ps.getResultSet();
        if (resultSet != null) {//a resultset is null if it is an update, count, and I think insert
            // determine number of rows in ResultSet
            resultSet.last(); // move to last row
            numberOfRows = resultSet.getRow(); // get row number
            metaData = resultSet.getMetaData();
        } else {
            numberOfRows = 0;
        }

    }  // end method setQuery

    public int getColumnCount() throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // determine number of columns
        try {
            return metaData.getColumnCount();
        } // end try
        catch (SQLException sqlException) {
        } // end catch

        return 0; // if problems occur above, return 0 for number of columns
    } // end method getColumnCount

    // get name of a particular column in ResultSet
    public String getColumnName(int column) throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // determine column name
        try {
            return metaData.getColumnName(column + 1);
        } // end try
        catch (SQLException sqlException) {
        } // end catch

        return ""; // if problems, return empty string for column name
    } // end method getColumnName
    // return number of rows in ResultSet

    public int getRowCount() throws IllegalStateException {
        // ensure database connection is available

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        return numberOfRows;
    } // end method getRowCount

    public Object getValueAt(int row, int column)
            throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // obtain a value at specified ResultSet row and column
        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } // end try
        catch (SQLException sqlException) {
        } // end catch

        return ""; // if problems, return empty string object
    } // end method getValueAt

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void disconnectFromDatabase() {
        if (connectedToDatabase) {
// close Statement and Connection
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } // end try
            catch (SQLException sqlException) {
            } // end catch
            finally // update database connection status
            {
                connectedToDatabase = false;
            } // end finally
        } // end if
    } // end method disconnectFromDatabase

    public int Query(String sql) throws MysqlDataTruncation{
        try {
            statement = connection.createStatement();
            // System.out.println(sql);
            return statement.executeUpdate(sql);

        } catch (SQLException pp) {
            System.out.println(sql);
            System.out.println(pp.toString());
        }
        return 0;

    }

    public ArrayList ExecuteQuery(String sql) throws SQLException {
        ArrayList mresultSet = new ArrayList();
        try {
            if (connection != null) {
                statement = connection.createStatement();
                result = statement.executeQuery(sql);
                metadata = result.getMetaData();
                //  String[] res=null;
                int numcolls = metadata.getColumnCount();
                while (result.next()) {

                    for (int i = 1; i <= numcolls; i++) {

                        System.out.print(result.getString(i) + "\t");

                        mresultSet.add(result.getString(i));

                    }
                    System.out.println("");
                }
            }
        } catch (SQLException pp) {
            System.out.println(pp.toString());
        }

        if (mresultSet.isEmpty()) {
            mresultSet.add(0);
        }
        return mresultSet;
    }

    /**
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    private void initDB() throws Exception {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL database has been Driver loaded!");
        } catch (ClassNotFoundException e) {
            Dialogs.create().title("com.mysql.jdbc.Driver class not found in classpath!")
                    .masthead("Error connecting locatin com.mysql.jdbc.Driver class")
                    .message("Please add the MYSQL DRIVER to your classpath and retry")
                    .showException(e);
        }
        String url = "jdbc:mysql://localhost:3306/sams";
        String username = "sams";
        String password = "samsp";
        try {
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            Dialogs.create()
                    .title("Database Connection error")
                    .masthead("Error connecting to the database!")
                    .message(e.getMessage() + "\n\n").showException(e);
            throw e;

        } finally {
            System.out.println("Database Connection successful...\n"
                    + "Database connection successful\n\n");

        }
        statement = connection.createStatement();

    }
}
