package sample.chapter.three;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.util.Locale;

public class BindingBidirectionalAndConverter extends Application {

    @Override
    public void start(Stage stage) {
        Slider s1 = new Slider(0, 100, 40);

        TextField tf1 = new TextField();
        tf1.textProperty().bindBidirectional(s1.valueProperty(),
                new NumberStringConverter());

        TextField tf2 = new TextField();
        tf2.textProperty().bindBidirectional(s1.valueProperty(),
                new NumberStringConverter(Locale.US, "Value: 0000.#"));

        // adding one more field to the previous example
        TextField tf3 = new TextField();
        tf3.textProperty().bindBidirectional(s1.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return number + " is good number";
            }

            @Override
            public Number fromString(String string) {
                return Double.valueOf(string.split(" ")[0]);
            }
        });


        VBox root = new VBox(40, s1, tf1, tf2, tf3);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 200, 250));
        stage.show();
    }
}