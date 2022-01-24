package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentModalBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ModalBottomSheetFragment : BottomSheetDialogFragment() , NavigationView.OnNavigationItemSelectedListener{
    private lateinit var bind:FragmentModalBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentModalBottomSheetBinding.inflate(inflater, container,false)
        bind.modalDrawerBottom.setNavigationItemSelectedListener(this)
        // Inflate the layout for this fragment

        return bind.root
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemCancel->{}
            R.id.itemDialogFullscreen->{
                val dialog=FullscreenDialogFragment()
                dialog.show(parentFragmentManager.beginTransaction(),FullscreenDialogFragment.TAG)
            }
            else->{
                var msg=item.title.toString()
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
            }
        }
        dismiss()
        return true
    }

    companion object {
        const val TAG="Bottom Sheet Modal"
    }
}