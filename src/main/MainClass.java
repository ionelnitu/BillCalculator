package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainClass extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MySql mySql=new MySql();
        Person person=new Person();
        mySql.update("ione","Cristiana!",20.3);
        stage.show();
    }
}
