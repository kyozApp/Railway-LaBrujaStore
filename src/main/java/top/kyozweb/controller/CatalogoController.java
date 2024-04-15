package top.kyozweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kyozweb.entity.Accesorio;
import top.kyozweb.entity.Banner;
import top.kyozweb.entity.Almacenamiento;
import top.kyozweb.entity.Casse;
import top.kyozweb.entity.Categoria;
import top.kyozweb.entity.Combo;
import top.kyozweb.entity.Fuente;
import top.kyozweb.entity.Laptop;
import top.kyozweb.entity.Monitor;
import top.kyozweb.entity.Placa;
import top.kyozweb.entity.Procesador;
// import com.labrujastore.entity.Producto;
import top.kyozweb.entity.Ram;
import top.kyozweb.entity.Refrigeracion;
import top.kyozweb.entity.Tarjeta;
import top.kyozweb.service.AccesorioService;
import top.kyozweb.service.AlmacenamientoService;
import top.kyozweb.service.BannerService;
import top.kyozweb.service.CasseService;
import top.kyozweb.service.CategoriaService;
import top.kyozweb.service.ComboService;
import top.kyozweb.service.FuenteService;
import top.kyozweb.service.LaptopService;
import top.kyozweb.service.MonitorService;
import top.kyozweb.service.PlacaService;
import top.kyozweb.service.ProcesadorService;
// import com.labrujastore.service.ProductoService;
import top.kyozweb.service.RamService;
import top.kyozweb.service.RefrigeracionService;
import top.kyozweb.service.TarjetaService;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private AccesorioService accesorioService;

    @Autowired
    private AlmacenamientoService almacenamientoService;

    @Autowired
    private CasseService casseService;

    @Autowired
    private FuenteService fuenteService;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private PlacaService placaService;

    @Autowired
    private ProcesadorService procesadorService;

    @Autowired
    private RamService ramService;

    @Autowired
    private RefrigeracionService refrigeracionService;

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ComboService comboService;

    @GetMapping("producto")
    public String index(Model model) {

        Banner bannerId6 = bannerService.obtenerIdBanner(6);
        model.addAttribute("catalogo", "CATALOGO");

        List<Accesorio> accesorios = accesorioService.listarAccesorio();
        List<Almacenamiento> almacenamientos = almacenamientoService.listarAlmacenamiento();
        List<Casse> casses = casseService.listarCasse();
        List<Fuente> fuentes = fuenteService.listarFuente();
        List<Laptop> laptops = laptopService.listarLaptop();
        List<Monitor> monitores = monitorService.listarMonitor();
        List<Placa> placas = placaService.listarPlaca();
        List<Procesador> procesadores = procesadorService.listarProcesador();
        List<Ram> rams = ramService.listarRam();
        List<Refrigeracion> refrigeraciones = refrigeracionService.listarRefrigeracion();
        List<Tarjeta> tarjetas = tarjetaService.listarTarjeta();
        List<Categoria> categorias = categoriaService.listarCategoria();
        List<Combo> combos = comboService.listarCombo();

        model.addAttribute("bannerId6", bannerId6);
        model.addAttribute("vistaAccesorios", accesorios);
        model.addAttribute("vistaAlmacenamientos", almacenamientos);
        model.addAttribute("vistaCasses", casses);
        model.addAttribute("vistaFuentes", fuentes);
        model.addAttribute("vistaLaptops", laptops);
        model.addAttribute("vistaMonitores", monitores);
        model.addAttribute("vistaPlacas", placas);
        model.addAttribute("vistaProcesadores", procesadores);
        model.addAttribute("vistaRams", rams);
        model.addAttribute("vistaRefrigeraciones", refrigeraciones);
        model.addAttribute("vistaTarjetas", tarjetas);
        model.addAttribute("vistaCategorias", categorias);
        model.addAttribute("vistaCombos", combos);

        return "catalogo/index";
    }

    @GetMapping("/{nombreUrl}")
    public String catalogo_categoria(Model model, @PathVariable String nombreUrl) {

        Banner bannerId6 = bannerService.obtenerIdBanner(6);
        Categoria categoria = categoriaService.obtenerCategoriaNombreUrl(nombreUrl);

        model.addAttribute("nombreCategoria", categoria.getNombre());
        model.addAttribute("nombreURL", categoria.getNombreUrl());
        model.addAttribute("catalogo", categoria.getNombre());


        List<Accesorio> accesoriosCat = accesorioService.obtenerAccesoriosPorCategoria(categoria.getCategoriaId());
        List<Almacenamiento> almacenamientosCat = almacenamientoService.obtenerAlmacenamientosPorCategoria(categoria.getCategoriaId());
        List<Casse> cassesCat = casseService.obtenerCassesPorCategoria(categoria.getCategoriaId());
        List<Fuente> fuentesCat = fuenteService.obtenerFuentesPorCategoria(categoria.getCategoriaId());
        List<Laptop> laptopsCat = laptopService.obtenerLaptopsPorCategoria(categoria.getCategoriaId());
        List<Monitor> monitoresCat = monitorService.obtenerMonitoresPorCategoria(categoria.getCategoriaId());
        List<Placa> placasCat = placaService.obtenerPlacasPorCategoria(categoria.getCategoriaId());
        List<Procesador> procesadoresCat = procesadorService.obtenerProcesadoresPorCategoria(categoria.getCategoriaId());
        List<Ram> ramsCat = ramService.obtenerRamsPorCategoria(categoria.getCategoriaId());
        List<Refrigeracion> refrigeracionesCat = refrigeracionService.obtenerRefrigeracionesPorCategoria(categoria.getCategoriaId());
        List<Tarjeta> tarjetasCat = tarjetaService.obtenerTarjetasPorCategoria(categoria.getCategoriaId());
        List<Combo> combosCat = comboService.obtenerCombosPorCategoria(categoria.getCategoriaId());


        model.addAttribute("bannerId6", bannerId6);
        model.addAttribute("categoria", categoria);

        model.addAttribute("vistaAccesorios", accesoriosCat);
        model.addAttribute("vistaAlmacenamientos", almacenamientosCat);
        model.addAttribute("vistaCasses", cassesCat);
        model.addAttribute("vistaFuentes", fuentesCat);
        model.addAttribute("vistaLaptops", laptopsCat);
        model.addAttribute("vistaMonitores", monitoresCat);
        model.addAttribute("vistaPlacas", placasCat);
        model.addAttribute("vistaProcesadores", procesadoresCat);
        model.addAttribute("vistaRams", ramsCat);
        model.addAttribute("vistaRefrigeraciones", refrigeracionesCat);
        model.addAttribute("vistaTarjetas", tarjetasCat);
        model.addAttribute("vistaCombos", combosCat);

        return "catalogo/index";
    }

    @GetMapping("/producto-detalle")
    public String detalle_Producto() {
        return "producto-detalle/index";
    }

}
