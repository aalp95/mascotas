package angelapps.com.tareacourseramascotas.Adapter;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.*;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.POGO.mascota;
import angelapps.com.tareacourseramascotas.R;

/**
 * Created by angel on 25/11/2016.
 */

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.ViewHolder> {

    private static final String TAG= "mascotaAdaptador";
    ArrayList<mascota> mascotas;
    private int [] mDataSetTypes;
    private int tipoCardView;
    Activity activity;

    public static final int HOME = 0;
    public static final int PERFIL = 1;

    int c =0;
    boolean alfa=false;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
    }

    public PerfilAdapter(ArrayList<mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    //inflar el layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;

            v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_perfil, viewGroup, false);
            return new PerfilViewHolder(v);

    }



    //Asocia los elementos a cada view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
            PerfilViewHolder holder2 = (PerfilViewHolder) viewHolder;
            final mascota mascota = mascotas.get(position);
            holder2.fotoPerfil.setImageResource(mascota.getFoto());
            holder2.tvCant.setText(mascota.getCant());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public class PerfilViewHolder extends ViewHolder{

        private ImageView fotoPerfil;
        private TextView tvCant;

        public PerfilViewHolder(View itemView) {

            super(itemView);
            fotoPerfil  = (ImageView)   itemView.findViewById(R.id.IVperfilgato);
            tvCant      = (TextView)    itemView.findViewById(R.id.tvCard);

        }
    }

}

