package net.kariis.aplicacioncontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int codigo = 1;
    ListView lista;
    List<Contacto> kari = new ArrayList<Contacto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(),Actividad2.class);
                startActivityForResult(j,codigo);
            }
        });
    }

    @Override
    public void onActivityResult(int requestcode,int resultcode,Intent data){
        if (requestcode==codigo && resultcode==RESULT_OK)
        {
            Bundle b = data.getExtras();
            Contacto cont = b.getParcelable("dato");
            kari.add(cont);
            Adaptador adp = new Adaptador(getApplicationContext(),(ArrayList)kari);
            lista.setAdapter(adp);
        }
    }
}
