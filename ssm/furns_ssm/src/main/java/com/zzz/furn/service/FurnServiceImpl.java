package com.zzz.furn.service;

import com.zzz.furn.bean.Furn;
import com.zzz.furn.bean.FurnExample;
import com.zzz.furn.dao.FurnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Service
public class FurnServiceImpl implements FurnService{

    @Autowired
    FurnMapper furnMapper;

    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
        return furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void del(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample = new FurnExample();
        FurnExample.Criteria criteria = furnExample.createCriteria();
        if (StringUtils.hasText(name)){
            criteria.andNameLike("%"+name+"%");
        }
        return furnMapper.selectByExample(furnExample);
    }



}
