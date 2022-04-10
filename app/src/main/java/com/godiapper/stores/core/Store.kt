package com.godiapper.stores.core

data class Store(
    var id:Long = 0,
    var name: String,
    var phone: String = "",
    var website: String = "",
    var isfavorite: Boolean = false
)
