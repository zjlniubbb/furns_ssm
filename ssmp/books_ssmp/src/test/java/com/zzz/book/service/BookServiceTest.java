package com.zzz.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzz.book.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testGetPage(){
        IPage<Book> page = bookService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

}
