package net.kariis.aplicacioncontactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karii on 08/09/2017.
 */

public class Adaptador extends ArrayAdapter {

    private Context context;
    private List<Contacto> datos;

    public Adaptador(Context context, ArrayList datos)
    {
        super(context, R.layout.datos, datos);
        this.context = context;
        this.datos = datos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.datos, null);
        TextView nombre = (TextView) item.findViewById(R.id.textView);
        nombre.setText(datos.get(position).getUsuario().toString());

        TextView email = (TextView) item.findViewById(R.id.textView2);
        email.setText(datos.get(position).getEmail().toString());

        return item;
    }

}
