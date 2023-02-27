package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.News
import wf.home.newsfunnel.wf.home.newsfunnel.domain.NewsBody
import wf.home.newsfunnel.wf.home.newsfunnel.domain.NewsDate
import wf.home.newsfunnel.wf.home.newsfunnel.domain.RawNews
import wf.home.newsfunnel.wf.home.newsfunnel.impl.reader.HttpReader
import java.time.Instant

class SourceHandlerFactory(
    private val readers: Set<Reader>,
    private val parsers: Set<Parser>,
    private val postProcessors: Set<PostProcessor>,
) {
    private val defaultReader: Reader = readers.first { it is HttpReader }
    private val defaultParser: Parser = object : Parser {
        override fun parse(source: Source, rawNews: RawNews): List<News> =
            listOf(News(sourceUrl = source.url, date = NewsDate(Instant.now()), body = NewsBody(rawNews.value)))

        override fun isParserFor(parserName: SourceParserName): Boolean = false
    }
    private val defaultPostProcessor: PostProcessor = object : PostProcessor {
        override fun postProcess(news: News): News = news
        override fun isPostProcessorFor(postProcessorName: SourcePostProcessorName): Boolean = false
    }


    fun getReader(source: Source): Reader = readers.firstOrNull { it.isReaderFor(source.url) } ?: defaultReader


    fun getParser(sourceParserName: SourceParserName): Parser =
        parsers.firstOrNull { it.isParserFor(sourceParserName) } ?: defaultParser

    fun getPostProcessor(postProcessorName: SourcePostProcessorName?): PostProcessor =
        postProcessorName?.let {
            postProcessors.firstOrNull { it.isPostProcessorFor(postProcessorName) }
        } ?: defaultPostProcessor
}