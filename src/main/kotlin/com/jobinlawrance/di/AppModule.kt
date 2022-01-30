package com.jobinlawrance.di

import com.jobinlawrance.data.MovieRepository
import com.jobinlawrance.sqldelight.MoviesQueries
import com.jobinlawrance.sqldelight.SQLDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import com.zaxxer.hikari.HikariDataSource
import org.koin.dsl.module

val appModule = module {
    single<SQLDatabase> { SQLDatabase(getSqlDriver()) }
    single<MoviesQueries> { get<SQLDatabase>().moviesQueries }
    single<MovieRepository> { MovieRepository(get()) }
}

private fun getSqlDriver(): SqlDriver {
    val ds = HikariDataSource()
    ds.jdbcUrl = "jdbc:mysql://localhost:3306/movies_db"
    ds.driverClassName = "com.mysql.jdbc.Driver"
    ds.username = "root"
    ds.password = "mysqlroot"
    return ds.asJdbcDriver()
}