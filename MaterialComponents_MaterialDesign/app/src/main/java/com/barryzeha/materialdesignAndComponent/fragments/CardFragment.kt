package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentCardBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentCardBinding.inflate(inflater,container,false)
        var request=RequestOptions
            .diskCacheStrategyOf(DiskCacheStrategy.ALL)
            .centerCrop()

        Glide.with(requireActivity()).load("https://w.wallhaven.cc/full/1k/wallhaven-1kl36v.png")
            .apply(request)
            .into(bind.imgLargeCard)

        //rellenando los chips dinámicamente a un groupchip

        val array:IntArray = intArrayOf(R.string.card_chip_demo,R.string.card_chip_demo,R.string.card_chip_demo,R.string.card_chip_demo)
        var id=0
        for(text:Int in array){
            id++
            var chip= Chip(bind.chipGroupLarge.context)
            chip.id=id
            /*chip.isCheckable=true*/
            chip.setOnClickListener { Toast.makeText(activity, chip.id.toString(), Toast.LENGTH_SHORT).show() }
            chip.setText(text)
            bind.chipGroupLarge.addView(chip)
        }
        bind.chipIndividual.setOnClickListener { Toast.makeText(activity, bind.chipIndividual.text, Toast.LENGTH_SHORT).show() }
      bind.chipGroupLarge.setOnCheckedChangeListener { group, checkedId ->
          var chip=bind.chipGroupLarge.findViewById<Chip>(checkedId)
            if(chip.isChecked) {
                Toast.makeText(
                    activity,
                    chip.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }


      }
       bind.chipCheckable.setOnCheckedChangeListener { p0, p1 ->
           if(p1){
               Toast.makeText(activity, "checked enable", Toast.LENGTH_SHORT).show()
           }
           else{
               Toast.makeText(activity, "checked disable", Toast.LENGTH_SHORT).show()
           }

       }
        bind.chipClose.setOnCloseIconClickListener {
            bind.chipClose.visibility=View.GONE
        }
        return bind.root
    }

    companion object {
        private lateinit var component: Component
        @JvmStatic
        final val TAG = "Card"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_cards_template
            component.type= Constants.SCROLL
            return component
        }
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}