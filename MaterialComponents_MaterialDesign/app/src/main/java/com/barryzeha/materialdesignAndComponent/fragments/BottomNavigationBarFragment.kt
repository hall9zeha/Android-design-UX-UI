package com.barryzeha.materialdesignAndComponent.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentBottomNavigationBarBinding

import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomNavigationBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomNavigationBarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind: FragmentBottomNavigationBarBinding

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
        //no olvides poner , container, false dentro del binding inflate si no quieres problemas con el view
        bind= FragmentBottomNavigationBarBinding.inflate(layoutInflater,container,false)

        //usaremos el badge drawable en el bottombar (ese contador que aparece en ciertos lugares si hay notificaciones)
        //o actualizaciones
        //le seteamos el elemento del menu para quele agrege el badge a ese ícono
        bind.bnvMain.getOrCreateBadge(R.id.itemHome)
        //ahora usamos un objeto badge para customizarlo
        var favoritesBadge:BadgeDrawable = bind.bnvMain.getOrCreateBadge(R.id.itemFavorites)
        favoritesBadge.number=21

        var profileBadge:BadgeDrawable= bind.bnvMain.getOrCreateBadge(R.id.itemSettings)
        //hay un límite en el número de caracteres que poner si se sobrepasa saltra 999+
        //pero podemos modificar ese límite
        profileBadge.number=999
        profileBadge.maxCharacterCount=3
        profileBadge.backgroundColor=Color.CYAN
        profileBadge.badgeTextColor=Color.YELLOW

        return bind.root
    }

    companion object {
        private lateinit var component: Component
        final val TAG = "Bottom Navigation"

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomNavigationBarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun getInstance():Component{
           component =  Component()
           component.name= TAG
            component.photoRes= R.drawable.img_bottomnav_mobile_portrait
            component.type= Constants.STATIC
            return component
        }
    }
}