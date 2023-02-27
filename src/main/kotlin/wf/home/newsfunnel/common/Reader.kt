package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.RawNews
import wf.home.newsfunnel.wf.home.newsfunnel.domain.SourceUrl

interface Reader {
    fun readSource(sourceUrl: SourceUrl): RawNews
    fun isReaderFor(sourceUrl: SourceUrl): Boolean
}

