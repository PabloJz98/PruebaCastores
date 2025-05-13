package com.inventario.castores.controller;

import com.inventario.castores.model.MovInventario;
import com.inventario.castores.service.MovimientoInventarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MovimientoInventarioController {
    @Autowired
    private MovimientoInventarioService movimientoInventariosService;

    @GetMapping("/inventario/movimientos")
    @ResponseBody
    public List<MovInventario> obtenerMovimientos() {
        return movimientoInventariosService.obtenerMIs();
    }
    @GetMapping("/movimientoInventarios")
    public String mostrarMovimientoInventarios(Model model) {
        List<MovInventario> movimientoInventarios = movimientoInventariosService.obtenerMIs();
        model.addAttribute("movimientoInventarios", movimientoInventarios);
        return "movimientoInventarios";
    }
}