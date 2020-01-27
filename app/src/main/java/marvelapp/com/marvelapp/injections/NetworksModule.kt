package marvelapp.com.marvelapp.injections

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import marvelapp.com.marvelapp.data.ApiInterface
import marvelapp.com.marvelapp.util.Helper.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworksModule {

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(gson: Gson): Retrofit {

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }


    @Singleton
    @Provides
    internal fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

}