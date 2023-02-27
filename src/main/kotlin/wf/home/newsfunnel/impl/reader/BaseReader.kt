package wf.home.newsfunnel.wf.home.newsfunnel.impl.reader

import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.Reader

sealed class BaseReader(protected val applicationConfig: ApplicationConfig): Reader