package model;

public class Controller {

    private Edificio[] edificios;

    public Controller() {

        edificios = new Edificio[50];

    }

    /**
     * Descripcion: Permite crear y añadir un Edificio en el sistema
     * 
     * @return boolean True si se logra añadir el Edificio, False en caso
     *         contrario
     */
    public boolean registrarEdificio(String nombre, int cantidadApartamentos, String direccion) { //listo
		
        for (int i = 0; i < edificios.length; i++) {
			
            if (edificios[i] == null) {
				
                edificios[i] = new Edificio(nombre, cantidadApartamentos, direccion);
                return true;
				
            } else if (edificios[i].getNombre().equals(nombre)) {
				
                return false;
            }
        }
        return false;
    }
	
	public String listaTipoEdificio(){
		
		String lista = "" ;
		
		for(int i=0;i<edificios.length;i++){
			
			if(edificios[i] != null){
				
				lista += "\n"+edificios[i].getNombre();
				
			}
			
		}
			
		return lista;
	}
	
	public String listaApartamentos(){ //listo
		
		TipoApartamento[] apartamentoArray = TipoApartamento.values();
		
		String list = "";
		
		    for (int i = 0; i < apartamentoArray.length; i++){
				
				list += "\n" + (i+1) + "-" + apartamentoArray[i];
			}
			
		return list;
	}

    public Edificio buscarEdificio(String nombreEdificio){

        for (int i = 0; i < edificios.length; i++) {

				
            if (edificios[i] != null && edificios[i].getNombre().equals(nombreEdificio)) {
				
                return edificios[i];
            }
        }

        return null;
    }

    /**
     * Descripcion: Permite crear y añadir un Apartamento a un Edificio en el
     * sistema
     * 
     * @return boolean True si se logra añadir el Apartamento al Edificio, False en
     *         caso contrario
     */
    public boolean registrarApartamentoEnEdificio(String nombreEdificio, String numero, int tipo, int valor) {
		
        Edificio edificio = buscarEdificio(nombreEdificio);

        if (edificio != null){

            TipoApartamento tipoApartamento = TipoApartamento.REGULAR;
		
            switch(tipo){
                
                case 1:
                    tipoApartamento = TipoApartamento.PENTHOUSE;
                break;
                
                case 2:
                    tipoApartamento = TipoApartamento.REGULAR;
                break;
                
                case 3:
                    tipoApartamento = TipoApartamento.FIRST_FLOOR;
                break;
            }

            Apartamento apartamento = new Apartamento(numero, tipoApartamento, valor);

            boolean resultado = edificio.agregarApartamento(apartamento);

            if(resultado==true){
                return true;
            }


        }

        return false;


    }

    /**
     * Descripcion: Retorna el numero de apartamentos disponibles en un Edificio
     * determinado
     * pre: El arreglo Edificios debe estar inicializado
     * 
     * @return int El numero de apartamentos disponibles en el Edificio
     */
    public int consultarApartamentosDisponiblesEnEdificio(String nombreEdificio) {
        
        Edificio edificio = buscarEdificio(nombreEdificio);
         if (edificio != null) {
             return edificio.calcularApartamentosDisponibles();
         }
         return -1;

    }


}