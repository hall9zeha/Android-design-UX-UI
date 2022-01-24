package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentBottomNavigationBarBinding
import com.barryzeha.materialdesignAndComponent.databinding.FragmentBottomNavigationDrawerBinding
import com.barryzeha.materialdesignAndComponent.utils.BottomAppBarCutCornersTopEdge
import com.google.android.material.shape.MaterialShapeDrawable

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BottomNavigationDrawerFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind: FragmentBottomNavigationDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.myDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentBottomNavigationDrawerBinding.inflate(inflater, container, false)
        var topEdge= BottomAppBarCutCornersTopEdge(
            bind.bottomBar.appBarBottom.fabCradleMargin,
            bind.bottomBar.appBarBottom.fabCradleRoundedCornerRadius,
            bind.bottomBar.appBarBottom.cradleVerticalOffset
        )
        var shapeDrawable=bind.bottomBar.appBarBottom.background as MaterialShapeDrawable
        shapeDrawable.shapeAppearanceModel=shapeDrawable.shapeAppearanceModel
            .toBuilder()
            .setTopEdge(topEdge)
            .build()
        bind.bottomBar.appBarBottom.setNavigationOnClickListener {
            var fragment=ModalBottomSheetFragment()
            fragment.show(parentFragmentManager.beginTransaction(), ModalBottomSheetFragment.TAG)
        }
        return bind.root
    }

    companion object {

        val TAG="Bottom Navigation Drawer"


    }
}