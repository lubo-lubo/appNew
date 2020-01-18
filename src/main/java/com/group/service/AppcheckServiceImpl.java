package com.group.service;

import com.group.dao.AppCheckMapper;
import com.group.pojo.App_check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppcheckServiceImpl implements AppcheckService {
    @Autowired
    private AppCheckMapper appCheckMapper;

    @Override
    public App_check findOne(Long aid) {
        return appCheckMapper.selectOne(aid);
    }
}
