package com.godfery.recyclerviewsample.webservices

import com.godfery.recyclerviewsample.model.BeerResponse
import io.reactivex.Single

class BeerLocalDataTestClient : BeerDataClient {

    override fun getBeerList(): Single<List<BeerResponse>> {

        //Network return
        val data = arrayListOf<BeerResponse>()

        val NUM_OF_COL = 100;
        for( i in 0..NUM_OF_COL){
            val name = "Name $i"
            val tagLine = "tagline @ $i"


            data.add(
                BeerResponse(
                    id = i,
                    name = name,
                    tagline = tagLine,
                    image_url ="https://picsum.photos/${ (100 until 1024).random()}"
                )
            )
        }
        return Single.just<List<BeerResponse>>(data)
    }
}