package angelapps.com.tareacourseramascotas.POGO;

/**
 * Created by angel on 25/11/2016.
 */

public class mascota {

    private String nombre;
    private String cant;
    private int foto;

    public mascota(int foto, String nombre, String cant){
        this.nombre = nombre;
        this.cant = cant;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String  getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public  int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
