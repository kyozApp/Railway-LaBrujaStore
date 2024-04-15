package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Ram;

@Repository
public interface RamRepository extends JpaRepository<Ram, Integer>{

}
