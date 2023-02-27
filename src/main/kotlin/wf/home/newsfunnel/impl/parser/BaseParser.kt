package wf.home.newsfunnel.wf.home.newsfunnel.impl.parser

import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.Parser

sealed class BaseParser(protected val applicationConfig: ApplicationConfig) : Parser