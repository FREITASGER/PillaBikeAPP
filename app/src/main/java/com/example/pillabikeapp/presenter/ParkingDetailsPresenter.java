package com.example.pillabikeapp.presenter;

import com.example.pillabikeapp.contract.ParkingDetailsContract;
import com.example.pillabikeapp.domain.Parking;
import com.example.pillabikeapp.model.ParkingDetailsModel;
import com.example.pillabikeapp.model.ParkingListModel;
import com.example.pillabikeapp.view.ParkingDetailsView;

public class ParkingDetailsPresenter implements ParkingDetailsContract.Presenter, ParkingDetailsContract.Model.OnLoadParkingListener {

    /**
     * Le pasamos el model y la view ya que es el único que conoce a ambos
     */
    private ParkingDetailsModel model;
    private ParkingDetailsView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public ParkingDetailsPresenter(ParkingDetailsView view) {
        this.view = view; //le pasamos la vista desde el presenter al modelo
        this.model = new ParkingDetailsModel(view.getApplicationContext()); //le pasamos el contexto
    }

    /**
     * Método que llama al model para pedirle el parking
     */
    @Override
    public void loadDetailsParking(long parkingId) {
        model.loadDetailsParking(parkingId, this);
    }

    @Override
    public void onLoadParkingSucess(Parking parking) {
        view.showParking(parking);
    }

    @Override
    public void onLoadParkingError(String message) {
        view.showMessage(message);
    }
}
