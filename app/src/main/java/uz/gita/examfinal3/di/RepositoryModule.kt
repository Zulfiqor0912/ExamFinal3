package uz.gita.examfinal3.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.examfinal3.domain.repositories.AuthRepository
import uz.gita.examfinal3.domain.repositories.AuthRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule{

    @[Singleton Binds]
    fun bindAuthRepository(impl: AuthRepositoryImpl):AuthRepository
}