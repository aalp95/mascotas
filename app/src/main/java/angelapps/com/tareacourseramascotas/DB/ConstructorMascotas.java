package angelapps.com.tareacourseramascotas.DB;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.POGO.mascota;
import angelapps.com.tareacourseramascotas.R;

/**
 * Created by angel on 1/2/2017.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context){this.context=context;}



    public ArrayList<mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodosLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        if(!db.verificarTabla()){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Michael");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Luz");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato_2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "MiMi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato_3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Grey");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato_4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Nau");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Yin");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato6);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Sady");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato7);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Angie");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato8);
        db.insertarMascota(contentValues);

        /*
        mascotas.add(new mascota(R.drawable.gato1, "Michael", "5"));
        mascotas.add(new mascota(R.drawable.gato_2, "Luz", "6"));
        mascotas.add(new mascota(R.drawable.gato_3, "Mimi", "4"));
        mascotas.add(new mascota(R.drawable.gato_4, "Gray", "7"));
        mascotas.add(new mascota(R.drawable.gato5, "Nau", "5"));
        mascotas.add(new mascota(R.drawable.gato6, "Yen", "8"));
        mascotas.add(new mascota(R.drawable.gato7, "Sady", "7"));
        mascotas.add(new mascota(R.drawable.gato8, "Angie", "4"));

*/
    }

    }

    public void darLikeMascota(mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMER_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikeMascota (mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
