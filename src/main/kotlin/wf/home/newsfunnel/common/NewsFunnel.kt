package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.News
import wf.home.newsfunnel.wf.home.newsfunnel.domain.RawNews

class NewsFunnel(
    private val sourcesConfig: SourceConfig,
    private val sourceHandlerFactory: SourceHandlerFactory,
    private val storage: Storage
) {

    fun collectNews() = sourcesConfig.sources.forEach { source ->
        val rawNews: RawNews = sourceHandlerFactory.getReader(source).readSource(source.url)
        val postProcessor: PostProcessor = sourceHandlerFactory.getPostProcessor(source.postProcessor)
        val news: List<News> = sourceHandlerFactory.getParser(source.parser).parse(source, rawNews).map { news ->
            postProcessor.postProcess(news)
        }
        storage.save(news)
    }

}