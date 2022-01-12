package com.barryzeha.materialdesignAndComponent.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.barryzeha.materialdesignAndComponent.ButtonFragment;


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

        }
        return fragment;
    }
}
