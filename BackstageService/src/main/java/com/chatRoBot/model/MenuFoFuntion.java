package com.chatRoBot.model;

/**
 * Created by Asus on 2018/3/20.
 */
public class MenuFoFuntion {
    private String menuFoFunctionId;
    private String menuId;
    private String funtionId;

    public MenuFoFuntion() {
    }

    public MenuFoFuntion(String menuFoFunctionId, String menuId, String funtionId) {
        this.menuFoFunctionId = menuFoFunctionId;
        this.menuId = menuId;
        this.funtionId = funtionId;
    }

    public String getMenuFoFunctionId() {
        return menuFoFunctionId;
    }

    public void setMenuFoFunctionId(String menuFoFunctionId) {
        this.menuFoFunctionId = menuFoFunctionId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getFuntionId() {
        return funtionId;
    }

    public void setFuntionId(String funtionId) {
        this.funtionId = funtionId;
    }
}
