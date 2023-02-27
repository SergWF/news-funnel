package wf.home.newsfunnel.wf.home.newsfunnel.common

import wf.home.newsfunnel.wf.home.newsfunnel.domain.News
import wf.home.newsfunnel.wf.home.newsfunnel.domain.NewsDate

interface Storage {
    fun saveOne(news: News) = save(listOf(news))
    fun save(news: Collection<News>)
    fun read(startDate: NewsDate): List<News>
    fun showStatistic(): StorageStatistic
}

data class StorageStatistic(
    val first: NewsDate,
    val last: NewsDate,
    val totalNews: TotalNews
)

@JvmInline
value class TotalNews(val value: Int)