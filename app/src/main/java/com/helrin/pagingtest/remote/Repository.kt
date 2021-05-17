package com.helrin.pagingtest.remote

import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun search() = call { apiInterface.searchRepos() }

    private suspend fun <T> call(apiCall: suspend () -> Response<T>): Response<T> {
        try {
            return apiCall()
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}