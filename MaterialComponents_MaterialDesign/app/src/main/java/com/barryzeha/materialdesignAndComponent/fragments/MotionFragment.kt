package com.barryzeha.materialdesignAndComponent.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionManager
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentMotionBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class MotionFragment : Fragment(), View.OnClickListener {

    private lateinit var bind:FragmentMotionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentMotionBinding.inflate(inflater, container, false)
        bind.btnClose.setOnClickListener(this)
        bind.fabMotionStart.setOnClickListener(this)
        bind.includedButton.btnCustom.setOnClickListener(this)
        bind.btnBack.setOnClickListener(this)
        return bind.root
    }

    override fun onClick(view: View?) {
        //para detonar las animaciones de motion escribiremos el siguiente código
        var transform =MaterialContainerTransform()

        //Al ejecutarse por defecto en un fullscreen la pantalla se oscurecerá entonces le ponemos un color transparente
        transform.scrimColor= Color.TRANSPARENT

        transform.duration = 500L
        when(view?.id){
            R.id.btnClose->{
                transform.startView=bind.ctlMotionEnd
                transform.endView=bind.fabMotionStart
                transform.addTarget(bind.fabMotionStart)
                TransitionManager.beginDelayedTransition(bind.motionContainerMain, transform)
                bind.ctlMotionEnd.visibility=View.GONE
                bind.fabMotionStart.visibility=View.VISIBLE
            }
            R.id.fabMotionStart->{
                //agregamos un efecto de movimiento al fab
                transform.setPathMotion(MaterialArcMotion())
                transform.startView=bind.fabMotionStart
                transform.endView=bind.ctlMotionEnd
                transform.addTarget(bind.ctlMotionEnd)
                TransitionManager.beginDelayedTransition(bind.motionContainerMain, transform)
                bind.fabMotionStart.visibility=View.GONE
                bind.ctlMotionEnd.visibility=View.VISIBLE

            }
            R.id.btnCustom->{
                //para usar el patrón ShareAxis que hará aparecer una vista sobre otra como si fuera un navPager
                //usaremos lo siguiente
                var sharedAxis=MaterialSharedAxis(MaterialSharedAxis.X, true)
                TransitionManager.beginDelayedTransition(bind.ctlMotionEnd, sharedAxis)
                bind.viewOut.visibility=View.GONE
                bind.viewIn.visibility=View.VISIBLE


            }
            R.id.btnBack->{
                //Al hacer el efecto en reversa
                var sharedAxis=MaterialSharedAxis(MaterialSharedAxis.X, false)
                TransitionManager.beginDelayedTransition(bind.ctlMotionEnd, sharedAxis)
                bind.viewOut.visibility=View.VISIBLE
                bind.viewIn.visibility=View.GONE
            }

        }
    }

    companion object {
        private lateinit var component: Component
        @JvmStatic
        final val TAG = "Motion"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_motion
            component.type= Constants.STATIC
            return component
        }
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MotionFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}