package com.group.dao;

import com.group.vo.Vappinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VAppInfoMapper {
    public Vappinfo selectOne(Long aid);
    public List<Vappinfo> findAll();
    public List<Vappinfo> findAllByPage(Long item);
    public List<Vappinfo> findSome(@Param("softwareName") String softwareName,@Param("flatformId") Long flatformId,@Param("categoryLevel1") Long categoryLevel1,@Param("categoryLevel2") Long categoryLevel2,@Param("categoryLevel3") Long categoryLevel3);
    public List<Vappinfo> findSomeByPage(@Param("softwareName") String softwareName,@Param("flatformId") Long flatformId,@Param("categoryLevel1") Long categoryLevel1,@Param("categoryLevel2") Long categoryLevel2,@Param("categoryLevel3") Long categoryLevel3,@Param("item") int item);
}
