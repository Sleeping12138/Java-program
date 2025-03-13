package com.test.librarymanagement;

import com.test.librarymanagement.Mapper.MessageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryManagementApplicationTests {

    @Autowired
    private MessageMapper mapper;
    @Test
    void selectTest() {
        mapper.selectAllMessage();
    }

}
