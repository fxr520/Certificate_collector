package com.fxr.certificate_collector.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/** 用户实体类
 * @author fanXiaoRui
 * @date 2020/11/12 20:58
 */
@Entity
public class User implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty("用户id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空！")
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "用户密码不能为空！")
    @ApiModelProperty("用户密码")
    private String passWord;

    /**
     * 昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;

    /**
     * 头像
     */
    @ApiModelProperty("用户头像")
    private String avatar;

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



    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord(String s) {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
