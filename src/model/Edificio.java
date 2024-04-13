package model;
import java.util.ArrayList;


public class Edificio {

    private ArrayList<Apartamento> apartamentos;
	
	private String nombre;
    private int cantidadApartamentos;
    private String direccion;
	
    public Edificio(String nombre, int cantidadApartamentos, String direccion) {
        this.nombre = nombre;
        this.cantidadApartamentos = cantidadApartamentos;
        this.direccion = direccion;
		this.apartamentos = new ArrayList<Apartamento>();
    }

    public ArrayList<Apartamento> getApartamentos() {
        return apartamentos;
    }

    /**
     * Descripcion: Añade un nuevo apartamento al arreglo apartamentos
     * pre: El arreglo apartamentos debe estar inicializado
     * pos: El arreglo apartamentos queda modificado con el nuevo apartamento
     * agregado
     * 
     * @param nuevoApartamento Apartamento El apartamento que se va a añadir
     * @return boolean True si se logra añadir el apartamento, False en caso
     *         contrario
     */
    public boolean agregarApartamento(Apartamento nuevoApartamento) {
		
        if(apartamentos.size() < this.cantidadApartamentos){
            this.apartamentos.add(nuevoApartamento);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Descripcion: Calcula el numero de apartamentos disponibles en el Edificio
     * pre: El arreglo apartamentos debe estar inicializado
     * 
     * @return int El numero de apartamentos disponibles en el Edificio
     */
    public int calcularApartamentosDisponibles() {

        return apartamentos.size();

    }

	
	public String getNombre (){
		
		return this.nombre;
		
	}

}
