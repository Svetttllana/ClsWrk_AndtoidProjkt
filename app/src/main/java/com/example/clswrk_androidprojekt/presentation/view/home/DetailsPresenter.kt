package com.example.clswrk_androidprojekt.presentation.view.home

import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor

) {
    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        detailsView = detailsFragment
    }


    fun getArguments(name: String?, date: String?, imageView: Int) {
        detailsView.displayItemData(
            when (name.isNullOrBlank()) {

                true -> "no data"
                false -> name
            },
            when (date.isNullOrEmpty()) {
                true -> " no date"
                false -> date

            },
          imageView)

    }


    fun logautUser() {
        authInteractor.logautUser()
        detailsView.userLoggeout()

    }

}