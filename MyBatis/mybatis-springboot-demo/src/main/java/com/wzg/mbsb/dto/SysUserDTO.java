package com.wzg.mbsb.dto;

import java.util.Date;

import com.wzg.mbsb.entity.SysRoleEntity;

import lombok.Data;
@Data
public class SysUserDTO {

    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date createTime;

    private String userInfo;

    private byte[] headImg;

    private SysRoleEntity sysRole;


}
