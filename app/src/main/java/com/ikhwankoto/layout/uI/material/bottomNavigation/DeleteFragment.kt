package com.ikhwankoto.layout.uI.material.bottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ikhwankoto.layout.R

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_delete, container, false)

    companion object {
        @JvmStatic
        fun newInstance() = DeleteFragment()
    }

}
