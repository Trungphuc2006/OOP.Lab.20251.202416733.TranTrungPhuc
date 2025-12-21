// PainterController.java – perfect implementation of Pen/Eraser as per hint
package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML private Pane drawingAreaPane;
    @FXML private ToggleGroup toolGroup;

    private boolean isEraser = false;

    @FXML
    private void initialize() {
        toolGroup.selectedToggleProperty().addListener((obs, old, newT) -> {
            if (newT != null) {
                isEraser = "ERASER".equals(newT.getUserData());
            }
        });
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double radius = isEraser ? 10 : 4;           // eraser bigger
        Color color   = isEraser ? Color.WHITE : Color.BLACK;

        Circle dot = new Circle(event.getX(), event.getY(), radius, color);
        drawingAreaPane.getChildren().add(dot);
    }

    @FXML
    void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}