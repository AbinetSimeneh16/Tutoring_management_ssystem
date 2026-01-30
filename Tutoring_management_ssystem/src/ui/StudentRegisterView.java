package ui;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import util.FileHandler;
import java.io.FileWriter;



public class StudentRegisterView {

    private VBox root = new VBox(10);

    public StudentRegisterView() {

        Label title = new Label("Student Registration");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerBtn = new Button("Register");
        Label message = new Label();

        registerBtn.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                message.setText("All fields required");
                return;
            }

            FileHandler.writeToFile(
                    "students.txt",
                    username + "," + password
            );

            message.setText("Registration successful! You can now login.");
        });

        root.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                registerBtn,
                message
        );
    }

    public VBox getView() {

        return root;
    }
}

