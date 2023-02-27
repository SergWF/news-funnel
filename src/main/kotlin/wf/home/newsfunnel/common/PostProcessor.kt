package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.News

interface PostProcessor {
    fun postProcess(news: News): News
    fun isPostProcessorFor(postProcessorName: SourcePostProcessorName): Boolean
}