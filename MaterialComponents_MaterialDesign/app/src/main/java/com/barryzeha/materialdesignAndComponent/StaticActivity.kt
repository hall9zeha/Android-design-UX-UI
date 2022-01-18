package com.barryzeha.materialdesignAndComponent

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.barryzeha.materialdesignAndComponent.databinding.ActivityStaticBinding

import com.barryzeha.materialdesignAndComponent.utils.CommonUtils
import com.barryzeha.materialdesignAndComponent.utils.Constants

class StaticActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityStaticBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaticBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)



        var nameFragment:String? = null;
        if(savedInstanceState ==null){
            nameFragment= intent.getStringExtra(Constants.NAME_ARG);
            CommonUtils.setFragment(this, nameFragment, R.id.static_content)

        }
        var actionBar=supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = nameFragment
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflateMenu=menuInflater.inflate(R.menu.menu_bottom_navigation, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}