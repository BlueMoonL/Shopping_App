package com.bluemoonl.ch24shoppingapp.domain

import com.bluemoonl.ch24shoppingapp.data.entity.product.ProductEntity
import com.bluemoonl.ch24shoppingapp.data.repository.ProductRepository


internal class OrderProductItemUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(productEntity: ProductEntity): Long {
        return productRepository.insertProductItem(productEntity)
    }

}