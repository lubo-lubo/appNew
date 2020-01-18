package com.group.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.group.pojo.App_Category;

public interface AppCategoryMapper extends BaseMapper<App_Category> {
    public int modifyOne(App_Category appCategory);
}
