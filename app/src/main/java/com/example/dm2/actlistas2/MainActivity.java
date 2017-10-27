package com.example.dm2.actlistas2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Webpage[] datos =
            new Webpage[]{
                    new Webpage("Twitch", "https://go.twitch.tv/",R.drawable.ic_twitch,"Pagina de retransmisiones en directo de videojuegos"),
                    new Webpage("Twitter", "https://twitter.com/",R.drawable.ic_twitter,"Red social centrada en mensajes cortos y abundantes"),
                    new Webpage("Youtube", "https://www.youtube.com/?hl=es",R.drawable.ic_youtube,"Pagina de visualización de videos varios")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptadorWebpages adaptador = new AdaptadorWebpages(this, datos);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones2);
        lstOpciones.setAdapter(adaptador);
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent (Intent.ACTION_VIEW,
                        Uri.parse(datos[position].getLink()));
                startActivity(intent);

            }
        });
    }

    class AdaptadorWebpages extends ArrayAdapter<Webpage> {
        public AdaptadorWebpages(Context context, Webpage[] datos) {
            super(context, R.layout.listitem_webpage, datos);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_webpage, null);

            TextView lblNombre = (TextView)item.findViewById(R.id.lblnombre);
            lblNombre.setText(datos[position].getNombre());

            TextView lblLink = (TextView)item.findViewById(R.id.lbllink);
            lblLink.setText(datos[position].getLink());

            ImageView imgPag = (ImageView)item.findViewById(R.id.imgpag);
            imgPag.setImageResource(datos[position].getImagen());

            TextView lblDescripcion = (TextView)item.findViewById(R.id.lbldesc);
            lblDescripcion.setText(datos[position].getDescripcion());
            return(item);
        }
    }
}
