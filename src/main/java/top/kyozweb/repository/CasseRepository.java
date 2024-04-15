package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Casse;

@Repository
public interface CasseRepository extends JpaRepository<Casse, Integer>{

}
