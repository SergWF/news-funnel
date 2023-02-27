package wf.home.newsfunnel

import org.kodein.di.DI
import org.kodein.di.bindSet
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import org.kodein.di.singleton
import wf.home.newsfunnel.wf.home.newsfunnel.common.ApplicationConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.NewsFunnel
import wf.home.newsfunnel.wf.home.newsfunnel.common.Parser
import wf.home.newsfunnel.wf.home.newsfunnel.common.PostProcessor
import wf.home.newsfunnel.wf.home.newsfunnel.common.Reader
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceConfig
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceConfigReader
import wf.home.newsfunnel.wf.home.newsfunnel.common.SourceHandlerFactory
import wf.home.newsfunnel.wf.home.newsfunnel.common.Storage
import wf.home.newsfunnel.wf.home.newsfunnel.impl.config.ResourcesSourceConfigReader
import wf.home.newsfunnel.wf.home.newsfunnel.impl.config.readConfiguration
import wf.home.newsfunnel.wf.home.newsfunnel.impl.reader.HttpReader
import wf.home.newsfunnel.wf.home.newsfunnel.impl.storage.LocalFileStorage

fun main(args: Array<String>) {
    val di = kodeinDI(args)
    val newsFunnel by di.instance<NewsFunnel>()
    // newsFunnel.collectNews()
    val applicationConfig by di.instance<ApplicationConfig>()
    val sourceConfig by di.instance<SourceConfig>()
    println(applicationConfig)
    println("==============")
    println(sourceConfig)
}

fun kodeinDI(args: Array<String>) = DI {
    bindSingleton { readConfiguration(args) }
    bindSingleton { ResourcesSourceConfigReader(instance()).getSourceConfig() }
    bindSingleton<Storage> { LocalFileStorage(instance<ApplicationConfig>().storage) }
    bindSingleton { SourceHandlerFactory(instance(), instance(), instance()) }
    bindSingleton { NewsFunnel(instance(), instance(), instance()) }
    bindSet<Reader> {
            add { singleton { HttpReader(instance()) } }
    }
    bindSet<Parser> {

    }
    bindSet<PostProcessor> {

    }

}