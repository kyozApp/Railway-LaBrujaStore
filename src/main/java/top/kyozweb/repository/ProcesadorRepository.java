package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Procesador;

@Repository
public interface ProcesadorRepository extends JpaRepository<Procesador, Integer>{

}
