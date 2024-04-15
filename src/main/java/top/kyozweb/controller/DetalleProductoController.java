package top.kyozweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.kyozweb.entity.Accesorio;
import top.kyozweb.entity.Almacenamiento;
import top.kyozweb.entity.Casse;
import top.kyozweb.entity.Categoria;
import top.kyozweb.entity.Combo;
import top.kyozweb.entity.Fuente;
import top.kyozweb.entity.Laptop;
import top.kyozweb.entity.Monitor;
import top.kyozweb.entity.Placa;
import top.kyozweb.entity.Procesador;
import top.kyozweb.entity.Ram;
import top.kyozweb.entity.Refrigeracion;
import top.kyozweb.entity.Tarjeta;
import top.kyozweb.service.AccesorioService;
import top.kyozweb.service.AlmacenamientoService;
import top.kyozweb.service.CasseService;
import top.kyozweb.service.CategoriaService;
import top.kyozweb.service.ComboService;
import top.kyozweb.service.FuenteService;
import top.kyozweb.service.LaptopService;
import top.kyozweb.service.MonitorService;
import top.kyozweb.service.PlacaService;
import top.kyozweb.service.ProcesadorService;
import top.kyozweb.service.RamService;
import top.kyozweb.service.RefrigeracionService;
import top.kyozweb.service.TarjetaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/catalogo/detalle")
public class DetalleProductoController {
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
    private ComboService comboService;

    @Autowired
	private CategoriaService categoriaService;

    @GetMapping("/producto/{id}")
    public String detalles(Model model, @PathVariable Integer id, @RequestParam("tipo") String tipo) {

        List<Categoria> categorias = categoriaService.listarCategoria();
        model.addAttribute("vistaCategorias", categorias);

        if ("accesorio".equals(tipo)) {
            Accesorio accesorio = accesorioService.obtenerIdAccesorio(id);
            model.addAttribute("accesorio", accesorio);
        } else if ("almacenamiento".equals(tipo)) {
            Almacenamiento almacenamiento = almacenamientoService.obtenerIdAlmacenamiento(id);
            model.addAttribute("almacenamiento", almacenamiento);
        } else if ("casse".equals(tipo)) {
            Casse casse = casseService.obtenerIdCasse(id);
            model.addAttribute("casse", casse);
        } else if ("fuente".equals(tipo)) {
            Fuente fuente = fuenteService.obtenerIdFuente(id);
            model.addAttribute("fuente", fuente);
        } else if ("laptop".equals(tipo)) {
            Laptop laptop = laptopService.obtenerIdLaptop(id);
            model.addAttribute("laptop", laptop);
        } else if ("monitor".equals(tipo)) {
            Monitor monitor = monitorService.obtenerIdMonitor(id);
            model.addAttribute("monitor", monitor);
        } else if ("placa".equals(tipo)) {
            Placa placa = placaService.obtenerIdPlaca(id);
            model.addAttribute("placa", placa);
        } else if ("procesador".equals(tipo)) {
            Procesador procesador = procesadorService.obtenerIdProcesador(id);
            model.addAttribute("procesador", procesador);
        } else if ("ram".equals(tipo)) {
            Ram ram = ramService.obtenerIdRam(id);
            model.addAttribute("ram", ram);
        } else if ("refrigeracion".equals(tipo)) {
            Refrigeracion refrigeracion = refrigeracionService.obtenerIdRefrigeracion(id);
            model.addAttribute("refrigeracion", refrigeracion);
        } else if ("tarjeta".equals(tipo)) {
            Tarjeta tarjeta = tarjetaService.obtenerIdTarjeta(id);
            model.addAttribute("tarjeta", tarjeta);
        } else if ("combo".equals(tipo)) {
            Combo combo = comboService.obtenerIdCombo(id);
            model.addAttribute("combo", combo);
        }
        return "producto-detalle/index";
    }

}
