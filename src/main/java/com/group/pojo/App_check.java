package com.group.pojo;


import java.sql.Date;
import java.sql.Timestamp;

public class App_check {

  private Long id;
  private String softwareName;
  private String apkName;
  private String supportRom;
  private String interfaceLanguage;
  private Double softwareSize;
  private java.sql.Date updateDate;
  private Long devId;
  private String appInfo;
  private Long status;
  private String statusName;
  private java.sql.Timestamp onSaleDate;
  private java.sql.Timestamp offSaleDate;
  private Long flatformId;
  private String flatformName;
  private Long categoryLevel3;
  private String categoryLevel3Name;
  private Long downloads;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;
  private Long categoryLevel1;
  private String categoryLevel1Name;
  private Long categoryLevel2;
  private String categoryLevel2Name;
  private String logoPicPath;
  private String logoLocPath;
  private Long versionId;



  public App_check() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSoftwareName() {
    return softwareName;
  }

  public void setSoftwareName(String softwareName) {
    this.softwareName = softwareName;
  }

  public String getApkName() {
    return apkName;
  }

  public void setApkName(String apkName) {
    this.apkName = apkName;
  }

  public String getSupportRom() {
    return supportRom;
  }

  public void setSupportRom(String supportRom) {
    this.supportRom = supportRom;
  }

  public String getInterfaceLanguage() {
    return interfaceLanguage;
  }

  public void setInterfaceLanguage(String interfaceLanguage) {
    this.interfaceLanguage = interfaceLanguage;
  }

  public Double getSoftwareSize() {
    return softwareSize;
  }

  public void setSoftwareSize(Double softwareSize) {
    this.softwareSize = softwareSize;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public Long getDevId() {
    return devId;
  }

  public void setDevId(Long devId) {
    this.devId = devId;
  }

  public String getAppInfo() {
    return appInfo;
  }

  public void setAppInfo(String appInfo) {
    this.appInfo = appInfo;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public Timestamp getOnSaleDate() {
    return onSaleDate;
  }

  public void setOnSaleDate(Timestamp onSaleDate) {
    this.onSaleDate = onSaleDate;
  }

  public Timestamp getOffSaleDate() {
    return offSaleDate;
  }

  public void setOffSaleDate(Timestamp offSaleDate) {
    this.offSaleDate = offSaleDate;
  }

  public Long getFlatformId() {
    return flatformId;
  }

  public void setFlatformId(Long flatformId) {
    this.flatformId = flatformId;
  }

  public Long getCategoryLevel3() {
    return categoryLevel3;
  }

  public void setCategoryLevel3(Long categoryLevel3) {
    this.categoryLevel3 = categoryLevel3;
  }

  public Long getDownloads() {
    return downloads;
  }

  public void setDownloads(Long downloads) {
    this.downloads = downloads;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
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

  public Long getCategoryLevel1() {
    return categoryLevel1;
  }

  public void setCategoryLevel1(Long categoryLevel1) {
    this.categoryLevel1 = categoryLevel1;
  }

  public Long getCategoryLevel2() {
    return categoryLevel2;
  }

  public void setCategoryLevel2(Long categoryLevel2) {
    this.categoryLevel2 = categoryLevel2;
  }

  public String getLogoPicPath() {
    return logoPicPath;
  }

  public void setLogoPicPath(String logoPicPath) {
    this.logoPicPath = logoPicPath;
  }

  public String getLogoLocPath() {
    return logoLocPath;
  }

  public void setLogoLocPath(String logoLocPath) {
    this.logoLocPath = logoLocPath;
  }

  public Long getVersionId() {
    return versionId;
  }

  public void setVersionId(Long versionId) {
    this.versionId = versionId;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  public String getFlatformName() {
    return flatformName;
  }

  public void setFlatformName(String flatformName) {
    this.flatformName = flatformName;
  }

  public String getCategoryLevel3Name() {
    return categoryLevel3Name;
  }

  public void setCategoryLevel3Name(String categoryLevel3Name) {
    this.categoryLevel3Name = categoryLevel3Name;
  }

  public String getCategoryLevel1Name() {
    return categoryLevel1Name;
  }

  public void setCategoryLevel1Name(String categoryLevel1Name) {
    this.categoryLevel1Name = categoryLevel1Name;
  }

  public String getCategoryLevel2Name() {
    return categoryLevel2Name;
  }

  public void setCategoryLevel2Name(String categoryLevel2Name) {
    this.categoryLevel2Name = categoryLevel2Name;
  }

  @Override
  public String toString() {
    return "App_check{" +
            "id=" + id +
            ", softwareName='" + softwareName + '\'' +
            ", apkName='" + apkName + '\'' +
            ", supportRom='" + supportRom + '\'' +
            ", interfaceLanguage='" + interfaceLanguage + '\'' +
            ", softwareSize=" + softwareSize +
            ", updateDate=" + updateDate +
            ", devId=" + devId +
            ", appInfo='" + appInfo + '\'' +
            ", status=" + status +
            ", statusName='" + statusName + '\'' +
            ", onSaleDate=" + onSaleDate +
            ", offSaleDate=" + offSaleDate +
            ", flatformId=" + flatformId +
            ", flatformName='" + flatformName + '\'' +
            ", categoryLevel3=" + categoryLevel3 +
            ", categoryLevel3Name='" + categoryLevel3Name + '\'' +
            ", downloads=" + downloads +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", categoryLevel1=" + categoryLevel1 +
            ", categoryLevel1Name='" + categoryLevel1Name + '\'' +
            ", categoryLevel2=" + categoryLevel2 +
            ", categoryLevel2Name='" + categoryLevel2Name + '\'' +
            ", logoPicPath='" + logoPicPath + '\'' +
            ", logoLocPath='" + logoLocPath + '\'' +
            ", versionId=" + versionId +
            '}';
  }
}
