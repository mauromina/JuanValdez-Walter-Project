package com.example.cia.juanvaldez;

import android.content.Intent;
import android.support.v7.widget.ShareActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import java.util.List;

public class ActividadPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);


        Toolbar bar= findViewById(R.id.barraTitle);
        setSupportActionBar(bar);

        AdapterView.OnItemClickListener escuchaListaPrincipal=new AdapterView.OnItemClickListener() {//escuchar los item de la lista
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){

                    Intent intent =new Intent(ActividadPrincipal.this, BebidaCaliente.class);
                    startActivity( intent);
                }
                else if(i==1){
                    Toast mensaje= Toast.makeText(getApplicationContext(),"Servicio de comida  no disponible",Toast.LENGTH_LONG);
                    mensaje.show();
                }
                else{
                    Toast mensaje= Toast.makeText(getApplicationContext(),"La Tienda Online sin Servicio",Toast.LENGTH_LONG);
                    mensaje.show();
                }
            }
        };
        ListView listaPrincipal=(ListView) findViewById(R.id.listView);//enlazar la lista principal al escucha
        listaPrincipal.setOnItemClickListener(escuchaListaPrincipal);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.actionCreateOrder:
                Intent intent = new Intent(this,Pedidos.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInfla=getMenuInflater();
        menuInfla.inflate(R.menu.menu_main,menu);
       return super.onCreateOptionsMenu(menu);
    }
    }



