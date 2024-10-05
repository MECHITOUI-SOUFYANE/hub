package com.alten.exception;

import com.alten.configuration.LocalResolverConfiguration;

public class ProductNotFoundException extends ProductException{
    public ProductNotFoundException (){
        super(LocalResolverConfiguration.getMessage("product.not.found.exception"));
    }
}
