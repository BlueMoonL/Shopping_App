package com.bluemoonl.ch24shoppingapp.domain

import com.bluemoonl.ch24shoppingapp.data.repository.ProductRepository

internal class DeleteOrderedProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke() {
        return productRepository.deleteAll()
    }

}