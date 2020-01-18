package com.group.service;

import com.group.dao.VAppInfoMapper;
import com.group.util.PageUtil;
import com.group.vo.Vappinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VappServiceImpl implements VappService {
    @Autowired
    private VAppInfoMapper vAppInfoMapper;
    @Override
    public PageUtil<Vappinfo> findAllBypage(Long pageNo) {
        int pageNumber=Integer.valueOf(String.valueOf(pageNo));
        PageUtil<Vappinfo> page=new PageUtil<>();
        page.setTotalCount(vAppInfoMapper.findAll().size());
        page.setPageSize(5);
        page.setPageNo(pageNumber);
        List<Vappinfo> list=vAppInfoMapper.findAllByPage((long)page.getItem());
        page.settList(list);
        return page;
    }

    @Override
    public PageUtil<Vappinfo> findSomeByPage(String softwareName, Long flatformId, Long categoryLevel1, Long categoryLevel2, Long categoryLevel3, Long pageNo) {
        int pageNumber=Integer.valueOf(String.valueOf(pageNo));
        PageUtil<Vappinfo> page=new PageUtil<>();
        page.setTotalCount(vAppInfoMapper.findSome(softwareName, flatformId, categoryLevel1, categoryLevel2,categoryLevel3).size());
        page.setPageSize(5);
        page.setPageNo(pageNumber);
        List<Vappinfo> list=vAppInfoMapper.findSomeByPage(softwareName, flatformId, categoryLevel1, categoryLevel2,categoryLevel3,page.getItem());
        page.settList(list);
        return page;
    }

    @Override
    public Vappinfo findOne(Long aid) {
        return vAppInfoMapper.selectOne(aid);
    }
}
