package wf.home.newsfunnel.wf.home.newsfunnel.impl.storage

import wf.home.newsfunnel.wf.home.newsfunnel.common.Storage
import wf.home.newsfunnel.wf.home.newsfunnel.common.StorageConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.StorageStatistic
import wf.home.newsfunnel.wf.home.newsfunnel.domain.News
import wf.home.newsfunnel.wf.home.newsfunnel.domain.NewsDate

class LocalFileStorage(private val storageConfig: StorageConfig) : Storage {
    override fun save(news: Collection<News>) {
        TODO("Not yet implemented")
    }

    override fun read(startDate: NewsDate): List<News> {
        TODO("Not yet implemented")
    }

    override fun showStatistic(): StorageStatistic {
        TODO("Not yet implemented")
    }
}