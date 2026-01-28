package ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.FileHandler;

public class StudentView {

    private VBox root = new VBox(10);

    public StudentView(String student) {
        root.getChildren().add(new Label("Student: " + student));

        for (String line : FileHandler.read(FileHandler.SCHEDULES)) {
            if (line.contains("," + student + ",")) {
                root.getChildren().add(new Label(line));
            }
        }
    }

    public Parent getView() {
        return root;
    }
}

