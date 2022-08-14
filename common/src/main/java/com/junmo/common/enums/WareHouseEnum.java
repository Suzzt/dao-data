package com.junmo.common.enums;

/**
 * @author: sucf
 * @date: 2022/8/14 23:53
 * @description:
 */
public enum WareHouseEnum {

    /**
     * mysql
     */
    MYSQL("mysql", "mysql"),

    /**
     * hive
     */
    HIVE("hive", "hive"),
    ;


    private String name;

    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    WareHouseEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
