package com.neobis.genericapiclient.repository

import com.neobis.genericapiclient.api.RetrofitInstance
import com.neobis.genericapiclient.model.Post
import retrofit2.Response

class Repository {


    suspend fun getCustomPosts(): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts()
    }


}