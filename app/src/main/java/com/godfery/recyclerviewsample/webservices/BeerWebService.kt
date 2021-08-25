package com.godfery.recyclerviewsample.webservices

import com.godfery.recyclerviewsample.model.BeerResponse
import io.reactivex.Single
import retrofit2.http.GET

interface BeerWebService {
    @GET("beers")
    fun getBeerList() : Single<List<BeerResponse>>

}