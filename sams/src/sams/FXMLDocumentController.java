package sams;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * TODO
 *
 * @author wepngong
 */
public class FXMLDocumentController implements Initializable {

    private Button instructorLoginButton;
    @FXML
    private Button exitButton;
    public static ScrollPane basePane;
    @FXML
    private Button attendanceButton;
    @FXML
    private Button reportsButton;
    @FXML
    private Label welcomebutton;

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameField;
    @FXML
    private Pane loginPane;
    @FXML
    private ImageView splashImage;
    @FXML
    private StackPane stackPane;
    @FXML
    private Button loginButton;
    @FXML
    private ComboBox<String> courseCombo;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> id;
    @FXML
    private TableColumn<Student, String> matriculeC;
    @FXML
    private TableColumn<Student, String> fNameC;
    @FXML
    private TableColumn<Student, String> lNameC;
    @FXML
    private TableColumn<Student, String> programmeC;
    @FXML
    private TableColumn<Student, String> levelC;
    @FXML
    private TableColumn<Student, CheckBox> roleCallC;
    @FXML
    private TableColumn<Student, String> attendanceC;
    @FXML
    private VBox choiceMenu;
    @FXML
    private Label loginFailure;
    @FXML
    private ScrollPane registrationPane;
    @FXML
    private ImageView logo;
    @FXML
    private BorderPane beginPane;
    @FXML
    private Button beginButton;
    @FXML
    private ScrollPane attendancePane;
    @FXML
    private Button registrationButton;
    @FXML
    private Button userLogout;
    @FXML
    private ImageView userPic;
    @FXML
    private VBox imagePane;
    @FXML
    private ImageView lecturerPic;
    @FXML
    private Button attendanceSubmit;
    @FXML
    private BorderPane attendanceBorderPane;
    @FXML
    private CheckBox lecturerCheckBox;
    @FXML
    private Button homeButton;
    @FXML
    private Button helpbutton;
    @FXML
    private Button adduserButton;
    @FXML
    private Label moduleNameLabel;
    public static boolean exitting;
    @FXML
    private TextField matriculeField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private ComboBox<String> facultyCombo;
    @FXML
    private ComboBox<String> departmentCombo;
    @FXML
    private ComboBox<String> programmeCombo;
    @FXML
    private ComboBox<String> levelCombo;
    @FXML
    private Button addUserButton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label time;
    //variables for reports module
    @FXML
    private SplitPane reportsRootPane;
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private Button dailyforAllcourses;
    @FXML
    private Button daiyPerCourse;
    @FXML
    private Button semesterWiseAttendance;
    @FXML
    private Button blacklistedStudents;
    @FXML
    private ComboBox<String> rFacultyCombo;
    @FXML
    private ComboBox<String> rdepartmentCombo;
    @FXML
    private ComboBox<String> rProgrammeCombo;
    @FXML
    private ComboBox<String> rCourseCombo;
    @FXML
    private TableColumn<?, ?> rMatriculeC;
    @FXML
    private TableColumn<?, ?> rFirstName;
    @FXML
    private TableColumn<?, ?> rLastName;
    @FXML
    private TableColumn<?, ?> rProgramme;
    @FXML
    private TableColumn<?, ?> rlevel;
    @FXML
    private TableColumn<?, ?> rPresent;
    @FXML
    private TableColumn<?, ?> rAbsent;
    @FXML
    private TableColumn<?, ?> rPercentAbsent;
    @FXML
    private TableColumn<?, ?> rRemarks;
    @FXML
    private TableView<?> reportsTable;
    @FXML
    private CheckBox adminCheckBox;
    @FXML
    private ComboBox<String> lecturerFacultyCombo;
    /*private variables*/
    private String userName;
    private String userFname;
    private String password;
    private String user_id;
    private Boolean isLoggedIn = false;
    private String courseTaught;
    private static DatabaseHelper db;
    private String date;
    private String faculty;
    private boolean isAdmin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        toggleVisibility();
        welcomebutton.setVisible(true);
        splashImage.setVisible(true);
        beginPane.setVisible(true);
        new AutoCompleteComboBoxListener(courseCombo);
        date = new Date(System.currentTimeMillis()).toString();
        try {
            db = new DatabaseHelper();

        } catch (Exception ex) {

        }

