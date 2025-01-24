package com.test.librarymanagement.Controller;

import com.test.librarymanagement.BookInfo;
import com.test.librarymanagement.Dao.BookDao;
import com.test.librarymanagement.Service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        List<BookInfo> bookInfoList = mockData();
        BookService bookService = new BookService();
        bookService.setBookList(bookInfoList);
        return bookInfoList;
    }

    private List<BookInfo> mockData() {
        BookDao bookDao = new BookDao();
        return bookDao.getList();
    }
}
