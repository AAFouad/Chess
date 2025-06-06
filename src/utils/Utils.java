package utils;

public class Utils {

    public static boolean isOut(int index){
        if( index < 0 || index > 63 ){
            return true;
        }
        else {
            return false;
        }
    }

    public static int toIndex(int fileIndex, int rankIndex) {
        int index = ( rankIndex * 8 ) + fileIndex;
        return index;
    }

    public static int ICCFtoIndex(int coordinate){
        int rank = coordinate % 10;
        int file = coordinate / 10;
        int index = ( (rank-1)*8  ) + (file-1);
        return index;
    }

}
