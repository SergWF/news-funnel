package wf.home.newsfunnel.wf.home.newsfunnel.common

data class ApplicationConfig(
    val configFileName: ConfigFileName,
    val storage: StorageConfig
)

interface StorageConfig

data class LocalFileStorage(
    val storageFolderPath: StorageFolderPath
): StorageConfig

@JvmInline
value class ConfigFileName(private val value: String)

@JvmInline
value class StorageFolderPath(private val value: String)

