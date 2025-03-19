package com.test.librarymanagementsystem.Service;

import com.test.librarymanagementsystem.Enum.BookStatusEnum;
import com.test.librarymanagementsystem.Mapper.BookMapper;
import com.test.librarymanagementsystem.Model.BookInfo;
import com.test.librarymanagementsystem.Model.BookList;
import com.test.librarymanagementsystem.Model.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public Integer selectAllCount() {
        return bookMapper.selectAllCount();
    }

    public List<BookInfo> selectBooksByPage(PageRequest pageRequest) {
        Integer currentPage = pageRequest.getCurrentPage();
        Integer pageSize = pageRequest.getPageSize();

        Integer page = (currentPage - 1) * 10;

        List<BookInfo> bookInfoList =  bookMapper.selectBooksByPage(page, pageSize);
        for (BookInfo bookInfo : bookInfoList){
            bookInfo.setStatusCN(BookStatusEnum.getStatusByCode(bookInfo.getStatus()));
        }

        return bookInfoList;
    }

    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }

    public BookInfo queryBookById(Integer id) {
        return bookMapper.queryBookById(id);
    }

    public void updateBook(BookInfo bookInfo) {
        bookMapper.updateBook(bookInfo);
    }

    public void batchDelete(List<Integer> ids) {
        bookMapper.batchDelete(ids);
    }
}
