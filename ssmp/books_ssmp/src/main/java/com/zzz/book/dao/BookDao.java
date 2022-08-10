package com.zzz.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzz.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Repository
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
