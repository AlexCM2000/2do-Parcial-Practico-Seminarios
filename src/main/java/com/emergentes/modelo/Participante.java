
package com.emergentes.modelo;


public class Participante {
    private int id;
    private String nombres;
    private String apellidos;
    private int confirmado;
    private int seminario_id;
    private String seminario;
    

    public Participante() {
        
    }   

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getSeminario_id() {
        return seminario_id;
    }

    public void setSeminario_id(int seminario_id) {
        this.seminario_id = seminario_id;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", nombre=" + nombres + ", apellidos=" + apellidos + ", seminario_id=" + seminario_id + ", seminario=" + seminario + '}';
    }
    
    
}
