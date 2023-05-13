package com.example.pillabikeapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.pillabikeapp.R;
import com.example.pillabikeapp.adapter.ParkingAdapter;
import com.example.pillabikeapp.contract.ParkingDetailsContract;
import com.example.pillabikeapp.domain.Parking;
import com.example.pillabikeapp.presenter.ParkingDetailsPresenter;
import com.example.pillabikeapp.presenter.ParkingListPresenter;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ParkingDetailsView extends AppCompatActivity implements ParkingDetailsContract.View {

    private Parking parking; //Creamos el parking que recibimos
    private ParkingDetailsPresenter presenter; //Declaramos el adapter
    private long parkingId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details_view);

        presenter = new ParkingDetailsPresenter(this);
        Intent intent = getIntent();
        parkingId = getIntent().getLongExtra("parkingId", 0); //guardamos el id que nos traemos de la vista detalle

        presenter.loadDetailsParking(parkingId);
    }

    @Override
    public void showParking(Parking parking) {
        TextView etParkingName = findViewById(R.id.tv_parking_name_details);
        TextView etParkingCity = findViewById(R.id.tv_parking_city_details);
        TextView etParkingOpen = findViewById(R.id.tv_parking_open_details);
        TextView etParkingClose = findViewById(R.id.tv_parking_close_details);
        CheckBox cbFull = (CheckBox) findViewById(R.id.cb_parking_full_details);

        etParkingName.setText(parking.getName());
        etParkingCity.setText(parking.getCity());
        etParkingOpen.setText(parking.getOpen());
        etParkingClose.setText(parking.getClose());
        cbFull.setChecked(parking.isFull());
    }

    @Override
    public void showMessage(String message) {

    }
}