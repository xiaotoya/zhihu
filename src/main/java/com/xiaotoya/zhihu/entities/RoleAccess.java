package com.xiaotoya.zhihu.entities;

import java.io.Serial;
import java.io.Serializable;

public class RoleAccess implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer roleId;
    private Integer accessId;
    private Long createtime;
    private Long updatetime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }
}
