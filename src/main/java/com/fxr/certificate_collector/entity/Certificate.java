package com.fxr.certificate_collector.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** 证书实体类
 * @author fanXiaoRui
 * @date 2020/11/12 20:55
 */
@Entity
@SQLDelete(sql = "update CERTIFICATE set DELETED = 1 where DELETED = ?")
@Where(clause = "DELETED = 0")
public class Certificate implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty("证书id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty("证书名")
    private String name;

    /**
     * 证书图片
     */
    @ApiModelProperty("证书图片")
    @Lob
    private String picture;

    /**
     * 奖项
     */
    @ApiModelProperty("奖项")
    private String awards;

    /**
     * 分值
     */
    @ApiModelProperty("分值")
    private Integer fraction;

    /**
     * 状态(0：通过，1：驳回)
     */
    @ApiModelProperty("状态(0：通过，1：驳回)")
    private boolean status = false;

    /**
     * 原因
     */
    @ApiModelProperty("原因")
    private String reason;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 逻辑删除(0：未删除，1：已删除)
     */
    @ApiModelProperty("逻辑删除(0：未删除，1：已删除)")
    private boolean deleted = false;

    @ManyToOne
    private Module module;

    @ManyToOne
    private Level level;



    public Certificate() {
    }

    public Certificate(String name, String picture, String awards, Integer fraction, boolean status, String reason, Date createTime, Date updateTime, boolean deleted, Module module, Level level) {
        this.name = name;
        this.picture = picture;
        this.awards = awards;
        this.fraction = fraction;
        this.status = status;
        this.reason = reason;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.module = module;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", awards='" + awards + '\'' +
                ", fraction=" + fraction +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                ", module=" + module +
                ", level=" + level +
                '}';
    }
}
