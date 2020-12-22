package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    companion object {
        val INITIAL_DATA = mutableListOf(
            Shoe(
                "Classic Slip-On™ Core Classics",
                42.0,
                "Vans",
                "These Vans may feel tight at first, but the material is expected to stretch. They are manufactured only for Medium Width, so if you have wider feet, we recommend going a 1/2 size up"
            ),
            Shoe(
                "Era™ Core Classics",
                42.0,
                "Vans",
                "From your board to chill sessions, keep it classic with the Vans® Era™ skate shoes!"
            ),
            Shoe(
                "Clifton 7",
                41.5,
                "Hoka One One",
                "Stay soft and light on your feet when you sport the updated and streamlined Hoka One One® Clifton 7 road-running shoes. Predecessor: Clifton 6."
            ),
            Shoe(
                "Rincon 2",
                40.5,
                "Hoka One One",
                "Just like the smooth waves of the world-famous Rincon surf spot in Santa Barbara, California, the Hoka One One® Rincon 2 neutral running shoes deliver incredible cushioning with an ultra-soft, lightweight, and weightless feel."
            )
        )
    }


}