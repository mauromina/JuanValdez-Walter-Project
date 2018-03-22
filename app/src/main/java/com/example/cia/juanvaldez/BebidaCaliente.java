package com.example.cia.juanvaldez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BebidaCaliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida_caliente);

        //llamar a la lista de bebidas  de la clase Bebidas:
        ArrayAdapter <Bebidas>  bebidasAdapter=new ArrayAdapter<Bebidas>(this, android.R.layout.simple_expandable_list_item_1,Bebidas.bebidas);

        //enlazando con listView:
        ListView lista= (ListView)findViewById(R.id.listaBebidaCaliente);
        lista.setAdapter( bebidasAdapter);

        AdapterView.OnItemClickListener  escuchaListaBebidasCalientes=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(BebidaCaliente.this,LateProducto.class );
                intent.putExtra(LateProducto.EXTRA_BEBIDA,(int) l);
                startActivity(intent);

            }
        };

        ListView listaBebidasCalientes= (ListView)findViewById(R.id.listaBebidaCaliente);
        listaBebidasCalientes.setOnItemClickListener(escuchaListaBebidasCalientes);
    }

}
