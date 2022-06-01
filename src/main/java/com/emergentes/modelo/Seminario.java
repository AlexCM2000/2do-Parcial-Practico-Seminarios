
package com.emergentes.modelo;

import java.sql.Date;


public class Seminario {
    
    private int id;
    private String titulo;
    private Date fecha;
    private int cupos;
    

    public Seminario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Seminarios{" + "id=" + id + ", cupos=" + cupos + ", fecha=" + fecha + ", titulo=" + titulo + '}';
    }
    
}
