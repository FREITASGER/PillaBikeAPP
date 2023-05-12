package com.example.pillabikeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pillabikeapp.R;
import com.example.pillabikeapp.domain.Parking;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * ParkingAdapter: Es la clase en la que le explicamos a Android como pintar cada elemento en el RecyclerView
 * Patron Holder: 1) Constructor - 2) onCreateViewHolder - 3) onBindViewHolder - 4) getItemCount - 5) Y la estructura SuperheroHolder
 * al extender de la clase RecyclerView los @Override los añadira automáticamente para el patron Holder, solo añadiremos nosotros el 5)
 *
 */
public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ParkingHolder> {

    private Context context; // Activity en la que estamos
    private List<Parking> parkingList;
//    private ParkingDeletePresenter presenter;
    private View snackBarView;

    /**
     * 1) Constructor que creamos para pasarle los datos que queremos que pinte
     * el contexto y la lista de equipos
     */
    public ParkingAdapter(Context context, List<Parking> parkingList) {
        this.context = context;
        this.parkingList = parkingList;
//        presenter = new ParkingDeletePresenter(this);
    }

    public Context getContext() {
        return context;
    }

    /**
     * Metodo con el que Android va a inflar, va a crear cada estructura del layout donde irán los datos de cada equipo.
     * Vista detalle de cada equipo
     */
    @Override
    public ParkingAdapter.ParkingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parking_item, parent, false); // el layout parking_item para cada parking
        return new ParkingHolder(view); //Creamos un holder para cada una de las estructuras que infla el layout
    }

    /**
     * Metodo que estamos obligados para hacer corresponder los valores de la lista y pintarlo en cada elemento de layout
     * es para poder recorrer en el bucle por cada elemento de la lista y poder pintarlo
     */
    @Override
    public void onBindViewHolder(@NonNull ParkingAdapter.ParkingHolder holder, int position) {
//        holder.id.setText(parkingList.get(position).getId());
        holder.name.setText(parkingList.get(position).getName());
        holder.city.setText(parkingList.get(position).getCity());
        holder.open.setText(parkingList.get(position).getOpen().format(DateTimeFormatter.ofPattern("hh:mm")));
        holder.close.setText(parkingList.get(position).getClose().format(DateTimeFormatter.ofPattern("hh:mm")));
        holder.isFull.setChecked(parkingList.get(position).isFull());
//        LocalTime localTime = LocalTime.now();
//        String strLocalTime = localTime.format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    /**
     * Metodo que estamos obligados a hacer para que devuelva el número de elementos y android pueda hacer sus calculos y pintar xtodo en base a esos calculos
     */
    @Override
    public int getItemCount() {
        return parkingList.size(); //tamaño de la lista
    }

    /**
     * 5) Holder son las estructuras que contienen los datos y los rellenan luego
     * Creamos todos los componentes que tenemos
     */
    public class ParkingHolder extends RecyclerView.ViewHolder {
        //        public TextView parkingId;
        public TextView name;
        public TextView city;
        public TextView open;
        public TextView close;
        public CheckBox isFull;

        //        public Button modifyUserButton;
        public Button deleteParkingButton;
        public Button detailsParkingButton;
        public Button addBikeParkingButton; //Para crear un equipo asociado a un usuario

        public View parentView; //vista padre - como el recyclerView

        /**
         * 5) Consturctor del Holder
         */
        public ParkingHolder(View view) {
            super(view); //Vista padre
            parentView = view; //Guardamos el componente padre

//            userId = view.findViewById(R.id.user_id);
            name = view.findViewById(R.id.tv_parking_name_item);
            city = view.findViewById(R.id.tv_parking_city_item);
            open = view.findViewById(R.id.tv_parking_open_item);
            close = view.findViewById(R.id.tv_parking_close_item);
            isFull = view.findViewById(R.id.tv_parking_full_item);

            detailsParkingButton = view.findViewById(R.id.details_parking_button);
//            modifyUserButton = view.findViewById(R.id.modify_user_button); //De momento en está vista no voy a modificar
            deleteParkingButton = view.findViewById(R.id.delete_parking_button);
            addBikeParkingButton = view.findViewById(R.id.bikeAdd_parking_button);

            //TODO añadir opción que realizarán los botones
//            //Para decirle que hace el boton cuando pulsamos sobre el
//            // Ver detalles de un puente
//            detailsBrigdeButton.setOnClickListener(v -> detailsBrigdeButton(getAdapterPosition())); //al pulsar lo llevamos al método detailsBrigdeButton
//             Modificar un usuario
            detailsParkingButton.setOnClickListener(v -> detailsParking(getAdapterPosition()));
            // Eliminar un usuario
            deleteParkingButton.setOnClickListener(v -> deleteParking(getAdapterPosition()));
            //Añadir Equipo a entrenador
            addBikeParkingButton.setOnClickListener(v -> parkingAddBike(getAdapterPosition()));
        }

        /**
         * Método para ver los detalle de un parking
         */
        private void detailsParking(int position) {
//            Parking parking = parkingList.get(position);
//
//            Intent intent = new Intent(context, BikeRegisterView.class);
//            intent.putExtra("userId", parking.getId());
//            intent.putExtra("name", parking.getName());
//            context.startActivity(intent);
        }
    }


        /**
         * Métodos de los botones del layout para recoger el id y registrar una inspection
         * TODO para añadir bike a parking
         */
        private void parkingAddBike(int position) {
//            Parking parking = parkingList.get(position);
//
//            Intent intent = new Intent(context, BikeRegisterView.class);
//            intent.putExtra("userId", parking.getId());
//            intent.putExtra("name", parking.getName());
//            context.startActivity(intent);
//        }
    }

    /**
     * Métodos de los botones del layout para recoger el id y registrar una inspection
     * TODO para
     */
    private void modifyParking(int position) {
//        Parking parking = parkingList.get(position);
//
//        Intent intent = new Intent(context, ParkingModifyView.class);
//        intent.putExtra("parking", parking); //Mandamos el objeto entero ya que es una clase serializable
//        context.startActivity(intent);
    }

    private void deleteParking(int position) {
//        Parking parking = parkingList.get(position);
//
//        Log.d("Parking Delete", "Sinde Delete PArking:" + parking.getId());
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setMessage(R.string.are_you_sure)
//                .setTitle(R.string.remove_parking)
//                .setPositiveButton(R.string.yes, (dialog, id) -> {
////                    Parking parking = parkingList.get(position);
//                    presenter.deleteParking(parking.getId());
//
//                    parkingList.remove(position);
//                    notifyItemRemoved(position);
//                })
//                .setNegativeButton(R.string.not, (dialog, id) -> dialog.dismiss());
//        AlertDialog dialog = builder.create();
//        dialog.show();
    }
}
