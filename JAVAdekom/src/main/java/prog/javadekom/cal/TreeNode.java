package prog.javadekom.cal;

public class TreeNode extends Leaves {
    private Leaves left = null;
    private Leaves right = null;
    private String znak = "";
    private boolean inuse = false;
    @Override
    public String getZnak() {
        return znak;
    }
    @Override
    public void setZnak(String znak) {
        this.znak = znak;
    }
    @Override
    public void addToZnak(char znak) {
        this.znak += znak;
    }
    @Override
    public Leaves getLeft() {
        return left;
    }
    @Override
    public void setLeft(Leaves left) {
        this.left = left;
    }
    @Override
    public Leaves getRight() {
        return right;
    }
    @Override
    public void setRight(Leaves right) {
        this.right = right;
    }
    @Override
    public boolean getInuse() {
        return inuse;
    }
    @Override
    public void setInuse(boolean inuse) {
        this.inuse = inuse;
    }

    public static Leaves[] addLeaves(Leaves[] leaves, int placeToConnect1, int placeToConnect2) {
        Leaves add = new TreeNode();
        add.setRight(leaves[placeToConnect1]);
        add.setLeft(leaves[placeToConnect2]);
        add.addToZnak('X');
        add.setInuse(true);
        leaves[placeToConnect1].setInuse(false);
        leaves[placeToConnect2] = add;
        return leaves;
    }
}
