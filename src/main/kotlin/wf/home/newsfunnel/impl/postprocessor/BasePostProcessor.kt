package wf.home.newsfunnel.wf.home.newsfunnel.impl.postprocessor

import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.PostProcessor

sealed class BasePostProcessor(protected val applicationConfig: ApplicationConfig): PostProcessor