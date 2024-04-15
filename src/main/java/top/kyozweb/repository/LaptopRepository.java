package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}
