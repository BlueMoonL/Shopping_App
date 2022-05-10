package com.bluemoonl.ch24shoppingapp.domain

import com.bluemoonl.ch24shoppingapp.data.entity.product.ProductEntity
import com.bluemoonl.ch24shoppingapp.data.repository.ProductRepository


internal class GetOrderedProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getLocalProductList()
    }

}