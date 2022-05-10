package com.bluemoonl.ch24shoppingapp.domain

import com.bluemoonl.ch24shoppingapp.data.entity.product.ProductEntity
import com.bluemoonl.ch24shoppingapp.data.repository.ProductRepository


internal class GetProductItemUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(productId: Long): ProductEntity? {
        return productRepository.getProductItem(productId)
    }

}