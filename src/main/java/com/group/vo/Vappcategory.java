package com.group.vo;


import com.group.pojo.App_Category;
import com.group.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;

@Component
public class Vappcategory {
  private Long id;
  private String categoryCode;
  private String categoryName;
  private Long parentId;
  private Long createdBy;
  private Timestamp creationTime;
  private Long modifyBy;
  private Timestamp modifyDate;
  private String parentName;


  public Vappcategory() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCategoryCode() {
    return categoryCode;
  }

  public void setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Timestamp creationTime) {
    this.creationTime = creationTime;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  @Override
  public String toString() {
    return "Vappcategory{" +
            "id=" + id +
            ", categoryCode='" + categoryCode + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", parentId=" + parentId +
            ", createdBy=" + createdBy +
            ", creationTime=" + creationTime +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", parentName='" + parentName + '\'' +
            '}';
  }
}
