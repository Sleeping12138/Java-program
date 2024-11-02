package Demo1;

import java.io.File;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的目录: ");
        String rootDir = scanner.next();
        File rootFile = new File(rootDir);
        if (!rootFile.isDirectory()) {
            System.out.println("输入的不是目录！");
            return;
        }
        System.out.println("请输入要删除的关键字: ");
        String keyword = scanner.next();

        scanDir(rootFile, keyword);
    }

    private static void scanDir(File rootFile, String keyword) {
        // 1. 列出当前目录中包含的内容
        File[] files = rootFile.listFiles();
        if (files == null) {
            // 当前目录为空
            return;
        }
        // 2. 遍历当前目录中的内容
        for (File file : files) {
            System.out.println("遍历目录&文件: " + file.getAbsolutePath());
            // 3. 判断当前文件是目录还是普通文件.
            if (file.isFile()) {
                // 4. 如果是普通文件, 则判断文件名是否包含关键字
                dealFile(file, keyword);
            } else {
                // 5. 如果是目录, 则递归调用本方法
                scanDir(file, keyword);
            }
        }
    }

    private static void dealFile(File file, String keyword) {
        if (file.getName().contains(keyword)) {
            System.out.println("发现文件: " + file.getAbsolutePath() + ", 包含关键字! 是否删除? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                file.delete();
                System.out.println("文件已删除!");
            }
        }
    }
}
