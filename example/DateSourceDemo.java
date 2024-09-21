package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Scanner;

public class DateSourceDemo {
    public static void main(String[] args) {
        // 创建mysql数据源并进行初始化数据库信息
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://127.0.0.1:3306/test01?characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("woshizjy12138");

        // 将mysql数据源信息传递给JDBC数据源并创建连接
        DataSource dataSource = mysqlDataSource;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
             connection = dataSource.getConnection();

            // 先编写sql代码并通过prepareStatement创建statement
            String sql = "select  student_id,sn,name,mail,class_id from student where name = ?";
             statement = connection.prepareStatement(sql);

            // 后将参数传入
            System.out.println("请输入想要查询的学生姓名：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            statement.setString(1,name);

            // 执行sql代码
             resultSet = statement.executeQuery();

            //处理结果集
            while (resultSet.next()) {
                String stu_id = resultSet.getString(1);
                String sn = resultSet.getString(2);
                String stu_name = resultSet.getString(3);
                String mail = resultSet.getString(4);
                String class_id = resultSet.getString(5);
                System.out.println(MessageFormat.format("{0} ，{1} ，{2} ,{3} ,{4}", stu_id, sn, stu_name, mail, class_id));
            }

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
