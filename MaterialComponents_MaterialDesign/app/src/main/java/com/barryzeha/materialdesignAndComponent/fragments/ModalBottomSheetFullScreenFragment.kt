package com.barryzeha.materialdesignAndComponent.fragments

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.transition.TransitionManager
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentModalBottomSheetFullScreenBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider


class ModalBottomSheetFullScreenFragment : BottomSheetDialogFragment() {

    private lateinit var bind:FragmentModalBottomSheetFullScreenBinding
    private lateinit var bottomSheetBehavior:BottomSheetBehavior<View>
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var bottomSheetDialog= super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bind= FragmentModalBottomSheetFullScreenBinding.inflate(LayoutInflater.from(context))
        bottomSheetDialog.setContentView(bind.root)

        //para hacer que el bottomsheet se muestre a pantalla completa al expandir hacemos el truco
        //de agregarle una mitad de pixeles que faltan en un view en la parte final del diseño
        //Esa es una opción sencilla pero hay otras

        bind.viewExtraSpace.minimumHeight=(Resources.getSystem().displayMetrics.heightPixels) /2
        bottomSheetBehavior= BottomSheetBehavior.from(bind.root.parent as View)
        bottomSheetBehavior.state=BottomSheetBehavior.STATE_HALF_EXPANDED
        bottomSheetBehavior.addBottomSheetCallback(object:BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                /*
                * Agregamos una animación al cambio de toolbar el expandir y colapsar la vista, esta implementación viene desde
                * la sección del curso de motion
                * */
                var fadeThrough=MaterialFadeThrough()
                fadeThrough.duration = 550L
                fadeThrough.secondaryAnimatorProvider=SlideDistanceProvider(Gravity.TOP)
                TransitionManager.beginDelayedTransition(bind.containerBar,fadeThrough)


                var statusBarColor=ContextCompat.getColor(requireContext(), R.color.purple_700)
                if(BottomSheetBehavior.STATE_EXPANDED==newState){
                    bind.appBar.visibility=View.VISIBLE
                    bind.llBar.visibility=View.GONE
                    statusBarColor=ContextCompat.getColor(requireContext(), R.color.teal_700)
                }
                else if(BottomSheetBehavior.STATE_COLLAPSED==newState){
                    bind.appBar.visibility=View.GONE
                    bind.llBar.visibility=View.VISIBLE
                }
                requireActivity().window.statusBarColor=statusBarColor
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })

        bind.imgBtnCancel.setOnClickListener { bottomSheetBehavior.state=BottomSheetBehavior.STATE_HIDDEN }

        return bottomSheetDialog
    }


    companion object {
    const val TAG="Modal BottomSheet FullScreen"
    }
}