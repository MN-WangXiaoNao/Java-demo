package com.wzg.mbsb.entity;

import java.io.Serializable;

public class SysPrivilegeEntity implements Serializable {
    private Long id;

    private String privilegeName;

    private String privilege;

    private static final long serialVersionUID = 1L;

    public SysPrivilegeEntity(Long id, String privilegeName, String privilege) {
        this.id = id;
        this.privilegeName = privilegeName;
        this.privilege = privilege;
    }

    public SysPrivilegeEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", privilegeName=").append(privilegeName);
        sb.append(", privilege=").append(privilege);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}