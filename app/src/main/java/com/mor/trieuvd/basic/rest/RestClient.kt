package com.mor.trieuvd.basic.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    val BASE_API = "https://api.github.com/"
    var retrofit: Retrofit? = null

    val restClient: APIs
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(APIs::class.java)
        }
}
