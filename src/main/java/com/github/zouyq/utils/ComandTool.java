package com.github.zouyq.utils;

import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.PathUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author zouyiq@gmail.com
 * @version 1.0
 * @since 21/8/5
 */
public class ComandTool {

    public static void main(String[] args) throws IOException {

    }

    private static final Logger logger = Logger.getInstance(ComandTool.class.getName());

    private static final String BASE_CMD = "cmd.exe /c start cd /d %1$s";

    private static final String KILL_JAVA = "cmd.exe /k start cmd /c \"TaskKill /t /F /IM %1$s & pause\"";

    private static final String SHOW_EXPLORE = "explorer.exe /select, %1$s";

    public static void executeCmd(VirtualFile virtualFile, ICommand command) {
        try {
            Runtime.getRuntime().exec(command.command());
        } catch (IOException e) {
            logger.error("execute command " + command.command() + " error!");
        }
    }

    public static String showInExplore(VirtualFile virtualFile) {
        String tPath = "";
        if (virtualFile != null) {
            tPath = virtualFile.getCanonicalPath();
            if (StringUtils.isNotEmpty(tPath)) {
                if (tPath.contains("!"))
                    tPath = tPath.substring(0, tPath.indexOf("!"));
                tPath = PathUtil.getLocalPath(tPath);
            }
        }
        String cmd = String.format(SHOW_EXPLORE, tPath);
        return cmd;
    }

    public static String openCmd(VirtualFile virtualFile) {
        String tPath = "";
        if (virtualFile != null)
            if (virtualFile.isDirectory()) {
                tPath = virtualFile.getCanonicalPath();
            } else {
                VirtualFile parent = virtualFile.getParent();
                tPath = parent.getCanonicalPath();
            }
        if (StringUtils.isBlank(tPath))
            tPath = ProjectManager.getInstance().getOpenProjects()[0].getBasePath();
        return String.format(BASE_CMD, tPath);
    }

    public static String getCmdPathKillJava() {
        return String.format(KILL_JAVA, "java.exe");
    }
}
