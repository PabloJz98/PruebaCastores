package com.inventario.castores.service;
import com.inventario.castores.model.MovInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventario.castores.repository.MovimientoInventarioRepository;
import com.inventario.castores.Util.TipoMovimiento;
import com.inventario.castores.model.Producto;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoInventarioService {
    @Autowired 
    private MovimientoInventarioRepository movimientoInventarioRepository;

    public List<MovInventario> obtenerMIs() {
        return movimientoInventarioRepository.findAll();
    }

    public MovInventario registrarMovimiento(Producto producto, int cantidad, TipoMovimiento tipo)
    {
        MovInventario movimiento = new MovInventario();
        movimiento.setCantidad(cantidad);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setProducto(producto);
        movimiento.setTipo(tipo);
        movimiento.setDescripcion("El producto "+producto+ "realizo una "+tipo);
        return movimientoInventarioRepository.save(movimiento);
    }
}