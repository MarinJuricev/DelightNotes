package com.example.delightnotes.di

import com.example.delightnotes.data.repository.NoteRepositoryImpl
import com.example.delightnotes.domain.repository.INoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNoteRepository(
        noteRepository: NoteRepositoryImpl
    ): INoteRepository
}
