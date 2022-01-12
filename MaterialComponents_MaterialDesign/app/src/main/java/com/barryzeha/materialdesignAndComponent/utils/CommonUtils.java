package com.barryzeha.materialdesignAndComponent.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.barryzeha.materialdesignAndComponent.fragments.BottomNavigationBarFragment;
import com.barryzeha.materialdesignAndComponent.fragments.ButtonFragment;
import com.barryzeha.materialdesignAndComponent.fragments.SnackbarFragment;


public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment= getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String name) {
        Fragment fragment=null;
        switch (name){
            case "Button":
                fragment= new ButtonFragment();
                break;
            case  "Bottom Navigation":
                fragment= new BottomNavigationBarFragment();
                break;
            case  "Snackbar":
                fragment= new SnackbarFragment();
                break;

        }
        return fragment;
    }
}
