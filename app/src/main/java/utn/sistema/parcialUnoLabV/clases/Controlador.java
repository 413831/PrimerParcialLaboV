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
    private ServicioProductos servicioProductos;
    private int indice;

    private Controlador(Handler handler)
    {
        this.productos = this.mockProductos();
        this.servicioProductos = new ServicioProductos(handler);
    }

    public static Controlador getInstance(Handler handler)
    {
        if(Controlador.controlador == null)
        {
            Controlador.controlador = new Controlador(handler);
        }
        return Controlador.controlador;
    }

    @Override
    public void onClick(View v)
    {
        if(Controlador.controlador.validarDatos())
        {
            Controlador.controlador.vista.cargarModelo();
            Controlador.controlador.productos.set(Controlador.controlador.indice,Controlador.controlador.producto);

            Log.d("Producto actualizado", Controlador.controlador.productos.get(Controlador.controlador.indice).toString());

            // Termino la actividad
            Controlador.controlador.activity.finish();
        }
    }

    private boolean validarDatos()
    {
        String mensaje = "";
        String pass = Controlador.controlador.vista.edContrasenia.getText().toString();
        String confirmacion = Controlador.controlador.vista.edConfirmacion.getText().toString();

        if(pass.equals(confirmacion) && Controlador.controlador.vista.edNombre.getText().length() >= 3)
        {
            return true;
        }
        else
        {
            if(Locale.getDefault().getLanguage() == new Locale("en").getLanguage())
            {
                mensaje = "Please check your password, enter an user name with least 3 characters";
            }
            else if(Locale.getDefault().getLanguage() == new Locale("es").getLanguage())
            {
                mensaje = "Por favor revise su contraseña, ingrese un nombre con al menos 3 caracteres";
            }
            Controlador.controlador.vista.mostrarMensaje(mensaje);
            return false;
        }
    }

    private List<Producto> mockProductos()
    {
        /*
        List<Producto> mockProductos = new ArrayList<>();

        mockProductos.add(new Producto("Pepito","SARASA", TipoProducto.USUARIO));
        mockProductos.add(new Producto("Manuela","SARASA", TipoProducto.USUARIO));
        mockProductos.add(new Producto("Jose","MELON1235", TipoProducto.ADMINISTRADOR));
        mockProductos.add(new Producto("Josefina","OBELISCO99", TipoProducto.USUARIO));
        mockProductos.add(new Producto("Francisco","MosTaZa12", TipoProducto.ADMINISTRADOR));
        mockProductos.add(new Producto("Hermeneguildo","FONTANARROSA", TipoProducto.USUARIO));
        mockProductos.add(new Producto("Mustafa","LOSNUEVELADRONES", TipoProducto.ADMINISTRADOR));
        mockProductos.add(new Producto("Beatriz","LAZARO1235", TipoProducto.USUARIO));
        mockProductos.add(new Producto("Mirtha","HIGHLANDER99", TipoProducto.USUARIO));

        return mockProductos;

         */
        return null;
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

    public void setProductos(List<Producto> productos) {
        Controlador.controlador.productos = productos;
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
