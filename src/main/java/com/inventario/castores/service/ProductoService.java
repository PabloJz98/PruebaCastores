package com.inventario.castores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.castores.model.Producto;
import com.inventario.castores.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerProductosActivos() {
        return productoRepository.findByStatus(true);
    }

    public List<Producto> obtenerProductosInactivos() {
        return productoRepository.findByStatus(false);
    }

    public Producto agregarProducto(Producto producto) {
        producto.setCantidad(0);
        producto.setStatus(true);
        return productoRepository.save(producto);
    }

    public Producto aumentarProducto(Long idProducto, int cantidad) {
        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setCantidad(producto.getCantidad() + cantidad);
            return productoRepository.save(producto);
        }
        return null;
    }

    public Producto darDeBajaProducto(Long idProducto) {
        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setStatus(false);
            return productoRepository.save(producto);
        }
        return null;
    }

    public Producto activarProducto(Long idProducto) {
        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setStatus(true);
            return productoRepository.save(producto);
        }
        return null;
    }

    public Producto restarProducto(Long idProducto, int cantidad) {
        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            if (producto.getCantidad() >= cantidad) {
                producto.setCantidad(producto.getCantidad() - cantidad);
                return productoRepository.save(producto);
            }
            throw new IllegalArgumentException("No se puede restar más de la cantidad disponible.");
        }
        return null;
    }
}
