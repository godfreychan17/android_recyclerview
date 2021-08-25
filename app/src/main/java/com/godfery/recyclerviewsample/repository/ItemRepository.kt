package com.godfery.recyclerviewsample.repository

import com.godfery.recyclerviewsample.di.BeerWebClientModule
import com.godfery.recyclerviewsample.di.DaggerItemRepositoryComponent
import com.godfery.recyclerviewsample.model.BeerResponse
import com.godfery.recyclerviewsample.webservices.BeerDataClient
import io.reactivex.Single
import javax.inject.Inject


class ItemRepository() {

    @Inject
    lateinit var beerDataClient: BeerDataClient

    init {
        DaggerItemRepositoryComponent.builder()
            .beerWebClientModule(BeerWebClientModule())
            .build()
            .inject(this)
    }

    fun getItems() : Single<List<BeerResponse>>{
        return beerDataClient.getBeerList()
    }
}