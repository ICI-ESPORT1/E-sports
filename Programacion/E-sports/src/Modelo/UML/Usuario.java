package Modelo.UML;

import Modelo.BD.BaseDatos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 */
public class Usuario{

    private int id_rol;
    private String username;
    private String password;
    private String codusuario;

    /**
     *
     * @param id_rol
     * @param username
     * @param password
     * @param codusuario
     */
    public Usuario(int id_rol, String username, String password, String codusuario) {
        this.id_rol = id_rol;
        this.username = username;
        this.password = password;
        this.codusuario = codusuario;
    }

    /**
     * constructor vacio de usuario
     */
    public Usuario() {
    }

    /**
     *
     * @param usuario
     * @param password
     */
    public Usuario(String usuario, String password) {
        username = usuario;
        this.password = password;
    }


    /**
     *
     * @return
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     *
     * @param id_rol
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getCodusuario() {
        return codusuario;
    }

    /**
     *
     * @param codusuario
     */
    public void setCodusuario(String codusuario) {
        this.codusuario = codusuario;
    }
}