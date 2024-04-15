package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Subcategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<Subcategoria, Integer>
{
    
}
