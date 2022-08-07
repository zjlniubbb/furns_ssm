package com.zzz.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzz.furn.bean.Furn;
import com.zzz.furn.bean.Msg;
import com.zzz.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Controller
public class FurnController {

    @Autowired(required = false)
    FurnService furnService;

    @RequestMapping("/save")
    @ResponseBody
    public Msg save(@Valid @RequestBody Furn furn, Errors errors) {//将前端发送的 json 数据,转成 JavaBean 数据
        HashMap<String, Object> hashMap = new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError e : fieldErrors) {
            hashMap.put(e.getField(), e.getDefaultMessage());
        }
        List<Furn> all = furnService.findAll();
        for (Furn furn1 : all) {
           if (furn1.getName().equals(furn.getName())){

               return Msg.fail();
           }
        }


        if (hashMap.isEmpty()) {
            furnService.save(furn);
            return Msg.success();
        }else {
            return Msg.fail().add("errorMsg",hashMap);
        }
    }

    @RequestMapping("/furns")
    @ResponseBody
    public Msg findAll(){
        Msg msg = Msg.success();
        List<Furn> furns = furnService.findAll();
        return msg.add("furnsList",furns);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody Furn furn){
        furnService.update(furn);
        return Msg.success();
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id){
        furnService.del(id);
        return Msg.success();
    }

    @RequestMapping("/furnsByPage")
    @ResponseBody
    public Msg listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> furnList = furnService.findAll();
        PageInfo pageInfo = new PageInfo(furnList,pageSize);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @RequestMapping("/furnsBySearchPage")
    @ResponseBody
    public Msg listFurnsByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                        @RequestParam(defaultValue = "") String search){
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> furnList = furnService.findByCondition(search);
        PageInfo pageInfo = new PageInfo(furnList,pageSize);
        return Msg.success().add("pageInfo",pageInfo);

    }

}
