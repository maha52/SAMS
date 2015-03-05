package sams;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author wepngong
 */
public class SAMS extends Application {

    /**
     * This gives the current instance of SAMS main module so it can be
     * manipulated from outside the class
     */
    protected static SAMS instance;
    Stage stage;

    public SAMS() {
        instance = this;

    }

    public static SAMS getInstance() {
        return instance;
    }

    @Override
    public void start(Stage mstage) throws Exception {
        stage = mstage;
        ScrollPane sp = new ScrollPane(FXMLLoader.load(getClass().getResource("SAMSFXML.fxml")));
        Scene scene = new Scene(sp);
        stage.setTitle("SAMS-STUDENT ATTENDANCE MANAGEMENT SYSTEM FOR THE UNIVERSITY OF BUEA");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/make-things-better.png")));
        stage.setMinWidth(1362);
        stage.setMinHeight(707);
        stage.setResizable(true);
        stage.show();
        stage.setOnCloseRequest(this::windowHandler);
    }

    private void windowHandler(WindowEvent event) {//user attempts to close the window
        if (Dialogs.create().title("Exit Warning!").masthead("Are You sure you want to quit?!")
                .message("Please Make sure you save whatever you\nWere doing before exiting").showConfirm() == Dialog.Actions.YES) {
            FXMLDocumentController.exitting = true;
            System.exit(0);
        } else {
            event.consume();
        } //don't close window if user disapproves 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
