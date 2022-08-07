package com.zzz.furn.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zzz.furn.bean.Furn;
import com.zzz.furn.dao.FurnMapper;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author zjlniubbb
 * @version 1.0
 */
public class FurnMapperTest {

    @Test
    public void insertSelective(){
        //获取容器
        ClassPathXmlApplicationContext ioc
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取furnMapper
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        System.out.println(furnMapper);
        Furn furn =
                new Furn(null, "北欧风格沙发~", "金龙家居~", new BigDecimal(180), 666, 7, "assets/images/product-image/1.jpg");
        furnMapper.insertSelective(furn);
        System.out.println("添加 OK");
    }


}
