package utn.sistema.parcialUnoLabV;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import utn.sistema.parcialUnoLabV.R;
import utn.sistema.parcialUnoLabV.clases.Controlador;
import utn.sistema.parcialUnoLabV.clases.Producto;
import utn.sistema.parcialUnoLabV.clases.Vista;

public class EditarProducto extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);

        int indice = getIntent().getExtras().getInt("index");
        String tituloActionBar = "";
        ActionBar actionBar = getSupportActionBar();

        if(Locale.getDefault().getLanguage() == new Locale("es").getLanguage())
        {
            tituloActionBar = "Modificar";
        }
        else
        {
            tituloActionBar = "Modify";
        }

        actionBar.setTitle(tituloActionBar);
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
