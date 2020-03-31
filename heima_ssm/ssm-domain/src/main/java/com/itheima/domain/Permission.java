package com.itheima.domain;

import java.util.List;

public class Permission {
    private String id;
    private String permissinName;
    private String url;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissinName() {
        return permissinName;
    }

    public void setPermissinName(String permissinName) {
        this.permissinName = permissinName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
