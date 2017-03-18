package angelapps.com.tareacourseramascotas.pantallas;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.Adapter.mascotaAdaptador;
import angelapps.com.tareacourseramascotas.POGO.mascota;
import angelapps.com.tareacourseramascotas.R;
import angelapps.com.tareacourseramascotas.presentador.FavInterfacePresenter;
import angelapps.com.tareacourseramascotas.presentador.IFavInterfacePresenter;
import angelapps.com.tareacourseramascotas.presentador.IRecyclerViewFragmentPresenter;
import angelapps.com.tareacourseramascotas.presentador.RecyclerViewFragmentPresenter;


public class Favs extends AppCompatActivity implements IFavs {


    ArrayList<mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar2;
    private IFavInterfacePresenter presenter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favs);
        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);

        presenter = new FavInterfacePresenter(this, getBaseContext());

        setSupportActionBar(toolbar2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public mascotaAdaptador crearAdaptador(ArrayList<mascota> mascotas) {
        mascotaAdaptador adaptador = new mascotaAdaptador (mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(mascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
