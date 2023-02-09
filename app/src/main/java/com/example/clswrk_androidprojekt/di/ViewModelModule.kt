package com.example.clswrk_androidprojekt.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clswrk_androidprojekt.di.factory.ViewModelFactory
import com.example.clswrk_androidprojekt.di.factory.ViewModelKey
import com.example.clswrk_androidprojekt.presentation.view.MainViewModel
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.HomeViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.items.DetailsViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.items.FavoritesViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.items.ItemsViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.items.SeaechViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelfactory:ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoritesViewModel(viewModel: FavoritesViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemsViewModel::class)
    abstract fun bindItemsViewModel(viewModel: ItemsViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SeaechViewModel::class)
    abstract fun bindSeaechViewModel(viewModel: SeaechViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel):ViewModel



}