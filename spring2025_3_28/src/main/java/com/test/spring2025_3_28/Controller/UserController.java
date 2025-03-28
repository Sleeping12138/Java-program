package com.test.spring2025_3_28.Controller;

import com.test.spring2025_3_28.Service.UserService;
import jakarta.annotation.sql.DataSourceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

//    @RequestMapping("/registry")
//    public String registry(String name, String password) {
//        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
//        //用户注册
//        userService.registryUser("zhangsan", "11111");
//
//        dataSourceTransactionManager.rollback(transaction);
//        return "注册成功";
//    }

    @Transactional(rollbackFor = ArithmeticException.class)
    @RequestMapping("/registry")
    public String registry(String name, String password) {
        //用户注册
        try {
            userService.registryUser("zhangsan", "11111");
            int a = 10/0;
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "注册成功";
    }
}
