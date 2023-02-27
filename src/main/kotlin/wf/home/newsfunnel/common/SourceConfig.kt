package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.SourceUrl

interface SourceConfigReader {
    fun getSourceConfig(): SourceConfig
}

data class SourceConfig (
    val sources: List<Source>
)

data class Source(
    val name: SourceName,
    val url: SourceUrl,
    val parser: SourceParserName,
    val postProcessor: SourcePostProcessorName?
)


@JvmInline
value class SourceName(val value: String)

@JvmInline
value class SourceParserName(val value: String)

@JvmInline
value class SourcePostProcessorName(val value: String)