package com.test.librarymanagementsystem.Controller;

import com.test.librarymanagementsystem.Constant.Constants;
import com.test.librarymanagementsystem.Model.BookInfo;
import com.test.librarymanagementsystem.Model.BookList;
import com.test.librarymanagementsystem.Model.PageRequest;
import com.test.librarymanagementsystem.Model.Result;
import com.test.librarymanagementsystem.Service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getListByPage")
    public Result<BookList> getListByPage(PageRequest pageRequest, HttpSession httpSession){
        log.info("pageRequest:{}",pageRequest);
        if(httpSession.getAttribute(Constants.USER_INFO_SESSION)==null){
            return Result.UNLOGIN();
        }
        Integer total = bookService.selectAllCount();
        List<BookInfo> bookInfoList = bookService.selectBooksByPage(pageRequest);

        return Result.SUCCESS(new BookList(total,bookInfoList,pageRequest));
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        log.info("bookInfo:{}",bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount()==null
                || bookInfo.getPrice()==null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() ==null
        ) {
            return "输入参数不合法, 请检查入参!";
        }

        try {
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("添加图书失败...");
            return e.getMessage();
        }
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(@RequestParam("bookId") Integer id){
        BookInfo bookInfo = bookService.queryBookById(id);
        return bookInfo;
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo){
        try {
            bookService.updateBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("参数错误...");
            return e.getMessage();
        }
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") Integer id){
        log.info("id=="+id);
        try {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(id);
            bookInfo.setStatus(0);
            bookService.updateBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("参数有问题...");
            return e.getMessage();
        }
    }

    @RequestMapping("/batchDeleteBook")
    public boolean batchDeleteBook(@RequestParam List<Integer> ids){
        log.info("批量删除图书, ids:{}", ids);
        try {
            bookService.batchDelete(ids);
            return true;
        }catch (Exception e) {
            log.error("批量删除图书失败, e:", e);
            return false;
        }
    }
}
