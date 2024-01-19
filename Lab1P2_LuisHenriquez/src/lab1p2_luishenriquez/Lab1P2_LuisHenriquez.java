package lab1p2_luishenriquez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1P2_LuisHenriquez {

static Scanner sc = new Scanner (System.in);
static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido a mi laboratorio.");
        int op = 0;
        
        do {
            System.out.println("¿Qué desea hacer?\n"
                    + "1. Registrar usuario\n"
                    + "2. Listar todo\n"
                    + "3. Listar por dominio\n"
                    + "4. Salir");
            
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    String nombre = SolicitarNombre();
                    String apellido = SolicitarApellido();
                    Date fechaDeNacimiento = ValidarFechaDeNacimiento();
                    String correoElectronico = SolicitarCorreo();
                    String contrasena = SolicitarContrasena();
                    
                    Usuario nuevoUsuario = new Usuario(nombre, apellido, fechaDeNacimiento, correoElectronico, contrasena);
                    usuarios.add(nuevoUsuario);
                    System.out.println("Usuario agregado.\n");
                    
                    break;
                case 2:
                    ListarUsuarios(usuarios);
                    
                    break;
                case 3:
                    ListarPorDominio(usuarios);
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
        String[] datosDeFecha = new String [3];
        int[] intsDeFecha = new int [3];
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
             
             fechaDeNacimiento = new Date(intsDeFecha[2], intsDeFecha[1] - 1, intsDeFecha[0]);
             fechaDeNacimientoMilis = fechaDeNacimiento.getTime();
             
        } while ((fechaDeNacimientoMilis - fechaMinimoMilis) > treceAnosMilis); 
        
        return fechaDeNacimiento;
    }

    private static void ListarUsuarios(ArrayList<Usuario> usuarios) {
        
        for (int i = 0; i < usuarios.size() - 1; i++) {
            System.out.println((i+1) + ". " + usuarios.get(i).toString());
        }
    }

    private static boolean ValidarCorreo(String email) {
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static String SolicitarCorreo() {
        String email;
        do {
            System.out.println("Ingrese su correo:");
            email = sc.nextLine();
        } while (!ValidarCorreo(email) && !EmailInvalido(email));
        
        
        return email;
    }
    
    private static boolean ValidarContrasena(String contrasena) {
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }

    private static String SolicitarContrasena() {
        String contrasena;
        do {
            System.out.println("Ingrese su contraseña:");
            contrasena = sc.nextLine();
        } while (!ValidarContrasena(contrasena));
        
        return contrasena;
    }

    private static boolean EmailInvalido(String email) {
        String[] dominios= {"Gmail", "Outlook", "Yahoo", "iCloud", "ProtonMail", "FastMail"};
        
        
        for (int i = 0; i < dominios.length - 1; i++) {
            if (email.contains(dominios[i])) {
                return false;
            }
        }
        return true;
    }

    private static void ListarPorDominio(ArrayList<Usuario> usuarios) {
        ArrayList<Usuario> gmail = new ArrayList<>();
        ArrayList<Usuario> outlook = new ArrayList<>();
        ArrayList<Usuario> yahoo = new ArrayList<>();
        ArrayList<Usuario> icloud = new ArrayList<>();
        ArrayList<Usuario> protonmail = new ArrayList<>();
        ArrayList<Usuario> fastmail = new ArrayList<>();
            
        for (int i = 0; i < usuarios.size() - 1; i++) {
            String dominioActual = usuarios.get(i).getCorreoElectronico();
            
            
            if (dominioActual.contains("Gmail")) {
                gmail.add(usuarios.get(i));
            }else if(dominioActual.contains("Outlook")){
                outlook.add(usuarios.get(i));
            }else if (dominioActual.contains("Yahoo")){
                yahoo.add(usuarios.get(i));
            }else if(dominioActual.contains("iCloud")){
                icloud.add(usuarios.get(i));
            }else if(dominioActual.contains("ProtonMail")){
                protonmail.add(usuarios.get(i));
            }else{
                fastmail.add(usuarios.get(i));
            }
        } //Separa los usuarios por dominio
        
        ListarUsuarios(gmail);
        ListarUsuarios(outlook);
        ListarUsuarios(yahoo);
        ListarUsuarios(icloud);
        ListarUsuarios(protonmail);
        ListarUsuarios(fastmail);
        
    }

}
