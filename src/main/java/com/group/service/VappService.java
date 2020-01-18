package com.group.service;

import com.group.util.PageUtil;
import com.group.vo.Vappinfo;

public interface VappService {
    public PageUtil<Vappinfo> findAllBypage(Long pageNo);
    public PageUtil<Vappinfo> findSomeByPage(String softwareName,Long flatformId,Long categoryLevel1,Long categoryLevel2,Long categoryLevel3,Long pageNo);
    public Vappinfo findOne(Long aid);
}
