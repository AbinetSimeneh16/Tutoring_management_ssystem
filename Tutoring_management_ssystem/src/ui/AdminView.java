package ui;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.FileHandler;
import ui.RoleSelectionView;

public class AdminView {

    private VBox root = new VBox(10);

    public AdminView(Stage stage) {

        TextField tutorName = new TextField();
        tutorName.setPromptText("Tutor Username");

        TextField tutorPass = new TextField();
        tutorPass.setPromptText("Tutor Password");

        TextField subject = new TextField();
        subject.setPromptText("Subject");

        TextField student = new TextField();
        student.setPromptText("Student Username");

        TextField day = new TextField();
        day.setPromptText("Day");

        TextField time = new TextField();
        time.setPromptText("Time");

        Button addTutor = new Button("Register Tutor");
        Button assign = new Button("Assign Tutor");

        addTutor.setOnAction(e ->
                FileHandler.write(FileHandler.TUTORS,
                        tutorName.getText()+","+tutorPass.getText()+","+subject.getText())
        );

        assign.setOnAction(e ->
                FileHandler.write(FileHandler.SCHEDULES,
                        tutorName.getText()+","+student.getText()+","+subject.getText()+","+day.getText()+","+time.getText())
        );
        Button logoutBtn = new Button("Logout");

        logoutBtn.setOnAction(e -> {
            RoleSelectionView view = new RoleSelectionView(stage);
            stage.getScene().setRoot(view.getView());
        });

        root.getChildren().addAll(
                new Label("ADMIN PANEL"),
                tutorName, tutorPass, subject,
                addTutor,
                logoutBtn,
                student, day, time,
                assign
        );
    }

    public Parent getView() {
        return root;
    }
}
