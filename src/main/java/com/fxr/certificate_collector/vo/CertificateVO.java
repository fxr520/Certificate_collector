package com.fxr.certificate_collector.vo;

/**
 * @author fanXiaoRui
 * @date 2020/11/30 12:22
 */
public class CertificateVO {

    private String name;

    private String moduleId;

    private String levelId;

    private boolean status;


    public CertificateVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
