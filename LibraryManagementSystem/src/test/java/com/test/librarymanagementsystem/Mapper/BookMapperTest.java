package com.test.librarymanagementsystem.Mapper;

import com.test.librarymanagementsystem.Model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void selectAllCount() {
        Integer number = bookMapper.selectAllCount();
        System.out.println(number);
    }

    @Test
    void selectBooksByPage() {
        List<BookInfo> bookInfoList = bookMapper.selectBooksByPage(0, 10);
        System.out.println(bookInfoList);
    }

    @Test
    void queryBookById() {
        BookInfo bookInfo = bookMapper.queryBookById(1);
        System.out.println(bookInfo);
    }
}