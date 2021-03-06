package com.neobis.genericapiclient.api

import com.neobis.genericapiclient.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {


    @GET("random_ten")
    suspend fun getCustomPosts(): Response<List<Post>>


}