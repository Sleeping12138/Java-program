package Demo;

public class code1 {
    public static void main(String[] args) {
        printStr("A","B","C");
    }
    public static void printStr(String... str){
        for (String s : str) {
            System.out.println(s);
        }
    }
}
