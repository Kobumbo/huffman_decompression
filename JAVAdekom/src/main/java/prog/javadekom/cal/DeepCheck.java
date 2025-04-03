package prog.javadekom.cal;
import static prog.javadekom.cal.Dekom.*;

public class DeepCheck {
    public static int check(Leaves root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = check(root.getLeft());
            int rightDepth = check(root.getRight());
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
