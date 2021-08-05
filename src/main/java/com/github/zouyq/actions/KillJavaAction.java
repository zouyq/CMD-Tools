package com.github.zouyq.actions;

import com.github.zouyq.config.Configuration;
import com.github.zouyq.config.IconType;
import com.github.zouyq.utils.ComandTool;
import com.github.zouyq.utils.ICommand;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author zouyiq@gmail.com
 * @version 1.0
 * @since 21/8/4
 */
public class KillJavaAction extends AnAction {

    public KillJavaAction() {
        getTemplatePresentation().setIcon(Configuration.getIcon(IconType.JAVA));
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        DataContext tDataContext = e.getDataContext();
        VirtualFile tVirtualFile = (VirtualFile) tDataContext.getData(PlatformDataKeys.VIRTUAL_FILE.getName());
        ComandTool.executeCmd(tVirtualFile, new ICommand() {
            public String command() {
                return ComandTool.getCmdPathKillJava();
            }
        });
    }
}
