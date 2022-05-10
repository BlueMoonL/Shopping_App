package com.bluemoonl.ch24shoppingapp.di

import com.bluemoonl.ch24shoppingapp.data.db.provideDB
import com.bluemoonl.ch24shoppingapp.data.db.provideToDoDao
import com.bluemoonl.ch24shoppingapp.data.network.buildOkHttpClient
import com.bluemoonl.ch24shoppingapp.data.network.provideGsonConverterFactory
import com.bluemoonl.ch24shoppingapp.data.network.provideProductApiService
import com.bluemoonl.ch24shoppingapp.data.network.provideProductRetrofit
import com.bluemoonl.ch24shoppingapp.data.preference.PreferenceManager
import com.bluemoonl.ch24shoppingapp.data.repository.DefaultProductRepository
import com.bluemoonl.ch24shoppingapp.data.repository.ProductRepository
import com.bluemoonl.ch24shoppingapp.domain.DeleteOrderedProductListUseCase
import com.bluemoonl.ch24shoppingapp.domain.GetOrderedProductListUseCase
import com.bluemoonl.ch24shoppingapp.domain.GetProductItemUseCase
import com.bluemoonl.ch24shoppingapp.domain.GetProductListUseCase
import com.bluemoonl.ch24shoppingapp.domain.OrderProductItemUseCase
import com.bluemoonl.ch24shoppingapp.presentation.detail.ProductDetailViewModel
import com.bluemoonl.ch24shoppingapp.presentation.list.ProductListViewModel
import com.bluemoonl.ch24shoppingapp.presentation.main.MainViewModel
import com.bluemoonl.ch24shoppingapp.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    single { Dispatchers.Main }
    single { Dispatchers.IO }

    // ViewModel
    viewModel { MainViewModel() }
    viewModel { ProductListViewModel(get()) }
    viewModel { ProfileViewModel(get(), get(), get()) }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }

    // UseCase
    factory { GetProductListUseCase(get()) }
    factory { GetOrderedProductListUseCase(get()) }
    factory { GetProductItemUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }
    factory { DeleteOrderedProductListUseCase(get()) }

    // Repository
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }

    single { PreferenceManager(androidContext()) }

    // Database
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }

}