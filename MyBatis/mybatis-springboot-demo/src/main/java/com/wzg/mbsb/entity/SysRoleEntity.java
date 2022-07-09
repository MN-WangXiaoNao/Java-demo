package com.wzg.mbsb.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRoleEntity implements Serializable {
    private Long id;

    private String roleName;

    private Integer enabled;

    private Date createTime;

    private Long createBy;

    private static final long serialVersionUID = 1L;

    public SysRoleEntity(Long id, String roleName, Integer enabled, Date createTime, Long createBy) {
        this.id = id;
        this.roleName = roleName;
        this.enabled = enabled;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    public SysRoleEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", enabled=").append(enabled);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}