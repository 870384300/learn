package com.billow.pojo.ex;

import java.util.List;

/**
 * 菜单
 *
 * @author liuyongtao
 * @create 2018-05-26 9:30
 */
public class MenuEx {
    /**
     * 菜单ID
     */
    private String id;
    /**
     * 菜单标题
     */
    private String title;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 有效标志
     */
    private boolean validInd;
    /**
     * 子级菜单
     */
    private List<MenuEx> children;

    public String getId() {
        return id;
    }

    public MenuEx setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MenuEx setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPath() {
        return path;
    }

    public MenuEx setPath(String path) {
        this.path = path;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public MenuEx setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public List<MenuEx> getChildren() {
        return children;
    }

    public MenuEx setChildren(List<MenuEx> children) {
        this.children = children;
        return this;
    }

    public boolean getValidInd() {
        return validInd;
    }

    public MenuEx setValidInd(boolean validInd) {
        this.validInd = validInd;
        return this;
    }

    @Override
    public String toString() {
        return "MenuEx{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", icon='" + icon + '\'' +
                ", validInd=" + validInd +
                ", children=" + children +
                '}';
    }
}