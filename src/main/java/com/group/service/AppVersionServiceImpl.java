package com.group.service;

import com.group.dao.AppVersionMapper;
import com.group.pojo.App_Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;
    @Override
    public App_Version findOne(Long vid) {
        return appVersionMapper.selectById(vid);
    }
}
