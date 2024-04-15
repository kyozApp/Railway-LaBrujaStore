package top.kyozweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import top.kyozweb.entity.Accesorio;
import top.kyozweb.entity.Almacenamiento;
import top.kyozweb.entity.Banner;
import top.kyozweb.entity.Casse;
import top.kyozweb.entity.Categoria;
import top.kyozweb.entity.Combo;
import top.kyozweb.entity.Fuente;
import top.kyozweb.entity.Laptop;
import top.kyozweb.entity.Marca;
import top.kyozweb.entity.Monitor;
import top.kyozweb.entity.Placa;
import top.kyozweb.entity.Procesador;
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
import top.kyozweb.service.MarcaService;
import top.kyozweb.service.MonitorService;
import top.kyozweb.service.PlacaService;
import top.kyozweb.service.ProcesadorService;
import top.kyozweb.service.RamService;
import top.kyozweb.service.RefrigeracionService;
import top.kyozweb.service.TarjetaService;

@Controller
public class HomeController {
	@Autowired
	private BannerService bannerService;

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private ComboService comboService;

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

	@GetMapping("/")
	public String index(Model model) {

		List<Marca> marcas = marcaService.listarMarca();
		List<Combo> combos = comboService.listarCombo();

		Banner bannerId1 = bannerService.obtenerIdBanner(1);
		Banner bannerId2 = bannerService.obtenerIdBanner(2);
		Banner bannerId3 = bannerService.obtenerIdBanner(3);
		Banner bannerId4 = bannerService.obtenerIdBanner(4);
		Banner bannerId5 = bannerService.obtenerIdBanner(5);

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

		model.addAttribute("vistaMarcas", marcas);
		model.addAttribute("vistaCombos", combos);
        model.addAttribute("vistaCategorias", categorias);

		model.addAttribute("bannerId1", bannerId1);
		model.addAttribute("bannerId2", bannerId2);
		model.addAttribute("bannerId3", bannerId3);
		model.addAttribute("bannerId4", bannerId4);
		model.addAttribute("bannerId5", bannerId5);

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

		return "index";
	}

	@GetMapping("/detalle/producto/{id}")
	public String detalles(Model model, @PathVariable Integer id, @RequestParam("tipo") String tipo) {
		if ("accesorio".equals(tipo)) {
			Accesorio accesorio = accesorioService.obtenerIdAccesorio(id);
			model.addAttribute("accesorio", accesorio);
		} else if ("almacenamiento".equals(tipo)) {
			Almacenamiento almacenamiento = almacenamientoService.obtenerIdAlmacenamiento(id);
			model.addAttribute("almacenamiento", almacenamiento);
		} else if ("casse".equals(tipo)) {
			Casse casse = casseService.obtenerIdCasse(id);
			model.addAttribute("casse", casse);
		}
		return "producto-detalle/prueba";
	}

}
