package com.example.pillabikeapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pillabikeapp.R;
import com.example.pillabikeapp.adapter.ParkingAdapter;
import com.example.pillabikeapp.contract.ParkingListContract;
import com.example.pillabikeapp.domain.Parking;
import com.example.pillabikeapp.presenter.ParkingListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Extiende de AppCompatActivity: donde hay un motón de código para usar por esos sobreescribimos los métodos de esta clase
 * Implementa el ParkingListContract.View con sus métodos declarados en el contract
 */
public class ParkingListView extends AppCompatActivity implements ParkingListContract.View {

    private List<Parking> parkingList; //Creamos la lista que recibiremos
    private ParkingListPresenter presenter; //Declaramos el adapter
    private ParkingAdapter adapter; //declaramos el presenter para solicitar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_list_view);

        presenter = new ParkingListPresenter(this); //instanciamos el presenter

        initializeRecyclerView();
    }

    /**
     * Método para inicializar el RecyclerView
     */
    private void initializeRecyclerView() {
        parkingList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rc_parking_all);// recreamos un onjeto RecyclerView y le pasamos el id
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ParkingAdapter(this, parkingList); //se lo pasamos al adapter para que pinte los datos de cada equipo de la lista en el item
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("parking", "Llamada desde view"); //depurar para ver hasta donde llego
        presenter.loadAllParking(); //le decimos al presenter cuando vuelve del resume que carge xtodo
    }

    @Override
    public void showParking(List<Parking> parkings) {
        parkingList.clear(); //limpiamos la lista por si tuviera datos de antes
        parkingList.addAll(parkings); //añadimos la lista que recibimos a la lista que teniamos
        adapter.notifyDataSetChanged();//notificamos al adapter de los cambios
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /**
     * PAra crear el menu (el actionBar)
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu); //Inflamos el menu
        return true;
    }

    /**
     * Para cuando elegimos una opcion del menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.go_home) { //Evaluar a que opcion hemos pichado
            Intent intent = new Intent(this, MainActivity.class); //donde nos manda al pinchar sobre el boton + en el action bar
            startActivity(intent);
            return true;
        }
        return false;
    }
}