package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
