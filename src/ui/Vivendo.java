package ui;

import java.util.Scanner;
import model.Controller;

public class Vivendo {

    Controller control;
    Scanner reader;

    public Vivendo() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Vivendo exe = new Vivendo();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    private void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Vivendo!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Edificio");
            System.out.println("2) Registrar Apartamento en un Edificio");
            System.out.println("3) Consultar Apartamentos disponibles en un Edificio");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registrarEdificio();
                    break;
                case 2:
                    registrarApartamentoEnEdificio();
                    break;
                case 3:
                    consultarApartamentosDisponiblesEnEdificio();
                    break;

                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Edificio en el sistema
    */
    public void registrarEdificio() {

        reader.nextLine();
		
		System.out.println("Digite el nombre del edificio:");
		String nombre = reader.nextLine();
		
		System.out.println("Digite el numero de apartamentos en el edificio:");
		int cantidadApartamentos = reader.nextInt();
		
        reader.nextLine();
        
		System.out.println("Digite la direccion del edificio:");
		String direccion = reader.nextLine();
		
		boolean resultado = control.registrarEdificio(nombre,cantidadApartamentos,direccion);

		if(resultado){
			System.out.println("El edificio se ha registrado exitosamente");
		}else{
			System.out.println("Error, el edificio no ha sido registrado");
		}
		
    }

     /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Apartamento en un Edificio en el sistema
    */
    public void registrarApartamentoEnEdificio() {
        reader.nextLine();
		
		System.out.println("Digite el nombre del Edificio en que se encuentra el Apartamento:");
		System.out.println(control.listaTipoEdificio());
		
		String edificio = reader.nextLine();
		
		
		System.out.println("Digite numero del apartamento:");
		String numero = reader.nextLine();
		
		System.out.println("Digite el tipo de apartamento:");
		System.out.println(control.listaApartamentos());
		
		int tipo = reader.nextInt();
		
		System.out.println("Digite el valor mensual del apartamento:");
		int valor = reader.nextInt();
		
		boolean resultado = control.registrarApartamentoEnEdificio(edificio, numero, tipo, valor);

        if(resultado){
			System.out.println("El apartamento se ha registrado exitosamente");
		}else{
			System.out.println("Error, el apartamento no ha sido registrado");
		}
		
    }

     /** 
     * Descripcion: Muestra al usuario el numero de Apartamentos disponibles a ser arrendados en un Edificio 
    */
    public void consultarApartamentosDisponiblesEnEdificio() {

        reader.nextLine();

        System.out.println("Cual edifico desea consultar:");
        System.out.println(control.listaTipoEdificio());

        String consultaEdificio = reader.nextLine();

        int numApartamentosDisponibles = control.consultarApartamentosDisponiblesEnEdificio(consultaEdificio);

        if (numApartamentosDisponibles >= 0) {
            System.out.println("El número de apartamentos disponibles en el edificio " + consultaEdificio + " es: " + numApartamentosDisponibles);
        } else {
            System.out.println("El edificio no existe en el sistema.");
        } 



    }

    

}