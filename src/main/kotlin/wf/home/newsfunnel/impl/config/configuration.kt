package wf.home.newsfunnel.wf.home.newsfunnel.impl.config

import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.ConfigFileName
import wf.home.newsfunnel.wf.home.newsfunnel.common.LocalFileStorage
import wf.home.newsfunnel.wf.home.newsfunnel.common.StorageFolderPath

fun readConfiguration(args: Array<String>): ApplicationConfig {
    return ApplicationConfig(
        configFileName = ConfigFileName("sources.conf"),
        storage = LocalFileStorage(StorageFolderPath("storage"))
    )
}