package utn.sistema.parcialUnoLabV.clases;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import utn.sistema.parcialUnoLabV.services.ServicioProductos;

public class Controlador implements View.OnClickListener
{
    private Producto producto;
    private Vista vista;
    private Activity activity;
    private List<Producto> productos;
    private static Controlador controlador;
    private int indice;

    private Controlador()
    {

    }

    public static Controlador getInstance()
    {
        if(Controlador.controlador == null)
        {
            Controlador.controlador = new Controlador();
        }
        return Controlador.controlador;
    }

    @Override
    public void onClick(View v)
    {
        Controlador.controlador.vista.cargarModelo();
        Controlador.controlador.productos.set(Controlador.controlador.indice,Controlador.controlador.producto);

        Log.d("Producto actualizado", Controlador.controlador.productos.get(Controlador.controlador.indice).toString());

        // Termino la actividad
        Controlador.controlador.activity.finish();
    }

    public Producto getProducto(int indice) {
        return Controlador.controlador.productos.get(indice);
    }

    public void setProducto(Producto producto) {
        Controlador.controlador.producto = producto;
    }

    public List<Producto> getProductos() {
        return Controlador.controlador.productos;
    }

    public static void setProductos(List<Producto> productos)
    {
        Controlador.getInstance().productos = productos;
    }

    public void setVista(Vista vista) {
        Controlador.controlador.vista = vista;
    }

    public void setActivity(Activity activity) {
        Controlador.controlador.activity = activity;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
