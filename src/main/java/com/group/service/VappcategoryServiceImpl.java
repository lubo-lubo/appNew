package com.group.service;

import com.group.dao.VappcategoryMapper;
import com.group.vo.Vappcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VappcategoryServiceImpl implements VappcategoryService {
    @Autowired
    private VappcategoryMapper vappcategoryMapper;

    @Override
    public List<Vappcategory> findAll() {
        return vappcategoryMapper.findAll();
    }
}
