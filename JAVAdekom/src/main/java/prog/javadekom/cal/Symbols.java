package prog.javadekom.cal;

import java.util.LinkedList;

public class Symbols {
    private LinkedList<Byte> allSymbols;
    private int numberOfSymbols;
    public Symbols() {
        this.allSymbols = new LinkedList<>();
        this.numberOfSymbols = 0;
    }
    public int addSymbol(Byte symbol) {
        this.allSymbols.add(symbol);
        return numberOfSymbols;
    }

    public byte[] getAllSymbols() {
        Byte[] tmp = allSymbols.toArray(new Byte[0]);
        byte[] result = new byte[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    public Leaves moveInTree(String bajt ,int bitCount, Leaves leave0, Leaves seek) {
        if(bajt.charAt(bitCount) == '1') {
            seek = seek.getLeft();
        } else {
            seek = seek.getRight();
        }
        if(!seek.getZnak().equals("X")) {
            this.allSymbols.add(BinaryOperations.toByte(seek.getZnak()));
            seek = leave0;
        }
        return seek;
    }
}
