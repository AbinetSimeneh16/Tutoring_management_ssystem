package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.LoginView;
import ui.RoleSelectionView;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        RoleSelectionView view = new RoleSelectionView(stage);
        Scene scene = new Scene(view.getView(), 400, 300);
        stage.setTitle("Tutoring Management System");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}



