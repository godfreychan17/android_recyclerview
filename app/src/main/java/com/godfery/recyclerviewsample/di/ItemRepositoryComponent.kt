package com.godfery.recyclerviewsample.di

import com.godfery.recyclerviewsample.repository.ItemRepository
import dagger.Component


@Component ( modules = [BeerWebClientModule::class])
interface ItemRepositoryComponent {
    fun inject (itemRepository: ItemRepository)
}
