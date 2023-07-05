package uz.gita.examfinal3.domain.repositories

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

var user: FirebaseUser? = null


class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val auth: FirebaseAuth = Firebase.auth
    override fun signIn(email: String, password: String): Flow<Result<Unit>> = callbackFlow {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                user = auth.currentUser
                trySend(Result.success(Unit))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
            .addOnCanceledListener {
                trySend(Result.failure(Exception("Cancelled")))
            }
        awaitClose()

    }

    override fun signUp(email: String, password: String): Flow<Result<Unit>> = callbackFlow {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                trySend(Result.success(Unit))
                Log.d("TTT","SignUp")
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
                Log.d("TTT","NoSignUp")
            }
            .addOnCanceledListener {
                trySend(Result.failure(Exception("Cancelled")))
            }
        awaitClose()
    }


}