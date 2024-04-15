package top.kyozweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.kyozweb.entity.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {

}
