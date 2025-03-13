package com.test.librarymanagement.Mapper;

import com.test.librarymanagement.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void selectAllBooks() {
        List<BookInfo> bookInfos = bookMapper.selectAllBooks();
        System.out.println(bookInfos);
    }

    @Test
    void insertBookInfo() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("a");
        bookInfo.setAuthor("a");
        bookInfo.setCount(89);
        bookInfo.setPrice(new BigDecimal("89.7"));
        bookInfo.setPublish("a");
        bookInfo.setStatus(1);
        bookMapper.insertBookInfo(bookInfo);
    }
}
