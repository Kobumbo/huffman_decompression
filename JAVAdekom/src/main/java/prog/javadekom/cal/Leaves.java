package prog.javadekom.cal;
public abstract class Leaves {
    public abstract String getZnak();
    public abstract void setZnak(String znak);
    public abstract void addToZnak(char znak);
    public abstract Leaves getLeft();
    public abstract void setLeft(Leaves left);
    public abstract Leaves getRight();
    public abstract void setRight(Leaves right);
    public abstract boolean getInuse();
    public abstract void setInuse(boolean insue);
}
