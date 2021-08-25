package com.godfery.recyclerviewsample.webservices

import com.godfery.recyclerviewsample.model.BeerResponse
import io.reactivex.Single

interface BeerDataClient {

    fun getBeerList () : Single<List<BeerResponse>>

}