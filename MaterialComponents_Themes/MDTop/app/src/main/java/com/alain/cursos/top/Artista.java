package com.alain.cursos.top;

/* *
 * Project: MD Top from com.alain.cursos.top
 * Created by Alain Nicolás Tello on 10/11/2019 at 06:03 PM
 * All rights reserved 2019.
 * Course Material Design and Theming Professional for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * Cursos Android ANT
 */

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = TopDB.class)
public class Artista extends BaseModel{
    static final String ORDEN = "orden";
    static final String ID = "id";

    @PrimaryKey(autoincrement = true)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private long fechaNacimiento;
    @Column
    private String lugarNacimiento;
    @Column
    private short estatura;
    @Column
    private String notas;
    @Column
    private int orden;
    @Column
    private String fotoUrl;

    Artista() {
    }

    Artista(String nombre, String apellidos, long fechaNacimiento, String lugarNacimiento,
                   short estatura, String notas, int orden, String fotoUrl) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.estatura = estatura;
        this.notas = notas;
        this.orden = orden;
        this.fotoUrl = fotoUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String getApellidos() {
        return apellidos;
    }

    void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    long getFechaNacimiento() {
        return fechaNacimiento;
    }

    void setFechaNacimiento(long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    String getLugarNacimiento() {
        return lugarNacimiento;
    }

    void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    short getEstatura() {
        return estatura;
    }

    void setEstatura(short estatura) {
        this.estatura = estatura;
    }

    String getNotas() {
        return notas;
    }

    void setNotas(String notas) {
        this.notas = notas;
    }

    int getOrden() {
        return orden;
    }

    void setOrden(int orden) {
        this.orden = orden;
    }

    String getFotoUrl() {
        return fotoUrl;
    }

    void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    String getNombreCompleto() {
        return this.nombre + " " + this.apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artista artista = (Artista) o;

        return id == artista.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
