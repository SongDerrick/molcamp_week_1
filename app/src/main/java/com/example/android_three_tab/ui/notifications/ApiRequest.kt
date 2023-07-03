package com.example.android_three_tab.ui.notifications

import com.example.android_three_tab.ui.notifications.api.CatJson
import com.example.android_three_tab.ui.notifications.api.ThingJson
import com.example.android_three_tab.ui.notifications.api.ThingJsonItem
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface ApiRequest {

    @GET("/facts/random")
    fun getCatFacts(): Call<CatJson>

    @GET("/request/helpful_text?apikey=guest")
    fun getThingUn() : Call<List<ThingJsonItem>>
}