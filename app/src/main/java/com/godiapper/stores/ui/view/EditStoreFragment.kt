package com.godiapper.stores.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.godiapper.stores.R
import com.godiapper.stores.databinding.FragmentEditStoreBinding


class EditStoreFragment : Fragment() {

    private lateinit var mBinding: FragmentEditStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?   ): View? {
        mBinding = FragmentEditStoreBinding.inflate(inflater,container,false)
        return mBinding.root
    }

}