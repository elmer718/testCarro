package test.previo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.previo.entidades.Carro;
import test.previo.repositorio.CarroRepositorio;

@RestController
@RequestMapping("/carro")
public class CarroControl {
	
	@Autowired
	CarroRepositorio carroRepositorio;
	
	@GetMapping
	public List<Carro> getCarroAll(){
		
		return carroRepositorio.findAll();
		
	}
	
	@GetMapping("/{placa}")
	public Carro getCategoriasbyId(@PathVariable String placa) {
		
		Optional<Carro> carro = carroRepositorio.findById(placa);
		
		if (carro.isPresent()) {
			return carro.get();
		}
		
		return null;
	}
	
	@PostMapping("/{placa}")
	public Carro create(@RequestBody Carro carro) {
		
		carroRepositorio.save(carro);
		
		return carro;
	}
	
	@PutMapping("/{placa}")
	public Carro putCarrosbyId(@PathVariable String placa, @RequestBody Carro carro) {
		
		Optional<Carro> carroCurrent = carroRepositorio.findById(placa);
		
		if (carroCurrent.isPresent()) {
			
			Carro carroReturn = carroCurrent.get();
			
			carroReturn.setCilindraje(carro.getCilindraje());
			carroReturn.setColor(carro.getColor());
			carroReturn.setMarca(carro.getMarca());
			carroReturn.setModelo(carro.getModelo());
			
			carroRepositorio.save(carroReturn);
			
			return carroReturn;
		}
		
		return null;

	}
	
	@DeleteMapping("/{placa}")
	public Carro deleteCategoriasbyId(@PathVariable String placa) {
		
		Optional<Carro> categoria = carroRepositorio.findById(placa);
		
		if (categoria.isPresent()) {
			
			Carro categoriaReturn = categoria.get();
			
			carroRepositorio.deleteById(placa);
			
			return categoriaReturn;
		}
		
		return null;

	}
}
