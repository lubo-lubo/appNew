package com.group.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.group.dao.DataDictionaryMapper;
import com.group.pojo.Data_Dictionary;
import com.group.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<Data_Dictionary> findAppPlatform() {
        return dataDictionaryMapper.selectList(new EntityWrapper<Data_Dictionary>().in("typeCode","APP_FLATFORM"));
    }

    @Override
    public List<Data_Dictionary> findType() {
        return dataDictionaryMapper.selectList(new EntityWrapper<Data_Dictionary>().groupBy("typeCode"));
    }

    @Override
    public List<Data_Dictionary> findAll() {
        return dataDictionaryMapper.selectList(null);
    }

    @Override
    public PageUtil<Data_Dictionary> findAllByPage(int pageNo) {
        PageUtil<Data_Dictionary> page=new PageUtil<>();
        page.setPageSize(5);
        page.setPageNo(pageNo);
        page.setTotalCount(dataDictionaryMapper.selectList(null).size());
        List<Data_Dictionary> list=dataDictionaryMapper.findAllByPage(page.getItem());
        page.settList(list);
        return page;
    }

    @Override
    public List<Data_Dictionary> findByType(String typeCode) {
        return dataDictionaryMapper.selectList(new EntityWrapper<Data_Dictionary>().eq("typeCode",typeCode));
    }

    @Override
    public PageUtil<Data_Dictionary> findSomeByPage(String typeCode, String valueName, Long valueId, int pageNo) {
        PageUtil<Data_Dictionary> page=new PageUtil<>();
        page.setPageSize(5);
        page.setPageNo(pageNo);
        page.setTotalCount(dataDictionaryMapper.findSome(typeCode,valueName,valueId).size());
        List<Data_Dictionary> list=dataDictionaryMapper.findSomeByPage(typeCode,valueName,valueId,page.getItem());
        page.settList(list);
        return page;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int addOne(Data_Dictionary dataDictionary) {
        return dataDictionaryMapper.insert(dataDictionary);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int deleteOne(Long did) {
        return dataDictionaryMapper.deleteById(did);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int modifyOne(Data_Dictionary dataDictionary) {
        return dataDictionaryMapper.update(dataDictionary,new EntityWrapper<Data_Dictionary>().eq("id",dataDictionary.getId()));
    }

    @Override
    public Data_Dictionary findOne(Long did) {
        return dataDictionaryMapper.selectById(did);
    }
}
