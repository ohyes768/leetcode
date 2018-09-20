package com.dbapp.attackWay;

import java.util.List;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/21 14:14
 * @Modified:
 */
public class Attackway {
    public String id;
    public String name;
    public String parentId;
    public List<Attackway> childList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Attackway> getChildList() {
        return childList;
    }

    public void setChildList(List<Attackway> childList) {
        this.childList = childList;
    }
}
