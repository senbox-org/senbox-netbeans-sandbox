/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.esa.snap.core.io;

import java.io.IOException;
import java.util.Map;
import org.esa.snap.core.Product;

/**
 *
 * @author Norman
 */
public abstract class ProductReader {
    Object input;
    Map<String, Object> parameters;

    public ProductReader(Object input, Map<String, Object> parameters) {
        this.input = input;
        this.parameters = parameters;
    }
    
    public Product readProduct() throws IOException {
        Product product = readProductImpl();
        product.setProductReader(this);
        return product;
    }

    protected abstract Product readProductImpl() throws IOException;
 
}
