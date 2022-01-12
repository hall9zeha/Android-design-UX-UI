package com.barryzeha.materialdesignAndComponent

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.barryzeha.materialdesignAndComponent.databinding.ActivityScrollBinding
import com.barryzeha.materialdesignAndComponent.utils.CommonUtils
import com.barryzeha.materialdesignAndComponent.utils.Constants

class ScrollActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


    var nameFragment:String? = null;
        if(savedInstanceState ==null){
            nameFragment= intent.getStringExtra(Constants.NAME_ARG);
            CommonUtils.setFragment(this, nameFragment, R.id.scroll_content)

        }
        var actionBar=supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = nameFragment

        }
        binding.toolbar.title = nameFragment
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}