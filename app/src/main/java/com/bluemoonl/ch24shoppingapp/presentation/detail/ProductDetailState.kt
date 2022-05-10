package com.bluemoonl.ch24shoppingapp.presentation.detail

import com.bluemoonl.ch24shoppingapp.data.entity.product.ProductEntity


sealed class ProductDetailState {

    object Uninitialized: ProductDetailState()

    object Loading: ProductDetailState()

    data class Success(
        val productEntity: ProductEntity
    ): ProductDetailState()

    object Order: ProductDetailState()

    object Error: ProductDetailState()

}