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
import top.kyozweb.entity.Combo;
import top.kyozweb.service.CategoriaService;
import top.kyozweb.service.ComboService;

@Controller
@RequestMapping("/admin")
public class ComboController {

    @Autowired
    private ComboService comboService;

    @Autowired
	private CategoriaService categoriaService;

    @GetMapping("/combo")
    public String index(Model model) {
        List<Combo> combos = comboService.listarCombo();
        model.addAttribute("tablaCombo", combos);
        return "admin/combo/index";
    }

    @GetMapping("/combo/crear")
    public String crear(Model model) {
        Combo combo = new Combo();
        List<Categoria> categorias = categoriaService.listarCategoria();
        model.addAttribute("formularioCrearCombo", combo);
        model.addAttribute("selectorCategorias", categorias);
        return "admin/combo/crear";
    }

    @PostMapping("/combo/crear")
    public String crear(@ModelAttribute Combo combo,
            @RequestParam("imagen") MultipartFile imagen) throws IOException {
        combo.setImagenNombre(imagen.getOriginalFilename());
        combo.setImagenArchivo(imagen.getBytes());
        comboService.guardarCombo(combo);
        return "redirect:/admin/combo";
    }

    @GetMapping("/combo/editar/{comboId}")
    public String editar(@PathVariable Integer comboId, Model model) {
        Combo combo = comboService.obtenerIdCombo(comboId);
        List<Categoria> categorias = categoriaService.listarCategoria();
        model.addAttribute("combo", combo);
        model.addAttribute("selectorCategorias", categorias);
        return "admin/combo/editar";
    }

    @PostMapping("/combo/editar/{comboId}")
    public String editar(@PathVariable Integer comboId, @ModelAttribute Combo combo,
            @RequestParam("imagen") MultipartFile imagen, 
            @RequestParam("categoriaId") Integer categoriaId) throws IOException {
        Combo comboExistente = comboService.obtenerIdCombo(comboId);
        comboExistente.setNombre(combo.getNombre());
        comboExistente.setStock(combo.getStock());
        comboExistente.setPrecio(combo.getPrecio());
        comboExistente.setDescripcion(combo.getDescripcion());
        comboExistente.setCategoria(categoriaService.obtenerIdCategoria(categoriaId));
        if (!imagen.isEmpty()) {
            comboExistente.setImagenNombre(imagen.getOriginalFilename());
            comboExistente.setImagenArchivo(imagen.getBytes());
        }
        comboService.guardarCombo(comboExistente);
        return "redirect:/admin/combo";
    }

    @GetMapping("/combo/{comboId}")
    public String eliminar(@PathVariable Integer comboId) {
        comboService.eliminarCombo(comboId);
        return "redirect:/admin/combo";
    }
}
