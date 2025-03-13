package com.test.librarymanagement.Controller;

import com.test.librarymanagement.BookInfo;
import com.test.librarymanagement.Dao.BookDao;
import com.test.librarymanagement.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        return bookService.getBookList();
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        log.info("添加图书:{}", bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount()==null
                || bookInfo.getPrice()==null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() ==null
        ) {
            return "输入参数不合法";
        }
        try {
            bookService.addBook(bookInfo);
            return "";
        } catch (Exception e) {
            log.error("添加图书失败", e);
            return e.getMessage();
        }
    }
}
