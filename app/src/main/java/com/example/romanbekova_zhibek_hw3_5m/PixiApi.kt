package com.example.romanbekova_zhibek_hw3_5m

import retrofit2.http.GET
import retrofit2.http.Query

interface PixiApi {
    @GET("api/")
    fun getImages(
        @Query("key") key: String = "42045375-a2bd53fe5bc813272ceee1f46",
        @Query("q") keyWordForSearch: String,
        @Query("per_page") perPage: Int = 5,
        @Query("page") page: Int = 1,
    ): retrofit2.Call<PixibayModel>
}