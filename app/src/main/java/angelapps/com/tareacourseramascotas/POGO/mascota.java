package angelapps.com.tareacourseramascotas.POGO;

/**
 * Created by angel on 25/11/2016.
 */

public class mascota {

    private String nombre;
    private String cant;
    private int foto;
    private int likes;
    private int id;

    public mascota(int foto, String nombre, int likes){
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public mascota(){

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


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(mascota m){
        if (likes < m.likes){
            return -1;
        }
        if (likes > m.likes){
            return 1;
        }
        return 0;
    }
}
