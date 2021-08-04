package com.github.zouyq.cmdtools.services

import com.github.zouyq.cmdtools.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
