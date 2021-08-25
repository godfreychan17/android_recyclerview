package com.godfery.recyclerviewsample.webservices

import com.godfery.recyclerviewsample.model.BeerResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BeerWebClient : BeerDataClient{

    var service : BeerWebService
    val BASE_URL = "https://api.punkapi.com/v2/"

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(BeerWebService::class.java)
    }

    override fun getBeerList () : Single<List<BeerResponse>> {
        return  service.getBeerList()
    }
}