        courseCombo.setOnAction((ActionEvent event) -> {
            selectCourse(event);
        });
        //add screens to array

    }

    public void toggleVisibility() {
        reportsRootPane.setVisible(false);
        welcomebutton.setVisible(false);
        splashImage.setVisible(false);
        loginPane.setVisible(false);
        choiceMenu.setVisible(false);
        attendancePane.setVisible(false);
        beginPane.setVisible(false);
        userLogout.setVisible(false);
        loginFailure.setVisible(false);
        imagePane.setVisible(false);
        attendanceBorderPane.setVisible(false);
        registrationPane.setVisible(false);

    }

    public static DatabaseHelper getDatabaseHelperInstance() {
        return db;
    }

    @FXML
    private void leaveSystem(ActionEvent event) {
        if (Dialogs.create()
                .title("Exit Warning!")
                .masthead("Are You sure ?!")
                .message("Please Make sure you save whatever you\nWere doing before exiting"
                        + "").showConfirm() == Dialog.Actions.YES) {
            System.exit(9);
            exitting = true;
        }
    }

   //attendance handlers

    @FXML
    private void attendanceButtonClicked(ActionEvent event) throws Exception {
        toggleVisibility();
        userLogout.setVisible(true);
        String q = "select id, matricule,fname,last_name, programme,current_level"
                + " from student_info, student_takes_course where( student_matricule = matricule AND course_code =\""
                + courseTaught + "\") group by id;";
        TableClass tbc = new TableClass();
        //populate table
        //indicate all fields of the table
        tbc.makeTable(q, id, matriculeC, fNameC, lNameC, programmeC, levelC, roleCallC, attendanceC, studentTable);
        //populate the attendance table
        q = "select  student_matricule, count(student_id)  from student_attends_courses where course_code ='" + courseTaught
                + "' group by student_id";
        //add previous attendance to the table
        db.setQuery(q);
        ObservableList<Student> students = studentTable.getItems();
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < db.getRowCount(); j++) {
                //iterate the attendance resultSet
                if (students.get(i).getCol2().equals(db.getValueAt(j, 0))) {//student in attendance has same matricule
                    students.get(i).col8.setValue(db.getValueAt(j, 1).toString());//set the student's attendance record
                    continue;
                }
            }

        }
        attendancePane.setVisible(true);
        attendanceBorderPane.setVisible(true);
        imagePane.setVisible(true);
        moduleNameLabel.setText("SAMS-ATTENDANCE MODULE");
        time.setText(getTime());

    }

    @FXML
    private void reportsButtonClicked(ActionEvent event) throws SQLException {
        if (isAdmin) {
            Dialogs.create()
                    .title("Please Choose The Type of Report you will want from The left pane")
                    .masthead("Choose Report to View")
                    .message("Loading...").showInformation();
            toggleVisibility();
            reportsRootPane.setVisible(true);
            userLogout.setVisible(true);
        } else {
            Dialogs.create()
                    .title("ACCESS TO REPORTS MODULE DENIED!")
                    .masthead("Permission denied!!")
                    .message("PLEASE LOGIN AS AN ADMINISTRATOR TO PERFORM THIS ACTION!").showError();
        }
    }

    @FXML
    private void LoginClicked(ActionEvent event) throws SQLException {
        if (loginSuccessFull()) {
            toggleVisibility();
            choiceMenu.setVisible(true);
            Dialogs.create()
                    .title("Login successful")
                    .masthead("Successful Login!")
                    .message("Your Login credentials were successfully verified\n\n").showInformation();

            userLogout.setVisible(true);
            userName = userNameField.getText();
            password = passwordField.getText();
            userLogout.setText(userName + "[Logout]");
            isLoggedIn = true;
            if (lecturerCheckBox.isSelected()) {
                courseTaught = courseCombo.getEditor().getText();
            } else {
                faculty = lecturerFacultyCombo.getEditor().getText();
            }

        } else {
            Dialogs.create()
                    .title("Login Unsuccessful")
                    .masthead("Failed to Login!")
                    .message("Your Login credentials could not be successfully verified\n\nMake Sure Your course/ Faculty is correct")
                    .showError();
            loginFailure.setVisible(true);
        }
    }

    private boolean loginSuccessFull() throws SQLException {
        String q = "";
        if (lecturerCheckBox.isSelected()) {//login in as lecturer
            q = "SELECT staff_id,password FROM staff,staff_teaches_courses WHERE (staff_id='"
                    + userNameField.getText() + "' AND password ='"
                    + passwordField.getText() + "'";
            q += " AND course_code ='" + courseCombo.getEditor().getText() + "')";
            isAdmin = false;
        } else {//login in as admin. This query ensures the admin belongs to the faculty he has choosen
            q = " SELECT staff_id, password FROM staff, department WHERE (faculty_id='" + lecturerFacultyCombo.getEditor().getText()
                    + "' AND department.dept_id in (select dept_id from staff) AND (staff_id='" + userNameField.getText() + "' AND password='"
                    + passwordField.getText() + "'))";
            isAdmin = true;
        }
        if (db.connectedToDatabase) {
            db.setQuery(q);

            if (db.getRowCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void beginClicked(ActionEvent event) throws SQLException {
        toggleVisibility();
        loginPane.setVisible(true);

    }

    @FXML
    private void populateLecturerCombo(Event event) throws SQLException {
        new AutoCompleteComboBoxListener(lecturerFacultyCombo);
        String q = "SELECT DISTINCT faculty_id FROM faculties";
        if (db.connectedToDatabase) {
            ArrayList faculties = db.ExecuteQuery(q);
            lecturerFacultyCombo.setItems(FXCollections.observableArrayList(faculties));//populate combo with faculties
        }
    }

    @FXML
    private void beginMouseClick(MouseEvent event) {

    }

    @FXML
    private void logoutclicked(ActionEvent event) {
        isLoggedIn = false;
        userFname = null;
        password = null;
        passwordField.setText("");
        toggleVisibility();
        loginPane.setVisible(true);
        Dialogs.create()
                .title("Logout successful")
                .masthead("Logged out!")
                .message("You were successfully logged out of the system\n\nYou can login again \n").showInformation();

    }

    @FXML
    private void selectCourse(ActionEvent event) {
        courseTaught = courseCombo.getEditor().getText();
    }

    @FXML
    private void adminClicked(ActionEvent event) {
        if (adminCheckBox.isSelected()) {
            lecturerCheckBox.setSelected(false);
        }
    }

    @FXML
    private void selectLecturerFaculty(ActionEvent event) {
        if (adminCheckBox.isSelected()) {
            this.faculty = lecturerFacultyCombo.getEditor().getText();
        }
    }

    @FXML
    private void selectCourseClicked(MouseEvent event) {
        courseTaught = courseCombo.getEditor().getText();
    }

    @FXML
    private void lecturerClicked(ActionEvent event) throws SQLException {
        if (lecturerCheckBox.isSelected()) {
            populateCoursecombo();
            adminCheckBox.setSelected(false);
        }
    }

    @FXML
    private void lecturerMouseEntered(MouseEvent event) throws SQLException {

    }

    private void populateCoursecombo() throws SQLException {
        if (!userNameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String q = "SELECT course_code FROM staff_teaches_courses,staff WHERE (staff_id = \""
                    + userNameField.getText() + "\" AND staff_staff_id = staff_id AND password=\""
                    + passwordField.getText() + "\")";
            ArrayList coursesTaught = db.ExecuteQuery(q);
            if (!coursesTaught.isEmpty()) {
                courseCombo.setItems(FXCollections.observableArrayList(coursesTaught));
            }
        }
    }

    @FXML
    private void submitAttendance(ActionEvent event) throws Exception {
        ObservableList<Student> items = studentTable.getItems();
        if (datePicker.getEditor().getText().equals("")) {
            Dialogs.create().message("Please Choose the date before submitting results\n").showError();
            return;
        }
        String date = convertDate(datePicker.getEditor().getText());
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getCol7().isSelected()) {
                String matricule = items.get(i).getCol2();
                String id = items.get(i).getCol1();
                String staff_id = userName;
                String time = getTime();
                String q = "INSERT INTO student_attends_courses values( '"
                        + id + "','" + matricule + "','" + courseTaught + "','" + staff_id + "','" + date + "'," + 0 + ",'" + time + "')";
                try {
                    db.Query(q);
                } catch (Exception ex) {
                    Dialogs.create().message("Please some fields may be very long\nReduce lengths if possible an try again");
                }
            }
        }
        Dialogs.create().masthead("Refreshing page...\n").message("Attendance Taken\n").showInformation();
        attendanceButtonClicked(event);
    }

    @FXML
    private void gotoHome(ActionEvent event
    ) {
        toggleVisibility();
        splashImage.setVisible(true);
        welcomebutton.setVisible(true);
        beginPane.setVisible(true);
    }

    @FXML
    private void showHelp(ActionEvent event
    ) {
        try {
            Desktop.getDesktop().open(new File("doc.pdf"));
        } catch (Exception ex) {
            Dialogs.create()
                    .title("Error Opening file!")
                    .message("Some Error occured while opening the file\n"
                            + "Maybe There is no application associated with files of this type").showException(ex);

        }
    }

    @FXML
    private void chooseDate(ActionEvent event
    ) {
        //Date d = new Date(datePicker.getEditor().getText());
        date = datePicker.getEditor().getText();

    }

    private String convertDate(String text) {
        String t = "", d[] = text.split("/");//split where / is found
        for (int i = d.length - 1; i >= 0; i--) {
            t += d[i] + "/";//reverse the array 
        }
        return t;
    }

    private String getTime() {
        Time d = new Time(System.currentTimeMillis());
        return d.toString();
    }

    //registration handlers
    @FXML
    private void adduserToSystem(ActionEvent event) {
        if (isLoggedIn) {
            toggleVisibility();
            registrationPane.setVisible(true);
        } else {
            Dialogs.create()
                    .title("Login Needed!")
                    .message("Please Login before you continue!").showInformation();
            toggleVisibility();
            loginPane.setVisible(true);

        }
    }

    @FXML
    private void addUserToSystem(ActionEvent event) {
        if (Dialogs.create()
                .title("Warning!")
                .masthead("Are You sure the information is correct?!")
                .message("Please Make sure you verify the information provided\n Garbage In Garbage Out!!!"
                        + "").showConfirm() == Dialog.Actions.YES) {
            Dialogs.create()
                    .title("User Added!")
                    .message("The user has been added successfully!").showInformation();

        }
    }
    //reports handlers
 @FXML
    private void registrationButtonclicked(ActionEvent event) {
        toggleVisibility();
        registrationPane.setVisible(true);
        userLogout.setVisible(true);
        String q = "SELECT * ";
    }

    @FXML
    private void selectFaculty(ActionEvent event) {
    }

    @FXML
    private void selectDepartment(ActionEvent event) {
    }

    @FXML
    private void selectProgramme(ActionEvent event) {
    }

    @FXML
    private void selectLevel(ActionEvent event) {
    }

    @FXML
    private void getDailyAttendanceForAllCourses(ActionEvent event) {
    }

    @FXML
    private void dailyPerCourse(ActionEvent event) {
    }

    @FXML
    private void getSemesterWiseAttendance(ActionEvent event) {
    }

    @FXML
    private void selectRFaculty(ActionEvent event) {
    }

    @FXML
    private void selectRDepartment(ActionEvent event) {
    }

    @FXML
    private void selectRProgramme(ActionEvent event) {
    }

    @FXML
    private void selectRCourse(ActionEvent event) {
    }

    @FXML
    private void populateRFacultyCombo(Event event) throws SQLException {
        rFacultyCombo.setItems(lecturerFacultyCombo.getItems());
        rFacultyCombo.getEditor().setText(faculty);
        String q="SELECT dept_name from department WHERE faculty_id='"
                + faculty+"'";
        rdepartmentCombo.setItems(FXCollections.observableArrayList(db.ExecuteQuery(q)));
    }

    @FXML
    private void populateRProgramme(Event event) throws SQLException {
        String q = "SELECT distinct prog_name FROM programme, department WHERE (department.dept_id=programme.dept_id "
                + "AND department.faculty_id='" + faculty + "')";//select only programmes offered in that faculty
        rProgrammeCombo.setItems(FXCollections.observableArrayList(db.ExecuteQuery(q)));//populate  the combobox
    }

    @FXML
    private void populateRCourse(Event event) throws SQLException {
        String q = "SELECT course_code FROM courses WHERE faculty_id ='" + faculty + "'";//get courses in that faculty
        rCourseCombo.setItems(FXCollections.observableArrayList(db.ExecuteQuery(q)));

    }

}
