package com.example.clswrk_androidprojekt.di.component

import com.example.clswrk_androidprojekt.di.*
import com.example.clswrk_androidprojekt.di.factory.ScreenScope
import com.example.clswrk_androidprojekt.presentation.view.MainActivity
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginFragment
import com.example.clswrk_androidprojekt.presentation.view.home.HomeFragment
import com.example.clswrk_androidprojekt.presentation.view.home.items.DetailsFragment
import com.example.clswrk_androidprojekt.presentation.view.home.items.FavoritesFragment
import com.example.clswrk_androidprojekt.presentation.view.home.items.ItemsFragment
import com.example.clswrk_androidprojekt.presentation.view.home.items.SearchFragment
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)

@ScreenScope
interface AppComponent {

    fun inject(loginFragment: LoginFragment)
    fun inject(detailsFragment: DetailsFragment)
    fun inject(itemsFragment: ItemsFragment)
    fun inject(favoritesFragment: FavoritesFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(mainActivity: MainActivity)


}