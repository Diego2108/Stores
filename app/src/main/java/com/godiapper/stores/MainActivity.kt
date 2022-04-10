package com.godiapper.stores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.godiapper.stores.adapter.StoreAdapter
import com.godiapper.stores.core.OnClickListener
import com.godiapper.stores.core.Store
import com.godiapper.stores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mbinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mbinding.btnSave.setOnClickListener {
            val store = Store(name = mbinding.etName.text.toString().trim())
            mAdapter.add(store)
        }

        setupReciclerView()
    }

    private fun setupReciclerView() {
        mAdapter = StoreAdapter(mutableListOf(),this)
        mGridLayout = GridLayoutManager(this,2)

        mbinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    /*------------------------OnClickListener--------------------------*/
    override fun onClick(store: Store) {
        TODO("Not yet implemented")
    }
}