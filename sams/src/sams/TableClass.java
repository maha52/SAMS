/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Wepngong
 */
public class TableClass {

    DatabaseHelper db;

    public TableClass() throws SQLException, Exception {
        db = FXMLDocumentController.getDatabaseHelperInstance();

    }

    ObservableList<Student> composeData;

    public void makeTable(String query, TableColumn C1, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());

            composeData.add(trans);
        }

    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());

            composeData.add(trans);
        }

    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableColumn C3, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        C3.setCellValueFactory(new PropertyValueFactory<>("col3"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());
            trans.col3.setValue(db.getValueAt(i, 2).toString());

            composeData.add(trans);
        }

    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableColumn C3,
            TableColumn C4, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        C3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        C4.setCellValueFactory(new PropertyValueFactory<>("col4"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());
            trans.col3.setValue(db.getValueAt(i, 2).toString());
            trans.col4.setValue(db.getValueAt(i, 3).toString());

            composeData.add(trans);
        }

    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableColumn C3,
            TableColumn C4, TableColumn C5, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        C3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        C4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        C5.setCellValueFactory(new PropertyValueFactory<>("col5"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());
            trans.col3.setValue(db.getValueAt(i, 2).toString());
            trans.col4.setValue(db.getValueAt(i, 3).toString());
            trans.col5.setValue(db.getValueAt(i, 4).toString());

            composeData.add(trans);
        }

    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableColumn C3,
            TableColumn C4, TableColumn C5, TableColumn C6, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        C3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        C4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        C5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        C6.setCellValueFactory(new PropertyValueFactory<>("col6"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());
            trans.col3.setValue(db.getValueAt(i, 2).toString());
            trans.col4.setValue(db.getValueAt(i, 3).toString());
            trans.col5.setValue(db.getValueAt(i, 4).toString());
            trans.col6.setValue(db.getValueAt(i, 5).toString());

            composeData.add(trans);
        }
    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableColumn C3,
            TableColumn C4, TableColumn C5, TableColumn C6, TableColumn C7, TableView tabId) throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        C3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        C4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        C5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        C6.setCellValueFactory(new PropertyValueFactory<>("col6"));
        C7.setCellValueFactory(new PropertyValueFactory<>("col7"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());
            trans.col3.setValue(db.getValueAt(i, 2).toString());
            trans.col4.setValue(db.getValueAt(i, 3).toString());
            trans.col5.setValue(db.getValueAt(i, 4).toString());
            trans.col6.setValue(db.getValueAt(i, 5).toString());
            trans.col7.setCenterShape(true);
            trans.col7.setCursor(Cursor.HAND);
            composeData.add(trans);
        }
    }

    public void makeTable(String query, TableColumn C1, TableColumn C2, TableColumn C3, TableColumn C4, TableColumn C5, TableColumn C6, TableColumn C7, TableColumn C8, TableView tabId) throws SQLException {
        C1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        C2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        C3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        C4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        C5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        C6.setCellValueFactory(new PropertyValueFactory<>("col6"));
        C7.setCellValueFactory(new PropertyValueFactory<>("col7"));
        C8.setCellValueFactory(new PropertyValueFactory<>("col8"));

        composeData = FXCollections.observableArrayList();
        tabId.setItems(composeData);

        System.out.println("Printing the Users History");
        System.out.println("Query is \n" + query);
        db.setQuery(query);

        System.out.println("before loop");
        for (int i = 0; i < db.getRowCount(); i++) {
            Student trans = new Student();

            trans.col1.setValue(db.getValueAt(i, 0).toString());
            trans.col2.setValue(db.getValueAt(i, 1).toString());
            trans.col3.setValue(db.getValueAt(i, 2).toString());
            trans.col4.setValue(db.getValueAt(i, 3).toString());
            trans.col5.setValue(db.getValueAt(i, 4).toString());
            trans.col6.setValue(db.getValueAt(i, 5).toString());
            trans.col7.setCenterShape(true);
            trans.col7.setCursor(Cursor.HAND);
            trans.col8.setValue(db.getValueAt(i, 6).toString());
            composeData.add(trans);
        }

    }
}
