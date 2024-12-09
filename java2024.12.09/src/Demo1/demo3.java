package Demo1;

import java.io.*;

class Computer implements Serializable {
    private String brand;
    private int storage;

    public Computer(String brand, int storage) {
        this.brand = brand;
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }
}

public class demo3 {
    public static void main(String[] args) {
        Computer myComputer = new Computer("Dell", 512);

        try {
            FileOutputStream fileOut = new FileOutputStream("computer");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myComputer);
            out.close();
            fileOut.close();
            System.out.println("保存成功");
        } catch (IOException i) {
            i.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("computer");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Computer deserializedComputer = (Computer) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("品牌: " + deserializedComputer.getBrand());
            System.out.println("存储容量: " + deserializedComputer.getStorage() + "GB");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("错误");
            c.printStackTrace();
        }
    }
}
