package com.alain.cursos.top;

/* *
 * Project: MD Top from com.alain.cursos.top
 * Created by Alain Nicolás Tello on 10/11/2019 at 06:37 PM
 * All rights reserved 2019.
 * Course Material Design and Theming Professional for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * Cursos Android ANT
 */

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = TopDB.NAME, version = TopDB.VERSION)
public class TopDB {

    static final String NAME = "TopDatabase";
    static final int VERSION = 1;
}
