package com.group.pojo;


import java.sql.Timestamp;

public class App_Version {

  private Long id;
  private Long appId;
  private String versionNo;
  private String versionInfo;
  private Long publishStatus;
  private String downloadLink;
  private Double versionSize;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;
  private String apkLocPath;
  private String apkFileName;

  public App_Version() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAppId() {
    return appId;
  }

  public void setAppId(Long appId) {
    this.appId = appId;
  }

  public String getVersionNo() {
    return versionNo;
  }

  public void setVersionNo(String versionNo) {
    this.versionNo = versionNo;
  }

  public String getVersionInfo() {
    return versionInfo;
  }

  public void setVersionInfo(String versionInfo) {
    this.versionInfo = versionInfo;
  }

  public Long getPublishStatus() {
    return publishStatus;
  }

  public void setPublishStatus(Long publishStatus) {
    this.publishStatus = publishStatus;
  }

  public String getDownloadLink() {
    return downloadLink;
  }

  public void setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
  }

  public Double getVersionSize() {
    return versionSize;
  }

  public void setVersionSize(Double versionSize) {
    this.versionSize = versionSize;
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

  public String getApkLocPath() {
    return apkLocPath;
  }

  public void setApkLocPath(String apkLocPath) {
    this.apkLocPath = apkLocPath;
  }

  public String getApkFileName() {
    return apkFileName;
  }

  public void setApkFileName(String apkFileName) {
    this.apkFileName = apkFileName;
  }

  @Override
  public String toString() {
    return "App_Version{" +
            "id=" + id +
            ", appId=" + appId +
            ", versionNo='" + versionNo + '\'' +
            ", versionInfo='" + versionInfo + '\'' +
            ", publishStatus=" + publishStatus +
            ", downloadLink='" + downloadLink + '\'' +
            ", versionSize=" + versionSize +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", apkLocPath='" + apkLocPath + '\'' +
            ", apkFileName='" + apkFileName + '\'' +
            '}';
  }
}
