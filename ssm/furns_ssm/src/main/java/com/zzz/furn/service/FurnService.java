package com.zzz.furn.service;

import com.zzz.furn.bean.Furn;

import java.util.List;

/**
 * @author zjlniubbb
 * @version 1.0
 */
public interface FurnService {

    public void save(Furn furn);

    public List<Furn> findAll();

    public void update(Furn furn);

    public void del(Integer id);

    public List<Furn> findByCondition(String name);



}
