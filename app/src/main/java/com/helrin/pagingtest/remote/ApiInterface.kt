package com.helrin.pagingtest.remote

import com.helrin.pagingtest.model.ItemResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class Json

    @GET("search/repositories?sort=stars")
    @Json
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Response<ItemResponse>

}