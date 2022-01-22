package com.alain.cursos.top;

/* *
 * Project: MD Top from com.alain.cursos.top
 * Created by Alain Nicolás Tello on 10/11/2019 at 06:36 PM
 * All rights reserved 2019.
 * Course Material Design and Theming Professional for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * Cursos Android ANT
 */

import android.view.View;

import java.util.HashMap;

interface OnItemClickListener {
    //void onItemClick(Artista artista);
    //usaremos el map para pasar pares de elementos ya que son demasiados parámetros
    void onItemClick(Artista artista, HashMap<String,View> views);
    void onLongItemClick(Artista artista);
}
