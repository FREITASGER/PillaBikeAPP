package com.example.pillabikeapp.contract;


import com.example.pillabikeapp.domain.Parking;

import java.util.List;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface ParkingListContract {

    /**
     * Que necesita el model para solicitar a la API
     */
    interface Model {
        interface OnLoadParkingListener {
            void onLoadParkingSucess(List<Parking> parkings); //devolvemos una lista de parkings
            void onLoadParkingError(String message); //Devolvemos un posible error
        }
        void loadAllParking(OnLoadParkingListener listener); //quien le llame tiene que tener un listener para que le chive lo que ha pasado
    }

    /**
     * Que recibe la view después de solicitarle al presenter
     */
    interface View {
        void showParking(List<Parking> parkings);
        void showMessage(String message);
    }

    interface Presenter {
        void loadAllParking();
    }
}
