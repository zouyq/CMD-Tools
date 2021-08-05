package com.github.zouyq.config;

/**
 * @author zouyiq@gmail.com
 * @version 1.0
 * @since 21/8/5
 */
public enum IconType {
    EXPLORE(1, "explore"),
    CONSOLE(2, "console"),
    JAVA(3, "java"), Null;

    private Integer type;
    private String desc;

    IconType() {
    }

    IconType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static IconType valueOfType(Integer type) {
        for (IconType obj : IconType.values()) {
            if (java.util.Objects.equals(obj.type, type)) {
                return obj;
            }
        }
        return Null;
    }

    public static IconType valueOfDesc(String desc) {
        for (IconType obj : IconType.values()) {
            if (java.util.Objects.equals(obj.desc, desc)) {
                return obj;
            }
        }
        return Null;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
