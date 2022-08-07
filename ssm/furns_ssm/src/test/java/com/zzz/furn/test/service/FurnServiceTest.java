package com.zzz.furn.test.service;

import com.zzz.furn.bean.Furn;
import com.zzz.furn.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Name;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zjlniubbb
 * @version 1.0
 */
public class FurnServiceTest {
    private ApplicationContext ac;
    private FurnService furnService;

    @Before
    public void init() throws Exception {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        furnService = ac.getBean(FurnService.class);
    }

    @Test
    public void save() {
        Furn furn =new Furn(null, "伊拉克风格茶几", "伊拉克家居", new BigDecimal(20), 111, 3,null);
        furnService.save(furn);
        System.out.println("save ok");
    }

    @Test
    public void findAll(){
        List<Furn> furns = furnService.findAll();
        for (Furn furn : furns) {
            System.out.println("furn-"+furn);
        }
    }

    @Test
    public void update(){
        Furn furn =
                new Furn();
       furn.setId(12);
        furn.setName("奥特曼坐垫");
        furn.setMaker("M78星云");

        furnService.update(furn);
        System.out.println("update ok");
    }

    @Test
    public void del(){
        furnService.del(16);
        System.out.println("delete ok");
    }

    @Test
    public void findByCondition(){

        List<Furn> furns = furnService.findByCondition("");
        for (Furn furn : furns) {
            System.out.println("furn=>"+furn);
        }
    }


}
