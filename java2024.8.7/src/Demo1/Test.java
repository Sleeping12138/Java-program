package Demo1;

public class Test {
    public static void main(String[] args) {
        String str1 = "hello";
        boolean equals = str1.equals('c');
        System.out.println(equals);
    }

    public int numValue(char prev, char cur) {
        int number = 0;
        if (prev == 'I') {
            number = switch (cur) {
                case 'I' -> 1;
                case 'V' -> 4;
                case 'X' -> 9;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        } else if (prev == 'X') {
            number = switch (cur) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 40;
                case 'C' -> 90;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        } else if (prev == 'C') {
            number = switch (cur) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 400;
                case 'M' -> 9000;
                default -> 0;
            };
        } else {
            number = switch (cur) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        }
        return number;
    }
}
