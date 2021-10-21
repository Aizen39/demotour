package fr.pageup.demoapp.data.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = " "

//create moshi object
//private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())

/**
 * Build and create a Retrofit object.
 * Retrofit need the base URI for the web service and a converter,
 * Converter tells Retrofit what to do with data et and it gets back from the ws
 * fetch a json response and return it as a String with ScalarsConverterFactory
 */
private val retrofit = Retrofit.Builder()
        //.addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()







