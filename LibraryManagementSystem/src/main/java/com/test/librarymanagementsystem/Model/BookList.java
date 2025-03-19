package com.test.librarymanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookList {
    private Integer total;
    private List<BookInfo> bookInfos;
    private PageRequest pageRequest;
}
