package com.group.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.group.pojo.Data_Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryMapper extends BaseMapper<Data_Dictionary> {
    public List<Data_Dictionary> findAllByPage(int item);
    public List<Data_Dictionary> findSome(@Param("typeCode") String typeCode,@Param("valueName") String valueName,@Param("valueId") Long valueId);
    public List<Data_Dictionary> findSomeByPage(@Param("typeCode") String typeCode,@Param("valueName") String valueName,@Param("valueId") Long valueId,@Param("item")int item);
}
