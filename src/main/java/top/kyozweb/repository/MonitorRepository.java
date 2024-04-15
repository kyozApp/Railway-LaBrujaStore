package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Integer>{

}
