package test.previo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Carro {
	
	@Id
	private String placa;
	
	private String color;
	
	private String marca;
	
	private String modelo;
	
	private String cilindraje;

	

}
