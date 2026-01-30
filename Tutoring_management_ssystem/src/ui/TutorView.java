package ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.FileHandler;
import javafx.scene.control.Button;
import ui.RoleSelectionView;
import javafx.stage.Stage;

public class TutorView {

    private VBox root = new VBox(10);

    public TutorView(Stage stage, String tutor) {
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            RoleSelectionView view = new RoleSelectionView(stage);
            stage.getScene().setRoot(view.getView());
        });
        root.getChildren().addAll(new Label("Tutor: " + tutor),logoutBtn);

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
