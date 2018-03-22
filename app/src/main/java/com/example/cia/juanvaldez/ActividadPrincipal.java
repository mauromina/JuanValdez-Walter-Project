package com.example.cia.juanvaldez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.MenuItemCompat;

import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;

import java.util.List;

public class ActividadPrincipal extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;

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
        // Localizo el boton de Share en la bara de acion
        MenuItem item = menu.findItem(R.id.menu_item_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider =  (ShareActionProvider) MenuItemCompat.getActionProvider(item);;

        return super.onCreateOptionsMenu(menu);
    }

    //Codigo para el boton de compartir

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {
            case R.id.mShareActionProvider:
                Intent i = new Intent(
                        android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(
                        android.content.Intent.EXTRA_TEXT, "Su pedido esta listo");
                startActivity(Intent.createChooser(i, "Share Via"));
                break;
        }

        Toast.makeText(getApplicationContext(), "You click on menu share", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }

}

}
