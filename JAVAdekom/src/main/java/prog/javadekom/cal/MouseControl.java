package prog.javadekom.cal;


import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

public class MouseControl {
    private static final double MAX_ZOOM_OUT = 0.5; // Maximum zoom-out
    private static final double MAX_ZOOM_IN = 2.0; // Maximum zoom-in

    public static void initMouseControl(Pane pane) {
        pane.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();

            if (deltaY < 0) {
                // Zoom out
                if (pane.getScaleX() > MAX_ZOOM_OUT && pane.getScaleY() > MAX_ZOOM_OUT) {
                    scaleChildren(pane, 1.0 / zoomFactor);
                }
            } else {
                // Zoom in
                if (pane.getScaleX() < MAX_ZOOM_IN && pane.getScaleY() < MAX_ZOOM_IN) {
                    scaleChildren(pane, zoomFactor);
                }
            }
            event.consume();
        });
    }

    private static void scaleChildren(Pane pane, double scale) {
        for (javafx.scene.Node child : pane.getChildren()) {
            child.setScaleX(child.getScaleX() * scale);
            child.setScaleY(child.getScaleY() * scale);
        }
    }
}


