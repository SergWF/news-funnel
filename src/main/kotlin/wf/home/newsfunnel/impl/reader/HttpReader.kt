package wf.home.newsfunnel.wf.home.newsfunnel.impl.reader

import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.domain.RawNews
import wf.home.newsfunnel.wf.home.newsfunnel.domain.SourceUrl

class HttpReader(applicationConfig: ApplicationConfig) : BaseReader(applicationConfig) {
    override fun readSource(sourceUrl: SourceUrl): RawNews {
        TODO("Not yet implemented")
    }

    override fun isReaderFor(sourceUrl: SourceUrl): Boolean =
        sourceUrl.value.trim().lowercase().startsWith("http")

}