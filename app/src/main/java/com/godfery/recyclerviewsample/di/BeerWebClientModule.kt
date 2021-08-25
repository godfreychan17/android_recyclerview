package com.godfery.recyclerviewsample.di

import com.godfery.recyclerviewsample.webservices.BeerDataClient
import com.godfery.recyclerviewsample.webservices.BeerLocalDataTestClient
import com.godfery.recyclerviewsample.webservices.BeerWebClient

import dagger.Module
import dagger.Provides


@Module
class BeerWebClientModule( private val type : BeerDataType = BeerDataType.Web) {

    companion object{

        enum class BeerDataType{
            Web,
            Local
        }
    }

    @Provides
    fun provideBeerWebClient() : BeerDataClient{
        return when(type){
            BeerDataType.Web -> BeerWebClient()
            BeerDataType.Local -> BeerLocalDataTestClient()
        }
    }
}