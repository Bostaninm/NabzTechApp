package com.example.marathonapp.di

import android.content.Context
import com.example.marathonapp.BuildConfig
import com.example.marathonapp.common.ISharedPreferenceApi
import com.example.marathonapp.common.SharedPreferenceApi
import com.example.marathonapp.login.LoginRepository
import com.example.marathonapp.main.MainRepository
import com.example.marathonapp.login.AuthenticationAPI
import com.example.marathonapp.net.api.ProfileAPI
import com.example.marathonapp.login.ILoginRepository
import com.example.marathonapp.main.MainAPI
import com.example.marathonapp.main.IMainRepository
import com.example.marathonapp.profile.IProfileRepository
import com.example.marathonapp.profile.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIContainer {

    @Provides
    @Singleton
    fun provideSharedPreferenceApi(@ApplicationContext context: Context) : ISharedPreferenceApi {
        return SharedPreferenceApi(context)
    }

    @Provides
    @Singleton
    fun provideRetrofitService(sharedPreferenceApi: ISharedPreferenceApi): Retrofit {
        val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val newReq = chain.request().newBuilder()
            sharedPreferenceApi.getToken()?.let {
                newReq.header("Authorization", "Bearer $it")
            }
            return@addInterceptor chain.proceed(newReq.build())
        }

        return Retrofit.Builder().baseUrl(BuildConfig.API_ENDPOINT)
            .client(okHttpClient.build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideAuthenticationApi(retrofitService: Retrofit): AuthenticationAPI {
        return retrofitService.create(AuthenticationAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMarathonApi(retrofitService: Retrofit): ProfileAPI {
        return retrofitService.create(ProfileAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideHealthApi(retrofitService: Retrofit): MainAPI {
        return retrofitService.create(MainAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(sharedPreferenceApi: ISharedPreferenceApi, authenticationAPI: AuthenticationAPI): ILoginRepository {
        return LoginRepository(sharedPreferenceApi, authenticationAPI)
    }

    @Provides
    @Singleton
    fun provideMainRepository(MainAPI: MainAPI): IMainRepository {
        return MainRepository(MainAPI)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(sharedPreferenceApi: ISharedPreferenceApi, profileApi: ProfileAPI) : IProfileRepository {
        return ProfileRepository(sharedPreferenceApi,profileApi)
    }

}