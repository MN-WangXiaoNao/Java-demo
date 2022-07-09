package com.wzg.mbsb.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUserEntity implements Serializable {
    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date createTime;

    private String userInfo;

    private byte[] headImg;

    private static final long serialVersionUID = 1L;

    public SysUserEntity(Long id, String userName, String userPassword, String userEmail, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.createTime = createTime;
    }

    public SysUserEntity(Long id, String userName, String userPassword, String userEmail, Date createTime, String userInfo, byte[] headImg) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.createTime = createTime;
        this.userInfo = userInfo;
        this.headImg = headImg;
    }

    public SysUserEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", createTime=").append(createTime);
        sb.append(", userInfo=").append(userInfo);
        sb.append(", headImg=").append(headImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}