package com.group.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.group.pojo.Backend_User;

import java.util.List;

public interface BackendUserMapper extends BaseMapper<Backend_User> {
    public Backend_User findOne(String userCode);
    public List<Backend_User> findAll();
}
