package ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.FileHandler;

public class TutorView {

    private VBox root = new VBox(10);

    public TutorView(String tutor) {
        root.getChildren().add(new Label("Tutor: " + tutor));

        for (String line : FileHandler.read(FileHandler.SCHEDULES)) {
            if (line.startsWith(tutor + ",")) {
                root.getChildren().add(new Label(line));
            }
        }
    }

    public Parent getView() {
        return root;
    }
}
