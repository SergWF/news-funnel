package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.News
import wf.home.newsfunnel.wf.home.newsfunnel.domain.RawNews

interface Parser {
    fun parse(source: Source, rawNews: RawNews): List<News>
    fun isParserFor(parserName: SourceParserName): Boolean
}