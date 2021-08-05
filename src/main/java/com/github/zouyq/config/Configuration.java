package com.github.zouyq.config;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * @author zouyiq@gmail.com
 * @version 1.0
 * @since 21/8/5
 */
public class Configuration {
    private static final String PREFIX = "/icons/";
    private static final String SUFFIX = ".png";

    public static Icon getIcon(IconType iconType) {
        return IconLoader.getIcon(PREFIX + iconType.getDesc() + SUFFIX);
    }
}
