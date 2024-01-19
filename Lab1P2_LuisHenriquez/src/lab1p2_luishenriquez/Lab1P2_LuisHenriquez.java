package lab1p2_luishenriquez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lab1P2_LuisHenriquez {

static Scanner sc = new Scanner (System.in);
static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido a mi laboratorio.");
        int op = 0;
        
        do {
            System.out.println("¿Qué desea hacer?"
                    + "1. Registrar usuario"
                    + "2. Listar todo"
                    + "3. Listar por dominio"
                    + "4. Salir");
            
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    String nombre = SolicitarNombre();
                    String apellido = SolicitarApellido();
                    Date fechaDeNacimiento = ValidarFechaDeNacimiento();
                    String correoElectronico = "";
                    String contrasena = "";
                    
                    Usuario nuevoUsuario = new Usuario(nombre, apellido, fechaDeNacimiento, correoElectronico, contrasena);
                    usuarios.add(nuevoUsuario);
                    System.out.println("Usuario agregado.\n");
                    
                    break;
                case 2:
                    ListarUsuarios(usuarios);
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción invalida, intente otra vez.");
            }
            
        } while (op != 4);
    }
    
    private static String SolicitarNombre() {
        String nombre = "";
        do {
            System.out.println("Ingrese su nombre:");
            nombre = sc.nextLine();
        } while (nombre.equals(""));
        
        return nombre;
    }

    private static String SolicitarApellido() {
        String apellido = "";
        do {
            System.out.println("Ingrese su nombre:");
            apellido = sc.nextLine();
        } while (apellido.equals(""));
        
        return apellido;
    }

    private static Date ValidarFechaDeNacimiento() {
        Date fechaMinimo = new Date(2011, 0, 19); //Una persona nacida en esta fecha tendría 13 años el 19 de enero del 2024
        Date fechaDeNacimiento;
        String fechaIngresada = "";
        String datosDeFecha[] = new String [3];
        int intsDeFecha[] = new int [3];
        long fechaMinimoMilis = fechaMinimo.getTime(); //Tiempo desde 1970 hasta 19 de enero del 2011
        long treceAnosMilis = 1000*60*60*24*365*13; //MiliSegundos que tiene una persona al cumplir trece años
        long fechaDeNacimientoMilis;
        
        
        do {
            System.out.println("Debes tener 13 años para unirte.");
            System.out.println("Ingrese su fecha de nacimiento en formato \"dd/mm/yyyy\":");
             fechaIngresada = sc.nextLine();
             datosDeFecha = fechaIngresada.split("/");
             for (int i = 0; i < datosDeFecha.length - 1; i++) {
                intsDeFecha[i] = Integer.parseInt(datosDeFecha[i]);
            }
             
             fechaDeNacimiento = new Date(intsDeFecha[2], intsDeFecha[1], intsDeFecha[0]);
             fechaDeNacimientoMilis = fechaDeNacimiento.getTime();
             
        } while ((fechaDeNacimientoMilis - fechaMinimoMilis) < treceAnosMilis); 
        
        return fechaDeNacimiento;
    }

    private static void ListarUsuarios(ArrayList<Usuario> usuarios) {
        
    }
    
    
}
