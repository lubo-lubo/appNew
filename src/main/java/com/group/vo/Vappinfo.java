package com.group.vo;

public class Vappinfo {
    private Long id;
    private Long status;
    private Long versionId;
    private String softwareName;
    private String APKName;
    private Long softwareSize;
    private String flatformName;
    private String categoryLevel1Name;
    private String categoryLevel2Name;
    private String categoryLevel3Name;
    private String statusName;
    private Long downloads;
    private String versionNo;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public Vappinfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    public Long getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(Long softwareSize) {
        this.softwareSize = softwareSize;
    }

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
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

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    @Override
    public String toString() {
        return "Vappinfo{" +
                "id=" + id +
                ", status=" + status +
                ", versionId=" + versionId +
                ", softwareName='" + softwareName + '\'' +
                ", APKName='" + APKName + '\'' +
                ", softwareSize=" + softwareSize +
                ", flatformName='" + flatformName + '\'' +
                ", categoryLevel1Name='" + categoryLevel1Name + '\'' +
                ", categoryLevel2Name='" + categoryLevel2Name + '\'' +
                ", categoryLevel3Name='" + categoryLevel3Name + '\'' +
                ", statusName='" + statusName + '\'' +
                ", downloads=" + downloads +
                ", versionNo='" + versionNo + '\'' +
                '}';
    }
}
