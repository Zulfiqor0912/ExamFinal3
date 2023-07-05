package uz.gita.examfinal3.domain.repositories

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signIn(email: String, password: String): Flow<Result<Unit>>

    fun signUp(email: String, password: String): Flow<Result<Unit>>
}