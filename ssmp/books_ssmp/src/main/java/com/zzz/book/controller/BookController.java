package com.zzz.book.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzz.book.domain.Book;
import com.zzz.book.service.BookService;
import com.zzz.book.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public MyUtils getAll(){
        return new MyUtils(true,bookService.list());
    }

   @PostMapping
    public MyUtils add(@RequestBody Book book)  {
       boolean flag = bookService.save(book);
       return new MyUtils(flag,null,flag?"添加成功^_^":"添加失败-_-!");
   }

   @DeleteMapping("{id}")
    public MyUtils delete(@PathVariable Integer id){
       boolean flag = bookService.removeById(id);
       return new MyUtils(flag,null,flag?"删除成功^_^":"删除失败-_-!");
   }

   @PutMapping
    public MyUtils update(@RequestBody Book book){
       boolean flag = bookService.updateById(book);
       return new MyUtils(flag,null,flag?"修改成功^_^":"修改失败-_-!");
   }

   @GetMapping("{id}")
    public MyUtils getById(@PathVariable Integer id){
       Book book = bookService.getById(id);
       return new MyUtils(true,book);
   }

   @GetMapping("{currentPage}/{pageSize}")
    public MyUtils getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
       IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
       if (currentPage>page.getPages()){
           page = bookService.getPage((int)page.getPages(),pageSize);
       }
       return new MyUtils(true,page);
   }

}
