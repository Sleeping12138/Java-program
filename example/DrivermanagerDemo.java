package org.example;

import java.sql.*;
import java.text.MessageFormat;
import java.util.Scanner;

public class DrivermanagerDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 提供数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01?characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false", "root", "woshizjy12138");

            //执行sql语句
            statement = connection.createStatement();
            System.out.println("请输入想要查询的学生姓名：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            String sql = "select  student_id,sn,name,mail,class_id from student where name = '" + name + "'";
            resultSet = statement.executeQuery(sql);

            //处理结果集
            while (resultSet.next()) {
                String stu_id = resultSet.getString(1);
                String sn = resultSet.getString(2);
                String stu_name = resultSet.getString(3);
                String mail = resultSet.getString(4);
                String class_id = resultSet.getString(5);
                System.out.println(MessageFormat.format("{0} ，{1} ，{2} ,{3} ,{4}", stu_id, sn, stu_name, mail, class_id));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
