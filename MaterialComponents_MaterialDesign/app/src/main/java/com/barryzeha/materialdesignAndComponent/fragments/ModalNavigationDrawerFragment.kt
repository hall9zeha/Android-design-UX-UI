package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.DialogFragment
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentModalNavigationDrawerBinding
import com.google.android.material.navigation.NavigationView


class ModalNavigationDrawerFragment : DialogFragment() , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var bind:FragmentModalNavigationDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.myDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentModalNavigationDrawerBinding.inflate(inflater, container,false)
        (activity as AppCompatActivity).setSupportActionBar(bind.materialToolbar)
        var toggle=ActionBarDrawerToggle(activity, bind.drawerLayout, bind.materialToolbar
            ,R.string.dialog_ok
            ,R.string.dialog_cancel)
       // toggle.drawerArrowDrawable.color= ContextCompat.getColor(activity as AppCompatActivity,R.color.white)
        bind.drawerLayout.addDrawerListener(toggle)
        bind.navView.setNavigationItemSelectedListener(this)
        toggle.syncState()
        return bind.root
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemCancel->{
                bind.drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.itemDialogFullscreen->{
                var bottomFragment=AppBarBottomFragment()
                bottomFragment.show(parentFragmentManager.beginTransaction(), AppBarBottomFragment.TAG)

            }
        }
        bind.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {

        val TAG="Modal Navigation Drawer"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ModalNavigationDrawerFragment().apply {

            }
    }
}