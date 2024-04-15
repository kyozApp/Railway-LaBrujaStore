package top.kyozweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kyozweb.entity.Accesorio;
import top.kyozweb.entity.Almacenamiento;
import top.kyozweb.entity.Casse;
import top.kyozweb.entity.Fuente;
import top.kyozweb.entity.Monitor;
import top.kyozweb.entity.Placa;
import top.kyozweb.entity.Procesador;
import top.kyozweb.entity.Ram;
import top.kyozweb.entity.Refrigeracion;
import top.kyozweb.entity.Tarjeta;
import top.kyozweb.service.AccesorioService;
import top.kyozweb.service.AlmacenamientoService;
import top.kyozweb.service.CasseService;
import top.kyozweb.service.FuenteService;
import top.kyozweb.service.MonitorService;
import top.kyozweb.service.PlacaService;
import top.kyozweb.service.ProcesadorService;
import top.kyozweb.service.RamService;
import top.kyozweb.service.RefrigeracionService;
import top.kyozweb.service.TarjetaService;

@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {

    @Autowired
    private ProcesadorService procesadorService;

    @Autowired
    private PlacaService placaService;

    @Autowired
    private RamService ramService;

    @Autowired
    private AlmacenamientoService almacenamientoService;

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private FuenteService fuenteService;

    @Autowired
    private CasseService casseService;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private RefrigeracionService refrigeracionService;

    @Autowired
    private AccesorioService accesorioService;

    @GetMapping("/producto")
    public String index(Model model) {
        List<Accesorio> accesorios = accesorioService.listarAccesorio();
        List<Almacenamiento> almacenamientos = almacenamientoService.listarAlmacenamiento();
        List<Casse> casses = casseService.listarCasse();
        List<Fuente> fuentes = fuenteService.listarFuente();
        List<Monitor> monitores = monitorService.listarMonitor();
        List<Placa> placas = placaService.listarPlaca();
        List<Procesador> procesadores = procesadorService.listarProcesador();
        List<Ram> rams = ramService.listarRam();
        List<Refrigeracion> refrigeraciones = refrigeracionService.listarRefrigeracion();
        List<Tarjeta> tarjetas = tarjetaService.listarTarjeta();

        model.addAttribute("vistaAccesorios", accesorios);
        model.addAttribute("vistaAlmacenamientos", almacenamientos);
        model.addAttribute("vistaCasses", casses);
        model.addAttribute("vistaFuentes", fuentes);
        model.addAttribute("vistaMonitores", monitores);
        model.addAttribute("vistaPlacas", placas);
        model.addAttribute("vistaProcesadores", procesadores);
        model.addAttribute("vistaRams", rams);
        model.addAttribute("vistaRefrigeraciones", refrigeraciones);
        model.addAttribute("vistaTarjetas", tarjetas);
        return "cotizacion/index";
    }

}
