package com.example.romanbekova_zhibek_hw3_5m

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var api: PixiApi = retrofit.create(PixiApi::class.java)
}