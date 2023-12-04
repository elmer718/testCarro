package test.previo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import test.previo.entidades.Carro;

public interface CarroRepositorio extends JpaRepository<Carro, String> {

}
