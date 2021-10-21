package utn.sistema.parcialUnoLabV.clases;

import static android.os.Build.VERSION_CODES.R;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Vista
{
    private Producto usuario;
    Activity activity;
    Controlador controlador;
    EditText edNombre;
    EditText edCantidad;
    EditText edPrecio;

    public Vista(Producto usuario, Activity activity)
    {
        this.usuario = usuario;
        this.activity = activity;
    }

    public void cargarModelo()
    {
        
        this.usuario.setNombre(this.edNombre.getText().toString());
        this.usuario.setCantidad(Integer.valueOf(this.edCantidad.getText().toString()));
        this.usuario.setPrecio(Double.valueOf(this.edPrecio.getText().toString()));
        Log.d("Detalle Producto", this.usuario.toString());

    }

    public void cargarElementos()
    {
        this.edNombre = this.activity.findViewById(R.id.);
        this.edCantidad = this.activity.findViewById(R.id.edCantidad);
        this.edPrecio = this.activity.findViewById(R.id.edPrecio);
        Button btn = activity.findViewById(R.id.btnGuardar);
        btn.setOnClickListener(this.controlador);
    }

    public void mostrarModelo()
    {
        this.edNombre.setText(this.usuario.getNombre());
        this.edCantidad.setText(String.valueOf(this.usuario.getCantidad()));
        this.edCantidad.setText(String.valueOf(this.usuario.getPrecio()));
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
