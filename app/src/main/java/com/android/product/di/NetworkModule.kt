package com.android.product.di

import com.android.product.data.remote.ProductApi
import com.android.product.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
    }

    @Provides
    fun providesProductApi(retrofit: Retrofit): ProductApi{
        return retrofit.create(ProductApi::class.java)
    }
}