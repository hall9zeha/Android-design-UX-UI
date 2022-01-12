package com.barryzeha.materialdesignAndComponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.barryzeha.materialdesignAndComponent.adapters.ComponentAdapter
import com.barryzeha.materialdesignAndComponent.databinding.ActivityMainBinding
import com.barryzeha.materialdesignAndComponent.fragments.BottomNavigationBarFragment
import com.barryzeha.materialdesignAndComponent.fragments.ButtonFragment
import com.barryzeha.materialdesignAndComponent.fragments.SnackbarFragment
import com.barryzeha.materialdesignAndComponent.fragments.TextFieldFragment
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.barryzeha.materialdesignAndComponent.utils.OnClickListener

class MainActivity : AppCompatActivity() , OnClickListener{
    private lateinit var adapter:ComponentAdapter
    private lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setUpComponentAdapter()
    }

    private fun setUpComponentAdapter(){
        adapter= ComponentAdapter(ArrayList(), this)
        adapter.add(ButtonFragment.getInstance())
        adapter.add(BottomNavigationBarFragment.getInstance())
        adapter.add(SnackbarFragment.getInstance())
        adapter.add(TextFieldFragment.getInstance())
        bind.rvComponents.adapter = adapter
    }

    override fun onClick(components: Component?) {
        var intent: Intent?=null

            when(components?.type){
                Constants.SCROLL->intent= Intent(this,ScrollActivity::class.java)
                Constants.STATIC->intent= Intent(this,StaticActivity::class.java)
            }
        intent?.putExtra(Constants.NAME_ARG,components!!.name)

        startActivity(intent)
    }
}