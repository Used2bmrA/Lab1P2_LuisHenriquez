package lab1p2_luishenriquez;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
String nombre;
String apellido;
Date fechaDeNacimiento;
String correoElectronico;
String contrasena;

static SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

    public Usuario(String nombre, String apellido, Date fechaDeNacimiento, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario: " + "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + ToDMY(fechaDeNacimiento) + ", Correo Electronico: " + correoElectronico + ", Contrasena: " + contrasena;
    }
    
    private static String ToDMY(Date fecha){
        long milisDeFechaNacimiento = fecha.getTime(); //Milis desde 1970 hasta fecha de nacimiento
        Date fechaActual = new Date();
        long milisFechaActual = fechaActual.getTime(); //Milis hasta fecha actual
        long tiempoTotalDeVida = milisFechaActual - milisDeFechaNacimiento; //Milis total de tiempo de vida
        int anos = 0;
        int meses = 0;
        int dias = 0;
        String edadTotal;
        
        while (tiempoTotalDeVida >= 1000*60*60*24*365) {
            tiempoTotalDeVida -= 1000*60*60*24*365;
            anos ++;
        }
        
        while (tiempoTotalDeVida >= 1000*60*60*24) {
            tiempoTotalDeVida -= 1000*60*60*24;
            dias ++;
        }
        
        while (dias >= 31) {
            dias -= 31;
            meses ++;
        }
        
        edadTotal = anos + " años," + meses + " meses, " + dias + " dias.";
        
        return edadTotal;
    }
}
