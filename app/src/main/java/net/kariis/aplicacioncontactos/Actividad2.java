package net.kariis.aplicacioncontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Date;


public class Actividad2 extends AppCompatActivity {

    EditText usuario,email,twitter,telefono,fecha;
    Button btn;
    Contacto conta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);


        usuario = (EditText)findViewById(R.id.txtUsuario);
        email = (EditText)findViewById(R.id.txtEmail);
        twitter = (EditText)findViewById(R.id.txtTwitter);
        telefono = (EditText)findViewById(R.id.txtTelefono);
        fecha = (EditText)findViewById(R.id.txtFechaNacimiento);
        btn = (Button)findViewById(R.id.btnAgregar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("dd-mm-yyyy");
                try {
                    Date d=f.parse(fecha.getText().toString());
                    conta = new Contacto(usuario.getText().toString(),email.getText().toString(),twitter.getText().toString(),telefono.getText().toString(),d);
                }catch (Exception ex){

                }
                Intent da = new Intent();
                da.putExtra("dato",conta);
                setResult(RESULT_OK,da);
                finish();
            }
        });

    }
}
