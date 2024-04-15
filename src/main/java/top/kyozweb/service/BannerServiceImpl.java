package top.kyozweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kyozweb.entity.Banner;
import top.kyozweb.repository.BannerRepository;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner actualizarBanner(Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public void eliminarBanner(Integer bannerId) {
        bannerRepository.deleteById(bannerId);
    }

    @Override
    public Banner guardarBanner(Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public List<Banner> listaBanner() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner obtenerIdBanner(Integer bannerId) {
        return bannerRepository.findById(bannerId).get();
    }

}
