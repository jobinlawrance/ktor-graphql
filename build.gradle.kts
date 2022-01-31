val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val kgraphql_version: String by project

plugins {
    application
    id("com.squareup.sqldelight") version "1.5.3"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
}

group = "com.jobinlawrance"
version = "0.0.1"
application {
    mainClass.set("com.jobinlawrance.ApplicationKt")
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Koin
    implementation ("io.insert-koin:koin-ktor:$koin_version")
    implementation ("io.insert-koin:koin-logger-slf4j:$koin_version")

    // SqlDelight + MySql
    implementation ("com.squareup.sqldelight:jdbc-driver:1.5.3")
    implementation ("com.zaxxer:HikariCP:5.0.0")
    implementation ("mysql:mysql-connector-java:8.0.26")

    // Ktor
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // GraphQL
    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")
}

sqldelight {
    database(name = "SQLDatabase") {
        packageName = "com.jobinlawrance.sqldelight"
        sourceFolders = listOf("sqldelight")
        deriveSchemaFromMigrations = true
        dialect = "mysql"
    }
}