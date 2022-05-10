package com.bluemoonl.ch24shoppingapp.presentation.profile

import android.net.Uri
import com.bluemoonl.ch24shoppingapp.data.entity.product.ProductEntity

internal sealed class ProfileState {

    object Uninitialized: ProfileState()

    object Loading: ProfileState()

    data class Login(
        val idToken: String
    ): ProfileState()

    sealed class Success: ProfileState() {

        data class Registered(
            val userName: String,
            val profileImgUri: Uri?,
            val productList: List<ProductEntity> = listOf()
        ): Success()

        object NotRegistered: Success()

    }

    object Error: ProfileState()

}