package prog.javadekom.cal;

public class ConnectIndex {
    public static int connect (int numberOfSymbols, Leaves[] leaves) {
        int placeToConnect = 0;
        for(int j = numberOfSymbols - 1; j >= 0; j--) {
            if(leaves[j].getInuse()) {
                placeToConnect = j;
                break;
            }
        }
        return  placeToConnect;
    }

    public static int connect (int numberOfSymbols, Leaves[] leaves, int placeToConnect2) {
        int placeToConnect = 0;
        for(int j = numberOfSymbols - 1; j >= 0; j--) {
            if(leaves[j].getInuse() && j != placeToConnect2) {
                placeToConnect = j;
                break;
            }
        }
        return  placeToConnect;
    }
}
