package lab1p2_luishenriquez;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab1P2_LuisHenriquez {

static Scanner sc = new Scanner (System.in);

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
//                    String correoElectronico = ;
//                    String contrasena = ;
//                    
//                    Usuario nuevoUsuario = new Usuario(nombre, apellido, )
                    break;
                case 2:
                    
                    
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
        Date fechaMinimo = new Date(2011, 0, 19);
        Date fechaDeNacimiento;
        String fechaIngresada = "";
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String datos[] = new String [3];
        
        
        do {
            System.out.println("Ingrese su fecha de nacimiento en formato \"dd/mm/yyyy\":");
             fechaIngresada = sc.nextLine();
             datos = fechaIngresada.split("/");
             for (int i = 0; i < datos.length - 1; i++) {
                Integer.parseInt(datos[i]);
            }
             fechaDeNacimiento = new Date(0, 0, 0);
        } while (fechaDeNacimiento.after(fechaMinimo));
        
        return fechaDeNacimiento;
    }
}
