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

    public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.ViewHolder> {

        private static final String TAG= "mascotaAdaptador";
        ArrayList<mascota> mascotas;
        private int tipoCardView;
        Activity activity;
        int contador;

        public static final int HOME = 0;
        public static final int PERFIL = 1;

        int c =0;
        boolean alfa=false;

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View v){
                super(v);
            }
        }

        public mascotaAdaptador(ArrayList<mascota> mascotas, Activity activity){
            this.mascotas = mascotas;
            this.activity = activity;
        }

        //inflar el layout y lo pasara al viewholder para que el obtenga los views
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View v;

                v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascota, viewGroup, false);
                return new mascotaViewHolder(v);

        }



        //Asocia los elementos a cada view
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
                final mascotaViewHolder holder = (mascotaViewHolder) viewHolder;
                final mascota mascota = mascotas.get(position);
                holder.foto.setImageResource(mascota.getFoto());
                holder.tvNombre.setText(mascota.getNombre());
                holder.tvCuenta.setText(mascota.getCant());


            holder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int contador = (int) Integer.valueOf(mascota.getCant());
                    if (contador!=9999) {
                        contador++;
                        mascota.setCant(Integer.toString(contador));
                        holder.tvCuenta.setText("" + contador);
                    }
                }
            });


        }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public static class mascotaViewHolder extends  ViewHolder{

        private ImageView foto;
        private TextView tvNombre;
        private TextView tvCuenta;
        private ImageButton btnLike;


        public mascotaViewHolder(View itemView) {
            super(itemView);
            foto        = (ImageView)   itemView.findViewById(R.id.imgGato);
            tvNombre    = (TextView)    itemView.findViewById(R.id.tvNombre);
            tvCuenta    = (TextView)    itemView.findViewById(R.id.tvnum);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }


}


