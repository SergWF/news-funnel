package wf.home.newsfunnel.wf.home.newsfunnel.impl.config

import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.Source
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceConfigReader
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceName
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceParserName
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourcePostProcessorName
import wf.home.newsfunnel.wf.home.newsfunnel.domain.SourceUrl

class ResourcesSourceConfigReader(private val applicationConfig: ApplicationConfig): SourceConfigReader {
    override fun getSourceConfig(): SourceConfig = SourceConfig(listOf(
        Source(SourceName("Spring Blog"), SourceUrl("https://spring.io/blog.atom"), SourceParserName("Rss2.0"), null),
        Source(SourceName(""), SourceUrl(""), SourceParserName(""), SourcePostProcessorName("")),
        Source(SourceName(""), SourceUrl(""), SourceParserName(""), SourcePostProcessorName(""))
    ))
}