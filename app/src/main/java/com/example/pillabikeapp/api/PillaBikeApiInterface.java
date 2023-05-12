package com.example.pillabikeapp.api;

import com.example.pillabikeapp.model.Bike;
import com.example.pillabikeapp.model.Parking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Para definir las operaciones que queremos dar visibilidad en nuestro Aplicacion android provenientes de la API
 */
public interface PillaBikeApiInterface {

    /**
     * Parking
     */
    @GET("parkings")
    Call<List<Parking>> getParkings(); //devuelve una lista de parkings

    @GET("parkings/{parkingId}")
    Call<Parking> getPakingId(@Path("parkingId") long parkingId); //Devuelve un parking por Id

    /**
     * Bikes
     */
    @GET("bikes")
    Call<List<Bike>> getBikes(); //devuelve una lista de bikes

    @GET("bikes/{bikeId}")
    Call<Bike> getBikeId(@Path("bikeId") long bikeId); //Devuelve una bike por Id
}
