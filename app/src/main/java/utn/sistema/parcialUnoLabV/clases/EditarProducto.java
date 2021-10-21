package utn.sistema.parcialUnoLabV.clases;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import utn.sistema.parcialUnoLabV.R;

public class EditarProducto extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);

        int indice = getIntent().getExtras().getInt("index");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Editar producto");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        // Se vuelve al menu principal desde ActionBar
        if(android.R.id.home == item.getItemId())
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        int indice = getIntent().getExtras().getInt("index");
        Log.d("INDEX", String.valueOf(indice));
        Producto producto = Controlador.getInstance().getProducto(indice);
        Log.d("USUARIO", producto.toString());
        Vista vista = new Vista(producto,this);
        Controlador.getInstance().setIndice(indice);
        Controlador.getInstance().setProducto(producto);
        Controlador.getInstance().setActivity(this);
        Controlador.getInstance().setVista(vista);

        vista.setControlador(Controlador.getInstance());
    }
}
