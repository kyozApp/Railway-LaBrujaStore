package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Almacenamiento;

@Repository
public interface AlmacenamientoRepository extends JpaRepository<Almacenamiento, Integer>{

}
