package com.zzz.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzz.book.domain.Book;

/**
 * @author zjlniubbb
 * @version 1.0
 */
public interface BookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize);
    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
