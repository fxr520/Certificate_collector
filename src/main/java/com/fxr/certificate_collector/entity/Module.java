package com.fxr.certificate_collector.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 模块实体类
 * @author fanXiaoRui
 * @date 2020/11/12 20:57
 */
@Entity
@SQLDelete(sql = "update MODULE set DELETED = 1 where DELETED = ?")
@Where(clause = "DELETED = 0")
public class Module implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty("模块id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty("模块名")
    private String name;

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

    @OneToMany(mappedBy = "module")
    private List<Certificate> certificates = new ArrayList<>();


    public Module() {
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

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                ", certificates=" + certificates +
                '}';
    }
}
