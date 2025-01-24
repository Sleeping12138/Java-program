package com.test.librarymanagement.Dao;

import com.test.librarymanagement.BookInfo;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BookDao {
    public List<BookInfo> getList(){
        List<BookInfo> books = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BookInfo book = new BookInfo();
            book.setId(i);
            book.setBookName("书籍" + i);
            book.setAuthor("作者" + i);
            book.setCount(i * 5 + 3);
            book.setPrice(new BigDecimal(new Random().nextInt(100)));
            book.setPublish("出版社" + i);
            book.setStatus(1);
            books.add(book);
        }
        return books;
    }
}
