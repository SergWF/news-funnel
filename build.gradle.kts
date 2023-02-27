val kodeinVersion: String by project
val konformVersion: String by project
val kotlinVersion: String by project
val ktorVersion: String by project
val logbackVersion: String by project
val mockkVersion: String by project
val prometeusVersion: String by project


plugins {
    application
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
}

group = "wf.home.newsfunnel"
version = "0.0.1"
application {
    mainClass.set("wf.home.newsfunnel.ApplicationKt")
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

configurations.testImplementation {
    exclude(group = "org.jetbrains.kotlin", module = "kotlin-test-junit")
    exclude(group = "junit")
}

dependencies {
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("org.kodein.di:kodein-di-jvm:$kodeinVersion")
    implementation("io.konform:konform:$konformVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.4.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
}