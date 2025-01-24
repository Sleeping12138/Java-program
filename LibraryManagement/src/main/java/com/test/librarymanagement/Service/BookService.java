package com.test.librarymanagement.Service;

import com.test.librarymanagement.BookInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookService {
    public void setBookList(List<BookInfo> bookInfoList){
        for(BookInfo bookInfo : bookInfoList){
            if(bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
    }
}
