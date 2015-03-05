/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author MUNDE
 */
public class Student {

    public final SimpleStringProperty col1;
    public final SimpleStringProperty col2;
    public final SimpleStringProperty col3;
    public final SimpleStringProperty col4;
    public final SimpleStringProperty col5;
    public final SimpleStringProperty col6;
    public final CheckBox col7;

    public Student() {
        this.col1 = new SimpleStringProperty();
        this.col2 = new SimpleStringProperty();
        this.col3 = new SimpleStringProperty();
        this.col4 = new SimpleStringProperty();
        this.col5 = new SimpleStringProperty();
        this.col6 = new SimpleStringProperty();
        this.col7 = new CheckBox();
    }
//     public  final SimpleStringProperty col8 = new SimpleStringProperty();   
//     public  final SimpleStringProperty col9 = new SimpleStringProperty();

    public String getCol1() {

        return col1.get();

    }

    public String getCol2() {

        return col2.get();

    }

    public String getCol3() {

        return col3.get();

    }

    public String getCol4() {

        return col4.get();

    }

    public String getCol5() {

        return col5.get();

    }

    public String getCol6() {

        return col6.get();

    }

    public CheckBox getCol7() {

        return col7;

    }

}
