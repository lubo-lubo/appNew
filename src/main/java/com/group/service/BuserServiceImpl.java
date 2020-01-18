package com.group.service;

import com.group.dao.BackendUserMapper;
import com.group.pojo.Backend_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuserServiceImpl implements BuserService{
    @Autowired
    private BackendUserMapper backendUserMapper;
    @Override
    public Backend_User login(String userCode) {
        Backend_User user=backendUserMapper.findOne(userCode);
        return user;
    }

    @Override
    public List<Backend_User> findAll() {
        return backendUserMapper.findAll();
    }
}
