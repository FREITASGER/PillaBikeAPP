package com.example.pillabikeapp.contract;

import com.example.pillabikeapp.domain.Parking;

import java.util.List;

public interface ParkingDetailsContract {

    /**
     * Que necesita el model para solicitar a la API
     */
    interface Model {
        interface OnLoadParkingListener {
            void onLoadParkingSucess(Parking parking); //devolvemos un parkings
            void onLoadParkingError(String message); //Devolvemos un posible error
        }
        void loadDetailsParking(long parkingId, ParkingDetailsContract.Model.OnLoadParkingListener listener); //quien le llame tiene que tener un listener para que le chive lo que ha pasado
    }

    /**
     * Que recibe la view después de solicitarle al presenter
     */
    interface View {
        void showParking(Parking parking);
        void showMessage(String message);
    }

    interface Presenter {
        void loadDetailsParking(long parkingId);
    }
}
