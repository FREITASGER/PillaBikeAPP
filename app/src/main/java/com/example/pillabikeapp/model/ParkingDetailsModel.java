package com.example.pillabikeapp.model;

import android.content.Context;

import com.example.pillabikeapp.R;
import com.example.pillabikeapp.api.PillaBikeAPI;
import com.example.pillabikeapp.api.PillaBikeApiInterface;
import com.example.pillabikeapp.contract.ParkingDetailsContract;
import com.example.pillabikeapp.domain.Parking;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParkingDetailsModel implements ParkingDetailsContract.Model {

    private Context context; //para poder pasarle el contexto de la aplicacion

    public ParkingDetailsModel(Context context) {
        this.context = context;
    }

    @Override
    public void loadDetailsParking(long parkingId, ParkingDetailsContract.Model.OnLoadParkingListener listener) {

        //Nos devuelve una instancia de happDeporteApi como la definimos en TodoApiInterface, tiene los métodos que usamos para comunicarnos con la API
        PillaBikeApiInterface pillaBikeApi = PillaBikeAPI.buildInstance();
        Call<Parking> callParkings = PillaBikeAPI.buildInstance().getPakingId(parkingId); //Para realizar la llamada y parkings el getParkings definido
        callParkings.enqueue(new Callback<Parking>() {
            @Override
            public void onResponse(Call<Parking> call, Response<Parking> response) {
                listener.onLoadParkingSucess(response.body());
            }

            @Override
            public void onFailure(Call<Parking> call, Throwable t) {
                listener.onLoadParkingError(context.getString(R.string.parking_not_found));
            }
        });
    }
}
