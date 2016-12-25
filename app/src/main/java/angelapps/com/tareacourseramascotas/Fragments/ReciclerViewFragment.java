package angelapps.com.tareacourseramascotas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.Adapter.mascotaAdaptador;
import angelapps.com.tareacourseramascotas.POGO.mascota;
import angelapps.com.tareacourseramascotas.R;

import static angelapps.com.tareacourseramascotas.Adapter.mascotaAdaptador.HOME;
import static angelapps.com.tareacourseramascotas.Adapter.mascotaAdaptador.PERFIL;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReciclerViewFragment extends Fragment {


    private int mDatasetTypes[] = {HOME, PERFIL};
    ArrayList<mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm =new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador(){
        mascotaAdaptador adaptador = new mascotaAdaptador (mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<mascota>();

        mascotas.add(new mascota(R.drawable.gato1, "Michael", "5"));
        mascotas.add(new mascota(R.drawable.gato_2, "Luz", "6"));
        mascotas.add(new mascota(R.drawable.gato_3, "Mimi", "4"));
        mascotas.add(new mascota(R.drawable.gato_4, "Gray", "7"));
        mascotas.add(new mascota(R.drawable.gato5, "Nau", "5"));
        mascotas.add(new mascota(R.drawable.gato6, "Yen", "8"));
        mascotas.add(new mascota(R.drawable.gato7, "Sady", "7"));
        mascotas.add(new mascota(R.drawable.gato8, "Angie", "4"));


    }

}
