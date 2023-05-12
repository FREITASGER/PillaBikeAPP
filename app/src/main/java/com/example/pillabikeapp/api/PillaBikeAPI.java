package com.example.pillabikeapp.api;

import static com.example.pillabikeapp.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PillaBikeAPI {

    /**
     * Método para instanstanciar la libreria retrofit y consumir la API
     *
     */
    public static PillaBikeApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder() //creamos el objeto retrofit
                .baseUrl(BASE_URL) //URL BASE de la API
                .addConverterFactory(GsonConverterFactory.create()) //Para convertir los Gson
                .build();

        return retrofit.create(PillaBikeApiInterface.class); //devolvemos la libreria retrofit para usarla en la conexión
    }
}
