package com.godiapper.stores.mainModule.model

import com.godiapper.stores.core.StoreApplication
import com.godiapper.stores.core.entities.StoreEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.security.auth.callback.Callback

class MainInteractor {

    fun getStores(callback: (MutableList<StoreEntity>) -> Unit){
        doAsync {
            val storesList = StoreApplication.database.storeDao().getAllStores()
            uiThread {
                callback(storesList)
            }
        }
    }

    fun deleteStore(storeEntity:StoreEntity, callback: (StoreEntity) -> Unit){
        doAsync {
            StoreApplication.database.storeDao().deleteStore(storeEntity)
            uiThread {
                callback(storeEntity)
            }
        }
    }

    fun updateStore(storeEntity: StoreEntity,callback: (StoreEntity) -> Unit){
        doAsync {
            StoreApplication.database.storeDao().updateStore(storeEntity)
            uiThread {
                callback(storeEntity)
            }
        }
    }
}