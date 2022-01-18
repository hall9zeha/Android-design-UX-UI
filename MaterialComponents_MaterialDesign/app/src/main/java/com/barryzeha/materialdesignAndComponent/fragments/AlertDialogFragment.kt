package com.barryzeha.materialdesignAndComponent.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.transaction
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentAlertDialogBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.google.android.material.dialog.MaterialAlertDialogBuilder


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AlertDialogFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentAlertDialogBinding

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
        bind= FragmentAlertDialogBinding.inflate(inflater, container,false)
        bind.btnInfo.setOnClickListener {
            MaterialAlertDialogBuilder(requireActivity())
                .setTitle(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_ok, null)
                .show()
        }
        bind.btnChoose.setOnClickListener {
            var adapter= ArrayAdapter<String>(requireActivity(),android.R.layout.select_dialog_item)
            adapter.add("Opción 1")
            adapter.add("Opción 2")
            adapter.add("Opción 3")

            MaterialAlertDialogBuilder(requireActivity())
                .setTitle(R.string.dialog_chooser)
                .setAdapter(adapter,object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, i: Int) {
                        Toast.makeText(activity, adapter.getItem(i), Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }
        bind.btnConfirm.setOnClickListener {
            //el tema por defecto
            //MaterialAlertDialogBuilder(requireActivity())
            //sobreescribimos el por defecto por este otro
            //MaterialAlertDialogBuilder(requireActivity(), R.style.ThemeOverlay_MaterialComponents_Dialog)
            //ahor aeste otro
            MaterialAlertDialogBuilder(requireActivity(), R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)

                .setTitle(R.string.dialog_confirm_title)
                .setMessage(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_confirm
                ) { dialog, i ->
                    Toast.makeText(activity, R.string.message_action_success, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(R.string.dialog_cancel, null)
                .show()
        }
        bind.btnFullscreen.setOnClickListener {
            var fulldialog=FullscreenDialogFragment()
            var transaction=fragmentManager?.beginTransaction()
            fulldialog.show(transaction!!,FullscreenDialogFragment.TAG)
        }
        return bind.root
    }

    companion object {
        private lateinit var component: Component
        @JvmStatic
        final val TAG = "Dialog"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_dialog_mobile_alert
            component.type= Constants.STATIC
            return component
        }
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlertDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}