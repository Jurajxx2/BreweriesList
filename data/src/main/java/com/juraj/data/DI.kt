package com.juraj.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.juraj.data.api.BreweryApi
import com.juraj.data.local.BreweryDao
import com.juraj.data.local.BreweryDatabase
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .addInterceptor {

            val newRequest = it.request().newBuilder()
                // TODO add bearer token in case authorization token is needed
                //.addHeader("Authorization", "blablablabla")
                .build()
            it.proceed(newRequest)
        }
        .build()
}


fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()


fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.openbrewerydb.org/v1/")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun provideBreweriesService(retrofit: Retrofit): BreweryApi =
    retrofit.create(BreweryApi::class.java)

fun provideAppDatabase(application: Application): BreweryDatabase {
    return Room
        .databaseBuilder(
            application,
            BreweryDatabase::class.java,
            "breweries_database"
        )
        .build()
}

fun provideBreweryDao(breweryDatabase: BreweryDatabase): BreweryDao {
    return breweryDatabase.breweryDao()
}

val dataModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { provideBreweriesService(get()) }
    single { provideAppDatabase(get()) }
    single { provideBreweryDao(get()) }
}

