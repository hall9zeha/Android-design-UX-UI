package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.DialogFragment
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentAppBarBottomBinding
import com.barryzeha.materialdesignAndComponent.utils.BottomAppBarCutCornersTopEdge
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AppBarBottomFragment : DialogFragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentAppBarBottomBinding
    private var isCenter=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.myDialogStyle)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentAppBarBottomBinding.inflate(inflater, container, false)
        bind.fab.setOnClickListener {
            if(isCenter){
                bind.appBarBottom.fabAlignmentMode=BottomAppBar.FAB_ALIGNMENT_MODE_END
            }
            else{
                bind.appBarBottom.fabAlignmentMode=BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
            isCenter=!isCenter
        }
        bind.appBarBottom.setOnMenuItemClickListener {

            var res=0
            when(it.itemId){
                R.id.itemFavorites->{res=R.string.menu_favorites}
                R.id.itemHome->{res=R.string.menu_start}
                R.id.itemSettings->{res=R.string.menu_profile}
            }
            Snackbar.make(bind.root,res,Snackbar.LENGTH_LONG).setAnchorView(
                bind.fab).show()

            true
        }
        bind.appBarBottom.setNavigationOnClickListener {
            Snackbar.make(bind.root,"acción de icon navigation",Snackbar.LENGTH_LONG).setAnchorView(
                bind.fab).show()
        }
        //instanciamos la clase que convertira nuetro appBarBottom con espacios tipo diamante para el encaje
        //de nuestro fab que ahora es con bordes cortados
        var topEdge=BottomAppBarCutCornersTopEdge(
            bind.appBarBottom.fabCradleMargin,
            bind.appBarBottom.fabCradleRoundedCornerRadius,
            bind.appBarBottom.cradleVerticalOffset
        )
        var shapeDrawable=bind.appBarBottom.background as MaterialShapeDrawable
        shapeDrawable.shapeAppearanceModel=shapeDrawable.shapeAppearanceModel
            .toBuilder()
            .setTopEdge(topEdge)
            .build()

        return bind.root
    }

    companion object {
        const val TAG="AppBatBottomFragment"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppBarBottomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}