package com.test.librarymanagementsystem.Mapper;

import com.test.librarymanagementsystem.Model.BookInfo;
import com.test.librarymanagementsystem.Model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select count(1) from book_info")
    Integer selectAllCount();

    @Select("select * from book_info where status != 0 limit #{page},#{pageSize};")
    List<BookInfo> selectBooksByPage(Integer page,Integer pageSize);

    @Insert("insert into book_info (book_name,author,count,price,publish,status) " +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    void addBook(BookInfo bookInfo);

    @Select("select * from book_info where id = #{id}")
    BookInfo queryBookById(Integer id);

    void updateBook(BookInfo bookInfo);

    void batchDelete(List<Integer> ids);
}
