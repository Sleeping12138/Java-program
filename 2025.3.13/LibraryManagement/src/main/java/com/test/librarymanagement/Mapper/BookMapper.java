package com.test.librarymanagement.Mapper;

import com.test.librarymanagement.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book_info;")
    public List<BookInfo> selectAllBooks();

    @Insert("insert into book_info (book_name,author,count,price,publish,status) values " +
            "(#{bookName},#{author},#{count},#{price},#{publish} ,#{status})")
    public void insertBookInfo(BookInfo bookInfo);
}
