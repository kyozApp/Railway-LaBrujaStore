package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Accesorio;

@Repository
public interface AccesorioRepository extends JpaRepository<Accesorio, Integer>{

}
