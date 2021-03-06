package sample.chapter.six;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SetStyleDemo extends Application {
    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);
        Scene scene = new Scene(root, 300, 250);
        TextField fontSize, width, height;

        root.addRow(0, new Label("font size"), fontSize = new TextField("30"));
        root.addRow(1, new Label("width"), width = new TextField("100"));
        root.addRow(2, new Label("height"), height = new TextField("80"));

        Button btnApply = new Button("apply");
        btnApply.setOnAction((e) -> btnApply.setStyle(
                "-fx-font-size: " + fontSize.getText() + ";" +
                        "-fx-min-width: " + width.getText() + ";" +
                        "-fx-min-height: " + height.getText()
        ));
        root.add(btnApply, 1, 3);

        stage.setTitle("setStyle Demo");
        stage.setScene(scene);
        stage.show();
    }
}