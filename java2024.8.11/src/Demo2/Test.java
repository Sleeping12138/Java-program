package Demo2;

public class Test {
    public static void main(String[] args) {
        UnionFindSet ufs = new UnionFindSet(10);
        ufs.unionSet(1, 2);
        ufs.unionSet(2, 3);
        ufs.unionSet(3, 4);
        ufs.unionSet(5, 5);
        ufs.unionSet(6, 7);
        ufs.unionSet(7, 8);

        System.out.println(ufs.isSameSet(1,7));
    }
}
