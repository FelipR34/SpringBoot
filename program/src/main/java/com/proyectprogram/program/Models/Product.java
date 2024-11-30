package com.proyectprogram.program.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private int idProducts;
    private String NombreProduct;
    private int Valor;
    private int cantidad;
}
