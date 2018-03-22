package com.example.cia.juanvaldez;

public class Bebidas {
    private String nombre,descripcion;
    private int imagenId;

    public static  final Bebidas[] bebidas ={new Bebidas("Latte", "Deliciosa bebida de leche  caliente",R.drawable.late ),
                                                                   new Bebidas("Capuchino", "Expreso de grano recien molido",R.drawable.capuccino ),
                                                                   new Bebidas("Filtrado", "Para los mas arriesgados un filtrado molido",R.drawable.filtrado )                                                            };

    public Bebidas(String nombre, String descripcion,int  imagenId){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.imagenId=imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public String toString(){
        return  nombre;
    }

}//fin class
