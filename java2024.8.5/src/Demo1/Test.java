package Demo1;

import java.util.BitSet;

public class Test {
    public static void main(String[] args) {
//        MyBitSet myBitSet = new MyBitSet(20);
//        myBitSet.set(1);
//        myBitSet.set(4);
//        myBitSet.set(7);
//        myBitSet.set(9);
//        myBitSet.set(2);
//        myBitSet.set(10);
//        myBitSet.set(3);
//        myBitSet.set(6);
//        myBitSet.set(8);
//
//        myBitSet.print();


        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();

        bitSet1.set(1);
        bitSet1.set(2);
        bitSet1.set(3);

        bitSet2.set(4);
        bitSet2.set(5);
        bitSet2.set(6);

        bitSet1.or(bitSet2);
        System.out.println(bitSet1);

        bitSet1.cardinality()

    }
}
