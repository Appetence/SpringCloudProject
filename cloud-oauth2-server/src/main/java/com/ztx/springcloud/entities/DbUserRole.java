package entity;

import java.io.Serializable;

/**
 * 用户角色表(DbUserRole)实体类
 *
 * @author makejava
 * @since 2020-05-10 18:55:26
 */
public class DbUserRole implements Serializable {
    private static final long serialVersionUID = -96181468247471112L;
    
    private Long id;
    /**
    * 用户 ID
    */
    private Long userId;
    /**
    * 角色 ID
    */
    private Long roleId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

}