package com.example.rsswithretrofit
import retrofit2.Call
import retrofit2.http.GET
interface APIInterface {
    @GET("archlinux/.rss")
    fun getArchFeed() : Call<Feed>
}
