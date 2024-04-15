package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Refrigeracion;

@Repository
public interface RefrigeracionRepository extends JpaRepository<Refrigeracion, Integer>{

}
