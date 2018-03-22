package com.example.cia.juanvaldez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LateProducto extends AppCompatActivity {
    public static  String EXTRA_BEBIDA="bebida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_late_producto);

        int id=(int) getIntent().getExtras().get(EXTRA_BEBIDA);
        Bebidas bebida=Bebidas.bebidas[id];

        TextView nombre=findViewById(R.id.textNombre);
        nombre.setText(bebida.getNombre());

        ImageView imagen=findViewById(R.id.imageBebida);
        imagen.setImageResource(bebida.getImagenId());

        TextView descripcion=findViewById(R.id.textDecripcion);
        descripcion.setText(bebida.getDescripcion());
    }
}
