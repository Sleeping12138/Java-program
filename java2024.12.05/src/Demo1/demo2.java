package Demo1;

public class demo2 {
    public static void main(String[] args) {
    }

    public int BinaryToDecimal(int binaryNumber) {

        int ret = 0;
        int index = 0;
        while (true) {
            if (binaryNumber == 0) {
                break;
            } else {
                int temp = binaryNumber % 10;
                ret += temp * Math.pow(2, index);
                binaryNumber = binaryNumber / 10;
                index++;
            }
        }
        return ret;
    }
}
