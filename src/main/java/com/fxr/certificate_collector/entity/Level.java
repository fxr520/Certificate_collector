package com.fxr.certificate_collector.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 级别实体类
 * @author fanXiaoRui
 * @date 2020/11/12 20:56
 */
@Entity
public class Level implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty("等级id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty("等级名")
    private String name;

    @OneToMany(mappedBy = "level")
    private List<Certificate> certificates = new ArrayList<>();



    public Level() {
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

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", certificates=" + certificates +
                '}';
    }
}
