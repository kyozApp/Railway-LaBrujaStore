package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
