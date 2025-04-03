package prog.javadekom.cal;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Objects;

public class HuffmanTreeDisplay {
    private static final int CIRCLE_RADIUS = 20;
    private static final int VERTICAL_GAP = 150;

    public static void displayHuffmanTree(Leaves root, Pane pane) {
        Group treeGroup = new Group();
        int deep = DeepCheck.check(root) - 2;
        int startGap = (int)(25 * Math.pow(2, deep));
        if (root != null) {
            displayNode(root, treeGroup, pane.getWidth() / 2, 100, startGap);
        }

        pane.getChildren().clear();
        pane.getChildren().add(treeGroup);

        MouseControl.initMouseControl(pane);
    }

    private static void displayNode(Leaves node, Group treeGroup, double x, double y, double hGap) {
        Circle circle = new Circle(x, y, CIRCLE_RADIUS);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        treeGroup.getChildren().add(circle);

        if (!Objects.equals(node.getZnak(), "X")) {
            String binary = node.getZnak();
            int decimalval = Integer.parseInt(binary, 2);
            byte byteval = (byte) decimalval;
            char character = (char) byteval;
            Text text = new Text(x - CIRCLE_RADIUS / 3.5, y + CIRCLE_RADIUS / 2.0, String.valueOf(character));
            text.setFont(Font.font(CIRCLE_RADIUS / 0.9));
            treeGroup.getChildren().add(text);
        }

        if (node.getLeft() != null) {
            double leftX = x - hGap;
            double leftY = y + VERTICAL_GAP;
            displayNode(node.getLeft(), treeGroup, leftX, leftY, hGap / 2);
            connectNodes(x, y, leftX, leftY, treeGroup);
        }

        if (node.getRight() != null) {
            double rightX = x + hGap;
            double rightY = y + VERTICAL_GAP;
            displayNode(node.getRight(), treeGroup, rightX, rightY, hGap / 2);
            connectNodes(x, y, rightX, rightY, treeGroup);
        }
    }

    private static void connectNodes(double startX, double startY, double endX, double endY, Group treeGroup) {
        Line line = new Line(startX, startY + CIRCLE_RADIUS, endX, endY - CIRCLE_RADIUS);
        treeGroup.getChildren().add(line);
    }
}
