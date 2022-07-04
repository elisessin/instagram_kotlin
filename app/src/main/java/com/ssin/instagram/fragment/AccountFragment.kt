package com.ssin.instagram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ssin.instagram.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding  = FragmentAccountBinding.inflate(inflater,container,false)
        return binding.root
    }
}