package com.group.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.group.dao.AppCategoryMapper;
import com.group.dao.AppCheckMapper;
import com.group.pojo.App_Category;
import com.group.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AppCategoryServiceImpl  implements AppCategoryService{
    @Autowired
    private AppCategoryMapper appCategoryMapper;

    public AppCategoryServiceImpl() {
    }

    public AppCategoryServiceImpl(AppCategoryMapper appCategoryMapper){
        this.appCategoryMapper=appCategoryMapper;
    }
    @Override
    public List<App_Category> findChild(Long pid) {
        return appCategoryMapper.selectList(new EntityWrapper<App_Category>().eq("parentId",pid));
    }

    @Override
    public List<App_Category> findfirst() {
        return appCategoryMapper.selectList(new EntityWrapper<App_Category>().isNull("parentId"));
    }

    @Override
    public List<App_Category> findSecond() {
        return appCategoryMapper.selectList(new EntityWrapper<App_Category>().lt("parentId",3));
    }

    @Override
    public List<App_Category> findThird() {
        return appCategoryMapper.selectList(new EntityWrapper<App_Category>().gt("parentId",2));
    }

    @Override
    public List<App_Category> findAll() {
        return appCategoryMapper.selectList(null);
    }

    @Override
    public PageUtil<App_Category> findAllByPage(int pageNo) {
        PageUtil<App_Category> page=new PageUtil<>();
        page.setPageSize(5);
        page.setTotalCount(appCategoryMapper.selectCount(null));
        page.setPageNo(pageNo);
        List<App_Category> list=appCategoryMapper.selectList(new EntityWrapper<App_Category>().between("id",page.getItem()+1,page.getItem()+5));
        page.settList(list);
        return page;
    }

    @Override
    public PageUtil<App_Category> findSomeByPage(int pageNo, String categoryName, Long idLevel1, Long idLevel2, Long idLevel3) {
        PageUtil<App_Category> page=new PageUtil<>();
        page.setPageSize(5);
        page.setPageNo(pageNo);
        if(idLevel3!=null&&idLevel3!=0){
            page.setTotalCount(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).eq("id",idLevel3)).size());
            String s="limit "+page.getItem()+",5";
            System.out.println(s);
            page.settList(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).eq("id",idLevel3).last(s)));
        }else if(idLevel2!=null&&idLevel2!=0){
            page.setTotalCount(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).eq("parentId",idLevel2)).size());
            String s="limit "+page.getItem()+",5";
            System.out.println(s);
            page.settList(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).eq("parentId",idLevel2).last(s)));
        }else if(idLevel1!=null&&idLevel1!=0){
            page.setTotalCount(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).eq("parentId",idLevel1)).size());
            String s="limit "+page.getItem()+",5";
            System.out.println(s);
            page.settList(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).eq("parentId",idLevel1).last(s)));
        }else {
            page.setTotalCount(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName",Objects.requireNonNullElse(categoryName,""))).size());
            String s="limit "+page.getItem()+",5";
            System.out.println(s);
            page.settList(appCategoryMapper.selectList(new EntityWrapper<App_Category>().like("categoryName", Objects.requireNonNullElse(categoryName,"")).last(s)));
        }
        return page;
    }

    @Override
    public App_Category findById(Long id) {
        return appCategoryMapper.selectById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int addOne(App_Category category) {
        return appCategoryMapper.insert(category);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int updateOne(App_Category category) {
        return appCategoryMapper.modifyOne(category);
    }

    @Override
    public int deleteOne(Long id) {
        return appCategoryMapper.deleteById(id);
    }
}
