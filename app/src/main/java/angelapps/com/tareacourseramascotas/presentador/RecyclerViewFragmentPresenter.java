package angelapps.com.tareacourseramascotas.presentador;

import android.content.Context;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.DB.ConstructorMascotas;
import angelapps.com.tareacourseramascotas.Fragments.IRecyclerViewFragmentView;
import angelapps.com.tareacourseramascotas.POGO.mascota;

/**
 * Created by angel on 1/2/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<mascota> mascotas;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerMascotasBaseDatos();
    }
    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }


    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }


}
