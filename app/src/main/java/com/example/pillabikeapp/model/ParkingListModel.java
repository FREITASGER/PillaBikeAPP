package com.example.pillabikeapp.model;

import android.content.Context;
import android.util.Log;

import com.example.pillabikeapp.api.PillaBikeAPI;
import com.example.pillabikeapp.api.PillaBikeApiInterface;
import com.example.pillabikeapp.contract.ParkingListContract;
import com.example.pillabikeapp.domain.Parking;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParkingListModel implements ParkingListContract.Model {

    private Context context; //para poder pasarle el contexto de la aplicacion

    public ParkingListModel(Context context) {
        this.context = context;
    }

    @Override
    public void loadAllParking(OnLoadParkingListener listener) {
        //Nos devuelve una instancia de happDeporteApi como la definimos en TodoApiInterface, tiene los métodos que usamos para comunicarnos con la API
        PillaBikeApiInterface pillaBikeApi = PillaBikeAPI.buildInstance();
        Call<List<Parking>> callParkings = PillaBikeAPI.buildInstance().getParkings(); //Para realizar la llamada y parkings el getParkings definido
        Log.d("parkings", "Llamada desde el model"); //Para depurar errores y ver si avanza o donde se para
        callParkings.enqueue(new Callback<List<Parking>>() {
            @Override
            public void onResponse(Call<List<Parking>> call, Response<List<Parking>> response) {
                Log.d("parking", "Llamada desde el model Ok"); //linea para depurar y ver que pasa
                List<Parking> parkings = response.body(); //Metemos la respuesta en una lista
                listener.onLoadParkingSucess(parkings); //recibimos la lista por el listener
            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable t) {
                Log.d("parking", "Llamada desde model error"); //linea para depurar y ver que pasa
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadParkingError(message); //recibimos los mensajes de error por listener
            }
        });
    }
}
