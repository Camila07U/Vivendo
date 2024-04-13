package model;

public class Apartamento {
	
	private String numeroApartamento;
	private TipoApartamento tipo;
	private int costoRenta;
	
	public Apartamento(String numeroApartamento, TipoApartamento tipo, int costoRenta){
	
		this.numeroApartamento = numeroApartamento;
		this.tipo = tipo;
		this.costoRenta = costoRenta;
	
	}
	
}