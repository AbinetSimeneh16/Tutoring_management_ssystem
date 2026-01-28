package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoleSelectionView {

    private VBox root = new VBox(15);

    public RoleSelectionView(Stage stage) {

        Button adminBtn = new Button("Admin");
        Button studentBtn = new Button("Student");
        Button tutorBtn = new Button("Tutor");

        adminBtn.setOnAction(e -> {
            LoginView login = new LoginView(stage, "ADMIN");
            stage.setScene(new Scene(login.getView(), 400, 300));
        });

        studentBtn.setOnAction(e -> {
            LoginView login = new LoginView(stage, "STUDENT");
            stage.setScene(new Scene(login.getView(), 400, 300));
        });

        tutorBtn.setOnAction(e -> {
            LoginView login = new LoginView(stage, "TUTOR");
            stage.setScene(new Scene(login.getView(), 400, 300));
        });

        root.getChildren().addAll(adminBtn, studentBtn, tutorBtn);
    }

    public VBox getView() {
        return root;
    }
}

