package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Fuente;

@Repository
public interface FuenteRepository extends JpaRepository<Fuente, Integer>{

}
