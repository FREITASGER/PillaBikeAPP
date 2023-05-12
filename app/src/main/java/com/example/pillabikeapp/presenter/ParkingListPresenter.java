package com.example.pillabikeapp.presenter;

import com.example.pillabikeapp.contract.ParkingListContract;
import com.example.pillabikeapp.domain.Parking;
import com.example.pillabikeapp.model.ParkingListModel;
import com.example.pillabikeapp.view.ParkingListView;

import java.util.List;

public class ParkingListPresenter implements ParkingListContract.Presenter, ParkingListContract.Model.OnLoadParkingListener {

    /**
     * Le pasamos el model y la view ya que es el único que conoce a ambos
     */
    private ParkingListModel model;
    private ParkingListView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public ParkingListPresenter(ParkingListView view) {
        this.view = view; //le pasamos la vista desde el presenter al modelo
        this.model = new ParkingListModel(view.getApplicationContext()); //le pasamos el contexto
    }

    /**
     * Método que llama al model para pedirle el listado
     */
    @Override
    public void loadAllParking() {
        model.loadAllParking(this); //llamamos al model
    }

    @Override
    public void onLoadParkingSucess(List<Parking> parkings) {
        view.showParking(parkings);
    }

    @Override
    public void onLoadParkingError(String message) {
        view.showMessage(message);
    }
}
