package entity;

import java.io.Serializable;

/**
 * 角色权限表(DbRolePermission)实体类
 *
 * @author makejava
 * @since 2020-05-10 18:55:25
 */
public class DbRolePermission implements Serializable {
    private static final long serialVersionUID = -64124017240626037L;
    
    private Long id;
    /**
    * 角色 ID
    */
    private Long roleId;
    /**
    * 权限 ID
    */
    private Long permissionId;
    /**
    * 小程序id
    */
    private Integer appid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

}