package com.dbapp.attackWay;

import java.util.List;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/21 14:14
 * @Modified:
 */
public class Attack {
    public String name;
    public String key;
    public String key_ch;
    public String parentName;
    public List<Attack> childList;
    public int id;
    public int count;
    public int parentCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getParentCount() {
        return parentCount;
    }

    public void setParentCount(int parentCount) {
        this.parentCount = parentCount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey_ch() {
        return key_ch;
    }

    public void setKey_ch(String key_ch) {
        this.key_ch = key_ch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Attack> getChildList() {
        return childList;
    }

    public void setChildList(List<Attack> childList) {
        this.childList = childList;
    }
}
