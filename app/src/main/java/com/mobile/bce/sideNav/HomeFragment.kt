package com.mobile.bce.sideNav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mobile.bce.FormActivity
import com.mobile.bce.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnGo = view.findViewById<Button>(R.id.btnRegister)
        btnGo.setOnClickListener {
            val intent = Intent(requireActivity(), FormActivity::class.java)
            startActivity(intent)
        }
    }


}