package angelapps.com.tareacourseramascotas.menus;

import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import angelapps.com.tareacourseramascotas.R;

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText textoNombre;
    TextInputEditText textoEmail;
    TextInputEditText textoMensaje;
     private Toolbar toolbar;
    Button enviar;
    Session session;

    String nombre, email, mensaje, correo, contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        toolbar = (Toolbar) findViewById(R.id.toolbar23);

        textoNombre =   (TextInputEditText) findViewById(R.id.textoNombre);
        textoEmail =    (TextInputEditText) findViewById(R.id.text_email);
        textoMensaje =  (TextInputEditText) findViewById(R.id.textoMensaje);
        enviar=         (Button)            findViewById(R.id.botonEnviar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        correo="pruebaenvioangellarreal@gmail.com";
        contraseña="a123456789l";


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try {
                    session=Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }
                    });

                    if(session!=null){
                        Message message= new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Contacto Petagram");
                        //Estructura del mensaje
                        //Si quieres comprobar que te llegue el msj cambia el correo justo aca debajo!!
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("angellarreal95@gmail.com"));
                        message.setContent("Buenas, mi nombre es: " + textoNombre.getText().toString() + " ,mi correo electronico es: "
                        + textoEmail.getText().toString() + " y le escribo este correo con la siguiente razón: " +
                        textoMensaje.getText().toString(), "text/html; charset=utf-8");
                        Transport.send(message);
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje_enviado), Toast.LENGTH_LONG).show();

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
