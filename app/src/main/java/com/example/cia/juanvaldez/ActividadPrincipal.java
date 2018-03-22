package com.example.cia.juanvaldez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import java.util.List;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        AdapterView.OnItemClickListener escuchaListaPrincipal=new AdapterView.OnItemClickListener() {//escuchar los item de la lista
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Intent intent =new Intent(ActividadPrincipal.this, BebidaCaliente.class);
                    startActivity( intent);
                }
            }
        };
        ListView listaPrincipal=(ListView) findViewById(R.id.listView);//enlazar la lista principal al escucha
        listaPrincipal.setOnItemClickListener(escuchaListaPrincipal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
