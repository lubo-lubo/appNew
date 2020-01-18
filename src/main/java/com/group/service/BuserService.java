package com.group.service;

import com.group.pojo.Backend_User;

import java.util.List;

public interface BuserService {
    public Backend_User login(String userCode);
    public List<Backend_User>  findAll();
}
