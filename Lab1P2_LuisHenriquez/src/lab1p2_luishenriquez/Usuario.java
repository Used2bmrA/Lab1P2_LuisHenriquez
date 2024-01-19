package lab1p2_luishenriquez;

import java.util.Date;

public class Usuario {
String nombre;
String apellido;
Date fechaDeNacimiento;
String correoElectronico;
String contrasena;

    public Usuario(String nombre, String apellido, Date fechaDeNacimiento, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario: " + "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + fechaDeNacimiento + ", Correo Electronico: " + correoElectronico + ", Contrasena: " + contrasena;
    }
    
}
