package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Integer> {

}
