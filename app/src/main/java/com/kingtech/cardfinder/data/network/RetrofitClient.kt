package com.kingtech.cardfinder.data.network


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kingtech.cardfinder.BuildConfig
import com.kingtech.cardfinder.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "https://findbinnumbers.p.rapidapi.com/"

    private val logging = HttpLoggingInterceptor()

    private fun logLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else
            HttpLoggingInterceptor.Level.NONE
    }

    fun service(): CardService {

        val interceptor = Interceptor { chain ->
            val request = chain.request()
            val newRequest = request.newBuilder()
                .addHeader("x-rapidapi-key", Constant.API_KEY)
                .build()
            chain.proceed(newRequest)
        }

        //http logging
        val httpClient = OkHttpClient.Builder().addInterceptor(logging.setLevel(logLevel()))
            .addInterceptor(interceptor)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()

        val retrofitApi = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofitApi.create(CardService::class.java)
    }
}