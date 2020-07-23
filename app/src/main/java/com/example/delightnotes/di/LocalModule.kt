package com.example.delightnotes.di

import android.content.Context
import com.example.delightnotes.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideSqliteDriver(
        @ApplicationContext context: Context
    ) = AndroidSqliteDriver(Database.Schema, context, "test.db")

    @Provides
    @Singleton
    fun provideDatabase(
        sqliteDriver: AndroidSqliteDriver
    ) = Database(sqliteDriver)
}
