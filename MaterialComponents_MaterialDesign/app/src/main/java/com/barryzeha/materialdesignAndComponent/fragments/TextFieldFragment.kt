package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentTextFieldBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var bind:FragmentTextFieldBinding

class TextFieldFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

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
        bind= FragmentTextFieldBinding.inflate(inflater,container,false)
        bind.tilCapitalLetter.setEndIconOnClickListener {
            bind.edtCapitalLetter.text?.let{
                var stringContent=bind.edtCapitalLetter.text.toString()
                bind.edtCapitalLetter.setText(stringContent.uppercase())
            }
        }
        bind.edtPrice.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if(bind.edtPrice.text.toString().isNotEmpty() && bind.edtPrice.text.toString().toInt() < 5){
                    bind.edtPrice.error = getString(R.string.error_price_min)
                }
            }

        })
        return bind.root
    }

    companion object {

        private lateinit var component: Component
        @JvmStatic
        final val TAG = "TextField"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_textfields_outlined_active
            component.type= Constants.SCROLL
            return component
        }
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TextFieldFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}