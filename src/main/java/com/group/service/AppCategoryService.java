package com.group.service;

import com.group.pojo.App_Category;
import com.group.util.PageUtil;

import java.util.List;

public interface AppCategoryService {
    public List<App_Category> findChild(Long pid);
    public List<App_Category> findfirst();
    public List<App_Category> findSecond();
    public List<App_Category> findThird();
    public List<App_Category> findAll();
    public PageUtil<App_Category> findAllByPage(int pageNo);
    public PageUtil<App_Category> findSomeByPage(int pageNo,String categoryName,Long idLevel1,Long idLevel2,Long idLevel3);
    public App_Category findById(Long id);
    public int addOne(App_Category category);
    public int updateOne(App_Category category);
    public int deleteOne(Long id);
}
