package com.group.service;

import com.group.pojo.Data_Dictionary;
import com.group.util.PageUtil;

import java.util.List;

public interface DataDictionaryService {
    public List<Data_Dictionary> findAppPlatform();
    public List<Data_Dictionary> findType();
    public List<Data_Dictionary> findAll();
    public PageUtil<Data_Dictionary> findAllByPage(int pageNo);
    public List<Data_Dictionary> findByType(String typeCode);
    public PageUtil<Data_Dictionary> findSomeByPage(String typeCode,String valueName,Long valueId,int pageNo);
    public int addOne(Data_Dictionary dataDictionary);
    public int deleteOne(Long did);
    public int modifyOne(Data_Dictionary dataDictionary);
    public Data_Dictionary findOne(Long did);
}
