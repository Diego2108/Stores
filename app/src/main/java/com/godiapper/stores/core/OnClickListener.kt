package com.godiapper.stores.core

interface OnClickListener {
    fun onClick(storeEntity:StoreEntity)
    fun onFavoriteStore(storeEntity: StoreEntity)
    fun onDeleteStore(storeEntity: StoreEntity)
}