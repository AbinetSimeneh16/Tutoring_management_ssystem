package ui;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;
import util.FileHandler;
import ui.RoleSelectionView;

public class LoginView {

    private VBox root = new VBox(10);
    private Stage stage;
    private String role;

    public LoginView(Stage stage, String role) {
        this.stage = stage;
        this.role = role;

        Label title = new Label(role + " LOGIN");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        if (role.equals("STUDENT")) {
            Button registerBtn = new Button("Register");
            registerBtn.setOnAction(e -> {
                StudentRegisterView view = new StudentRegisterView(stage);
                stage.getScene().setRoot(view.getView());
            });
            root.getChildren().add(registerBtn);
        }

        Label message = new Label();

        loginBtn.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean success = false;

            if (role.equals("ADMIN")) {
                success = FileHandler.validateLogin("admins.txt", username, password);
            }
            else if (role.equals("STUDENT")) {
                success = FileHandler.validateLogin("students.txt", username, password);
            }
            else if (role.equals("TUTOR")) {
                success = FileHandler.validateLogin("tutors.txt", username, password);
            }

            if (success) {
                message.setText("Login successful!");

                if (role.equals("STUDENT")) {
                    StudentView view = new StudentView(stage,username);
                    stage.getScene().setRoot(view.getView());
                }

                if (role.equals("TUTOR")) {
                    TutorView view = new TutorView(stage,username);
                    stage.getScene().setRoot(view.getView());
                }

                if (role.equals("ADMIN")) {
                    AdminView view = new AdminView(stage);
                    stage.getScene().setRoot(view.getView());
                }
            } else {
                message.setText("Invalid credentials");
            }
        });
        Button backBtn = new Button("Back");

        backBtn.setOnAction(e -> {
            RoleSelectionView view = new RoleSelectionView(stage);
            stage.getScene().setRoot(view.getView());
        });

        root.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                loginBtn,
                backBtn,
                message
        );
    }

    public VBox getView() {
        return root;
    }
}
