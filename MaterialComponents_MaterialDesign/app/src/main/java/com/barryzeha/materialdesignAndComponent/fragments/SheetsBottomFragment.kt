package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentSheetsBottomBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetBehavior

class SheetsBottomFragment : Fragment(), View.OnClickListener {
    private lateinit var bind:FragmentSheetsBottomBinding
    private lateinit var bottomSheetBehavior:BottomSheetBehavior<View>;
    private var isExpanded=false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentSheetsBottomBinding.inflate(inflater, container, false)
        bottomSheetBehavior=BottomSheetBehavior.from(bind.bottomSheet.bottomSheet)
        bottomSheetBehavior.state=BottomSheetBehavior.STATE_HIDDEN
        //usaremos el evento de cambio del bottomSheet para obtener su estado
        bottomSheetBehavior.addBottomSheetCallback(object:
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState){
                    BottomSheetBehavior.STATE_EXPANDED->{
                        isExpanded=true

                    }
                    BottomSheetBehavior.STATE_COLLAPSED->{
                        isExpanded=false
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })

        //Implementaremos los eventos de expandir o colapsar el bottomsheet
        //el estado STAE_COLLAPSED solo muestra la parte que nosotros definimos como height para mostrar en el
        //bottomSheet
        bind.btnStandar.setOnLongClickListener {
            bottomSheetBehavior.state=BottomSheetBehavior.STATE_EXPANDED
            true
        }
        bind.btnStandar.setOnClickListener(this)
        bind.btnModal.setOnClickListener(this)
        bind.bottomSheet.imgBtnExpanded.setOnClickListener(this)
        return bind.root
    }

    //definiremos los eventos de click en los botones para manejar el bottomSheet
    override fun onClick(v: View?) {
       when(v?.id){
           R.id.btnStandar->{
               if(bottomSheetBehavior.state==BottomSheetBehavior.STATE_HIDDEN){
                   bottomSheetBehavior.state=BottomSheetBehavior.STATE_COLLAPSED
               }
               else{
                   bottomSheetBehavior.state=BottomSheetBehavior.STATE_HIDDEN
               }
           }
           R.id.btnModal->{

           }
           R.id.imgBtnExpanded->{
               if(isExpanded){
                   bottomSheetBehavior.state=BottomSheetBehavior.STATE_COLLAPSED
                   bind.bottomSheet.imgBtnExpanded.setImageResource(R.drawable.ic_expand_less)
               }
               else{
                   bottomSheetBehavior.state=BottomSheetBehavior.STATE_EXPANDED
                   bind.bottomSheet.imgBtnExpanded.setImageResource(R.drawable.ic_expand_more)
               }
           }
       }
    }

    companion object {

        private lateinit var component: Component
        @JvmStatic
        final val TAG = "SheetsBottom"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_sheets_bottom
            component.type= Constants.STATIC
            return component
        }
    }
}