package prog.javadekom.cal;

public class Decode {
    public static void decode(int i, byte[] data, int bitCount, int numberOfBits, String bajt ,Leaves seek, Leaves leave0, Symbols symbols) {
        if(i != data.length - 2) {
            if(bitCount != 0) {
                i++;
                while(bitCount < 8 && bitCount != 0) {
                    seek = symbols.moveInTree(bajt, bitCount, leave0, seek);
                    bitCount++;
                }
            }
        } else {
            i++;
            while(bitCount + numberOfBits < 8) {
                seek = symbols.moveInTree(bajt, bitCount, leave0, seek);
                bitCount++;
            }
        }
        for(i--; i < data.length - 3; i++) {
            bajt = BinaryOperations.toString(data[i]);
            bitCount = 0;
            while(bitCount < 8) {
                seek = symbols.moveInTree(bajt, bitCount, leave0, seek);
                bitCount++;
            }
        }
        if(i != data.length - 2) {
            bajt = BinaryOperations.toString(data[i]);
            bitCount = 0;
            while(8 - numberOfBits > 0) {
                seek = symbols.moveInTree(bajt, bitCount, leave0, seek);
                bitCount++;
                numberOfBits++;
            }
        }
    }
}
