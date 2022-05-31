package com.godiapper.stores.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.godiapper.stores.R
import com.godiapper.stores.adapter.StoreAdapter
import com.godiapper.stores.core.OnClickListener
import com.godiapper.stores.core.StoreApplication
import com.godiapper.stores.core.StoreEntity
import com.godiapper.stores.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), OnClickListener, MainAux {

    private lateinit var mbinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        /*mbinding.btnSave.setOnClickListener {
            val store = StoreEntity(name = mbinding.etName.text.toString().trim())

            Thread {
                StoreApplication.database.storeDao().addStore(store)
            }

            mAdapter.add(store)
        }*/

        mbinding.fab.setOnClickListener { launchEditFragment() }

        setupReciclerView()
    }

    private fun launchEditFragment(args:Bundle? = null) {
        val fragment = EditStoreFragment()
        if (args != null) fragment.arguments = args

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.containerMain, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        //mbinding.fab.hide()
        hideFab()
    }

    private fun setupReciclerView() {
        mAdapter = StoreAdapter(mutableListOf(),this)
        mGridLayout = GridLayoutManager(this,2)
        getStores()

        mbinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    private fun getStores(){
        doAsync {
            val stores = StoreApplication.database.storeDao().getAllStores()
            uiThread {
                mAdapter.setStores(stores)
            }
        }
    }

    /*------------------------OnClickListener--------------------------*/
    override fun onClick(storeId: Long) {
        val args = Bundle()
        args.putLong(getString(R.string.arg_id), storeId)

        launchEditFragment(args)
    }

    override fun onFavoriteStore(storeEntity: StoreEntity) {
        storeEntity.isfavorite = !storeEntity.isfavorite
        doAsync {
            StoreApplication.database.storeDao().updateStore(storeEntity)
            uiThread {
                mAdapter.update(storeEntity)
            }
        }
    }

    override fun onDeleteStore(storeEntity: StoreEntity) {
        doAsync {
            StoreApplication.database.storeDao().deleteStore(storeEntity)
            uiThread {
                mAdapter.delete(storeEntity)
            }
        }
    }

    override fun hideFab(isVisible: Boolean) {
        if (isVisible) mbinding.fab.show() else mbinding.fab.hide()
    }

    override fun addStore(storeEntity: StoreEntity) {
        mAdapter.add(storeEntity)
    }

    override fun updateStore(storeEntity: StoreEntity) {

    }
}