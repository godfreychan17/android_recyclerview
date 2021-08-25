package com.godfery.recyclerviewsample.views.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.godfery.recyclerviewsample.model.BeerResponse
import com.godfery.recyclerviewsample.repository.ItemRepository
import com.godfery.recyclerviewsample.util.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel (private val itemRepository: ItemRepository) : ViewModel(){

    private val items = MutableLiveData< Resource<List<BeerResponse>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
       fetchData()
    }

    private fun fetchData(){
        compositeDisposable.add(
            itemRepository.getItems()
                .subscribeOn( Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ itemsList ->
                    items.postValue( Resource.success(itemsList))

                }, {
                    it.printStackTrace()
                    items.postValue( Resource.fail("Fetch data fail"))
                })
        )
    }

    fun getItems(): LiveData< Resource<List<BeerResponse>>> {
        return items
    }

}