package com.godfery.recyclerviewsample.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.godfery.recyclerviewsample.repository.ItemRepository
import com.godfery.recyclerviewsample.views.main.MainViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(MainViewModel::class.java)){
            return  MainViewModel( ItemRepository()) as T
        }
        throw IllegalArgumentException("Unknow class name")
    }

}