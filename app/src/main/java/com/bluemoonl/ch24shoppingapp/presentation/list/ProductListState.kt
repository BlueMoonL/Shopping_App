package com.bluemoonl.ch24shoppingapp.presentation.list

import com.bluemoonl.ch24shoppingapp.data.entity.product.ProductEntity

internal sealed class ProductListState {

    object UnInitialized : ProductListState()

    object Loading : ProductListState()

    data class Success(
        val productList: List<ProductEntity>
    ) : ProductListState()

    object Error : ProductListState()
}