package utn.sistema.parcialUnoLabV.clases;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utn.sistema.parcialUnoLabV.R;

public class Vista
{
    private Producto producto;
    Activity activity;
    Controlador controlador;
    EditText edNombre;
    EditText edCantidad;
    EditText edPrecio;

    public Vista(Producto producto, Activity activity)
    {
        this.producto = producto;
        this.activity = activity;
    }

    public void cargarModelo()
    {
        
        this.producto.setNombre(this.edNombre.getText().toString());
        this.producto.setCantidad(Integer.valueOf(this.edCantidad.getText().toString()));
        this.producto.setPrecio(Double.valueOf(this.edPrecio.getText().toString()));
        Log.d("Detalle Producto", this.producto.toString());

    }

    public void cargarElementos()
    {
        this.edNombre = this.activity.findViewById(R.id.edNombre);
        this.edCantidad = this.activity.findViewById(R.id.edCantidad);
        this.edPrecio = this.activity.findViewById(R.id.edPrecio);
        Button btn = activity.findViewById(R.id.btnGuardar);
        btn.setOnClickListener(this.controlador);
    }

    public void mostrarModelo()
    {
        this.edNombre.setText(this.producto.getNombre());
        this.edCantidad.setText(String.valueOf(this.producto.getCantidad()));
        this.edPrecio.setText(String.valueOf(this.producto.getPrecio()));
    }

    public void mostrarMensaje(String mensaje)
    {
        Toast.makeText(this.activity,mensaje, Toast.LENGTH_SHORT).show();
    }

    public void setControlador(Controlador controlador)
    {
        this.controlador = controlador;
        this.cargarElementos();
        this.mostrarModelo();
    }
}
