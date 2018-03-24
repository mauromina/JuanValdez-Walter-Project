package com.example.cia.juanvaldez;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import  android.support.v7.widget.ShareActionProvider;
import android.widget.Toast;

public class Pedidos extends AppCompatActivity {
    private ShareActionProvider myShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        Toolbar bar = findViewById(R.id.barraTitle);
        setSupportActionBar(bar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
/*Captura la accion del boton y el indice de producto seleccionado*/
        AdapterView.OnItemClickListener escuchaPedido = new AdapterView.OnItemClickListener() {//escuchar los item de la lista
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast mensaje1;
                Toast mensaje2;
                Toast mensaje3;
                if (i == 0) {
                    mensaje1=Toast.makeText(getApplicationContext(),"Compraste un café Late",Toast.LENGTH_LONG);
                    mensaje1.show();
                   String mensaje="¿Quieres un Café Late?";
                    invitacionComprarProducto(mensaje);
                }
                else if(i==1){
                    mensaje2=Toast.makeText(getApplicationContext(),"Compraste un café Filtrado",Toast.LENGTH_LONG);
                    mensaje2.show();
                    String mensaje="¿Quieres un Café Filtrado?";
                    invitacionComprarProducto(mensaje);
                }
                else{
                    mensaje3=Toast.makeText(getApplicationContext(),"Compraste un café con Leche",Toast.LENGTH_LONG);
                    mensaje3.show();
                    String mensaje="¿Quieres un Café con Leche";
                    invitacionComprarProducto(mensaje);
                }
            }
        };

        ListView listaPrincipal = (ListView) findViewById(R.id.listaPedido);//enlazar la lista principal al escucha
        listaPrincipal.setOnItemClickListener(escuchaPedido);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInfla = getMenuInflater();
        menuInfla.inflate(R.menu.menu_secundario, menu);

        MenuItem shareItem = menu.findItem(R.id.action_share);
        myShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        myShareActionProvider.setShareIntent(mensajeBienvenida());
        return super.onCreateOptionsMenu(menu);
    }

    private Intent mensajeBienvenida() {
        Intent shareInten = new Intent(Intent.ACTION_SEND);
        shareInten.setType("text/plain");
        String mensaje = " Bienvenido a Juan Valdez Café";
        shareInten.putExtra(Intent.EXTRA_TEXT, mensaje);
        return shareInten;
    }
/*Genera un invitacion basada en el tipo de producto que se desea comprar
 para ser compartido mediante el boton SHARE*/
    private void invitacionComprarProducto(String mensaje) {
        if (myShareActionProvider != null ) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plaint");
            shareIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
            myShareActionProvider.setShareIntent(shareIntent);
        }
    }
}
