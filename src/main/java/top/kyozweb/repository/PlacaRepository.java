package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Placa;

@Repository
public interface PlacaRepository extends JpaRepository<Placa, Integer>{

}
