package com.proyectprogram.program.controlller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proyectprogram.program.Models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class Controllers {
    private List<Product> productos = new ArrayList<>(
        Arrays.asList(new Product(123, "Ensalada", 6000, 10))
    );

    @GetMapping("/productor")
    public List<Product> getproductos() {
        return productos;
    }
    

    @GetMapping("/{nombreproduct}")
    public Product getidProducts(@PathVariable String NombreProduct) {
        for(Product n : productos) {
            if(n.getNombreProduct().equalsIgnoreCase(NombreProduct))
            {
                return n;
            }
        }
        return null;
    }
    
    @PostMapping("/productos")
    public Product postproductos(@RequestBody Product producto) {
        productos.add(producto);
        return producto;
    }
    
    @PutMapping("/producto")
    public Product putproductos(@RequestBody Product producto) {
        for(Product p : productos) {
            if(p.getIdProducts()== (producto.getIdProducts())) {
                p.setNombreProduct(producto.getNombreProduct());
                p.setValor(producto.getValor());
                p.setCantidad(producto.getCantidad());
                return p;
            }
        }
        
        return null;
    }
    
    @DeleteMapping("/{idProducts}")
    public Product deleteProduct(@PathVariable int idProducts) {
        for(Product a : productos) {
            if(a.getIdProducts() == idProducts) {
            productos.remove(a);
            return a;
            }
        }
        return null;
    }
}


