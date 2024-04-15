package top.kyozweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import top.kyozweb.entity.Categoria;
import top.kyozweb.entity.Fuente;
import top.kyozweb.service.CategoriaService;
import top.kyozweb.service.FuenteService;

@Controller
@RequestMapping("/admin")
public class FuenteController {
    @Autowired
    private FuenteService fuenteService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/fuente")
    public String index(Model model) {
        List<Fuente> fuentes = fuenteService.listarFuente();
        model.addAttribute("tablaFuente", fuentes);
        return "admin/fuente/index";
    }

    @GetMapping("/fuente/crear")
    public String crear(Model model) {
        Fuente fuente = new Fuente();
        List<Categoria> categorias = categoriaService.listarCategoria();
        model.addAttribute("formularioCrearFuente", fuente);
        model.addAttribute("selectorCategorias", categorias);
        return "admin/fuente/crear";
    }

    @PostMapping("/fuente/crear")
    public String crear(@ModelAttribute Fuente fuente,
            @RequestParam("imagen") MultipartFile imagen) throws IOException {
        fuente.setImagenNombre(imagen.getOriginalFilename());
        fuente.setImagenArchivo(imagen.getBytes());
        fuenteService.guardarFuente(fuente);
        return "redirect:/admin/fuente";
    }

    @GetMapping("/fuente/editar/{fuenteId}")
    public String editar(@PathVariable Integer fuenteId, Model model) {
        Fuente fuente = fuenteService.obtenerIdFuente(fuenteId);
        List<Categoria> categorias = categoriaService.listarCategoria();
        model.addAttribute("fuente", fuente);
        model.addAttribute("selectorCategorias", categorias);
        return "admin/fuente/editar";
    }

    @PostMapping("/fuente/editar/{fuenteId}")
    public String editar(@PathVariable Integer fuenteId, @ModelAttribute Fuente fuente,
            @RequestParam("imagen") MultipartFile imagen, @RequestParam("stock") Integer stock,
            @RequestParam("precio") Double precio, @RequestParam("descripcion") String descripcion,
            @RequestParam("url") String url, @RequestParam("estado") String estado,
            @RequestParam("categoriaId") Integer categoriaId) throws IOException {
        Fuente fuenteExistente = fuenteService.obtenerIdFuente(fuenteId);
        fuenteExistente.setNombre(fuente.getNombre());
        fuenteExistente.setStock(stock);
        fuenteExistente.setPrecio(precio);
        fuenteExistente.setDescripcion(descripcion);
        fuenteExistente.setUrl(url);
        fuenteExistente.setEstado(estado);
        fuenteExistente.setCategoria(categoriaService.obtenerIdCategoria(categoriaId));
        if (!imagen.isEmpty()) {
            fuenteExistente.setImagenNombre(imagen.getOriginalFilename());
            fuenteExistente.setImagenArchivo(imagen.getBytes());
        }
        fuenteService.guardarFuente(fuenteExistente);
        return "redirect:/admin/fuente";
    }

    @GetMapping("/fuente/{fuenteId}")
    public String eliminar(@PathVariable Integer fuenteId) {
        fuenteService.eliminarFuente(fuenteId);
        return "redirect:/admin/fuente";
    }
}
