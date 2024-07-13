package org.learning.edmsvc.productsservice.query;

import org.axonframework.queryhandling.QueryHandler;
import org.learning.edmsvc.productsservice.core.data.ProductEntity;
import org.learning.edmsvc.productsservice.core.data.ProductRepository;
import org.learning.edmsvc.productsservice.query.rest.ProductRestModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsQueryHandler {

    private final ProductRepository productsRepository;

    public ProductsQueryHandler(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
        List<ProductRestModel> productRestModels = new ArrayList<>();

        List<ProductEntity> storedProducts = productsRepository.findAll();

        for (ProductEntity productEntity: storedProducts) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productRestModels.add(productRestModel);
        }

        return productRestModels;
    }
}
