package com.cf.studio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表，存储用户信息(User)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class User implements Serializable {
    private static final long serialVersionUID = -14110015692154093L;
/**
     * 用户ID
     */
    private Integer id;
/**
     * 用户名
     */
    private String username;
/**
     * 用户邮箱
     */
    private String email;
/**
     * 用户密码
     */
    private String password;
/**
     * 用户角色（普通成员、管理员、指导教师等）
     */
    private Object role;
/**
     * 用户头像
     */
    private String avatar;
/**
     * 个人简介
     */
    private String bio;
/**
     * 加入日期
     */
    private Date joinDate;

    private String qq;
    private String wechat;
    private String sexy;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "Asia/Shanghai")
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", avatar='" + avatar + '\'' +
                ", bio='" + bio + '\'' +
                ", joinDate=" + joinDate +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", sexy='" + sexy + '\'' +
                '}';
    }
}

