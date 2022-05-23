package Modelo.UML;

import Modelo.BD.BaseDatos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @Author Iker Gomez
 * @version 1.0
 *
 */
public class Usuario{

    private int id_rol;
    private String username;
    private String password;
    private String codusuario;

    public Usuario(int id_rol, String username, String password, String codusuario) {
        this.id_rol = id_rol;
        this.username = username;
        this.password = password;
        this.codusuario = codusuario;
    }

    public Usuario() {
    }

    public Usuario(String usuario, String password) {
        username = usuario;
        this.password = password;
    }



    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(String codusuario) {
        this.codusuario = codusuario;
    }
}