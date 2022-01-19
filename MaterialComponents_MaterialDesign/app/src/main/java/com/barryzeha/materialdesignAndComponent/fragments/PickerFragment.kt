package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentPickerBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialDialogs
import com.google.android.material.snackbar.Snackbar


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PickerFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentPickerBinding

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
        bind= FragmentPickerBinding.inflate(inflater, container, false)
        var builder=MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Escoge una fecha")
        builder.setSelection(System.currentTimeMillis())
        var picker= builder.build()
        bind.btnDialog.setOnClickListener {

            builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar)
            picker = builder.build()
            picker!!.show(parentFragmentManager, picker.toString())
        }
        bind.btnFullPicker.setOnClickListener {
           // builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen)
            builder.setTheme(R.style.fullScreenPicker)
            picker=builder.build()
            picker!!.show(parentFragmentManager, picker.toString())
        }
        picker!!.addOnPositiveButtonClickListener {
            //Snackbar.make(bind.root, R.string. message_action_success,Snackbar.LENGTH_SHORT).show()
            //obteniendo fecha seleccionada

            Snackbar.make(bind.root, picker!!.headerText,Snackbar.LENGTH_SHORT).show()
        }
        picker!!.addOnNegativeButtonClickListener {
            Snackbar.make(bind.root, R.string.dialog_negative,Snackbar.LENGTH_SHORT).show()
        }
        picker!!.addOnCancelListener {
            Snackbar.make(bind.root, R.string. dialog_cancel,Snackbar.LENGTH_SHORT).show()
        }
        return bind.root
    }

    companion object {
        private lateinit var component: Component
        @JvmStatic
        final val TAG = "Picker"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_timepicker
            component.type= Constants.STATIC
            return component
        }
         @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PickerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}