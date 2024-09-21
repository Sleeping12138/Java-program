package org.example;

import java.sql.*;
import java.text.MessageFormat;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. 加载数据库厂商提供的驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01?characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false", "root", "woshizjy12138");
            // 3. 创建Statement对象
            statement = connection.createStatement();
            // 4. 定义SQL并执行SQL语句
            System.out.println("请输入学生姓名：");
            Scanner scanner = new Scanner(System.in);
            // 接收用户的输入
            String name = scanner.next();
            String sql = "select student_id, sn, name, mail, class_id from student where name = '" + name + "'";
            // 5. 执行SQL，获取查询结果
            resultSet = statement.executeQuery(sql);
            // 6. 对结果集进行遍历，获取数据
            // 如果一下条有记录，返回true,没有则返回false
            while (resultSet.next()) {
                // 获取学生Id
                long stuId = resultSet.getLong(1);
                String stuSn = resultSet.getString(2);
                String stuName = resultSet.getString(3);
                String stuMail = resultSet.getString(4);
                long classId = resultSet.getLong(5);
                System.out.println(MessageFormat.format("学生编号={0}, 学号={1}, 学生姓名={2}, 邮箱={3}, 班级编号={4}", stuId, stuSn,
                        stuName, stuMail, classId));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 依次释放资源，关闭连接
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
