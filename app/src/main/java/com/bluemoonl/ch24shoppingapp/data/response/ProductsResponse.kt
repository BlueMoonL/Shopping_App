package com.bluemoonl.ch24shoppingapp.data.response

data class ProductsResponse(
    val items: List<ProductResponse>,
    val count: Int
)