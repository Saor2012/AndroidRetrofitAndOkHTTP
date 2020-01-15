package com.example.androidretrofitandokhttp.data;

import com.example.androidretrofitandokhttp.BuildConfig;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTService {
    private final Gson gson;
    private final APIService service;

    private RESTService(Builder builder) {
        this.gson = builder.gson;
        this.service = builder.service;
    }

    public APIService getService() { return service; }

    public static class Builder {
        private final Gson gson;
        private final APIService service;

        public Builder(String baseURL) {
            this.gson = provideGson();
            this.service = provideAPIService(gson, provideOkHTTPClient(), baseURL);
        }

        public RESTService build() {
            return new RESTService(this);
        }

        private OkHttpClient provideOkHTTPClient() {
            final OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(interceptor);
            }
            builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                    .readTimeout(60 * 1000, TimeUnit.MILLISECONDS); //Time connection and timeout
            return builder.build();

        }

        private Gson provideGson() {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            return gsonBuilder.setLenient().create();
        }

        private APIService provideAPIService(Gson gson, OkHttpClient okHttpClient, String storage) {
            return createAPI(APIService.class, storage, okHttpClient, GsonConverterFactory.create(gson));
        }

        private static <T> T createAPI(Class<T> serviceAPI, String baseURL, OkHttpClient okHttpClient, Converter.Factory factory) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.client(okHttpClient).baseUrl(baseURL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(factory);
            return builder.build().create(serviceAPI);
        }

    }
}
