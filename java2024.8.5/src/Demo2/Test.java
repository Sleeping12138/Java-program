package Demo2;

public class Test {
    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.set(1);
        bloomFilter.set(2);
        bloomFilter.set(3);
        bloomFilter.set(4);
        bloomFilter.set(5);
        bloomFilter.set(6);
        bloomFilter.set(7);
        bloomFilter.set(8);

        System.out.println(bloomFilter.contains(10));
    }
}
