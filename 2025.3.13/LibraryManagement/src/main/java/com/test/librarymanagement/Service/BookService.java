package com.test.librarymanagement.Service;

import com.test.librarymanagement.BookInfo;
import com.test.librarymanagement.Mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookService {

    @Autowired
    private BookMapper bookMapper;
    public void setBookList(List<BookInfo> bookInfoList){
        for(BookInfo bookInfo : bookInfoList){
            if(bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
    }

    public List<BookInfo> getBookList() {
        return bookMapper.selectAllBooks();
    }

    public void addBook(BookInfo bookInfo) {
        bookMapper.insertBookInfo(bookInfo);
    }
}
