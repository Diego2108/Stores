package com.godiapper.stores.core.utils


import com.godiapper.stores.core.entities.StoreEntity

interface MainAux {
    fun hideFab(isVisible:Boolean = false)

    fun addStore(storeEntity: StoreEntity)

    fun updateStore(storeEntity: StoreEntity)
}