package utn.sistema.parcialUnoLabV;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import utn.sistema.parcialUnoLabV.clases.Controlador;
import utn.sistema.parcialUnoLabV.clases.ProductoAdapter;
import utn.sistema.parcialUnoLabV.clases.Producto;
import utn.sistema.parcialUnoLabV.services.ServicioProductos;

public class MainActivity extends AppCompatActivity implements Handler.Callback
{
    List<Producto> productos;
    ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        String tituloActionBar = "";

        if(Locale.getDefault().getLanguage() == new Locale("es").getLanguage())
        {
            tituloActionBar = "Menú principal";
        }
        else
        {
            tituloActionBar = "Home menu";
        }

        actionBar.setTitle(tituloActionBar);

        this.productos = new ArrayList<>();
        Handler handler = new Handler(this);
        Controlador.setProductos(this.productos);
        this.adapter = new ProductoAdapter(this.productos, this);
        ServicioProductos servicioProductos = new ServicioProductos(handler);
        servicioProductos.start();

        RecyclerView recyclerView = super.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean handleMessage(@NonNull Message msg)
    {
        try
        {
            JSONArray lista = new JSONArray(msg.obj.toString());

            for (int i = 0; i < lista.length(); i++)
            {
                JSONObject productoJSON = lista.getJSONObject(i);
                Integer id = productoJSON.getInt("id");
                String nombre = productoJSON.getString("nombre");
                Integer cantidad = productoJSON.getInt("cantidad");
                Double precio = productoJSON.getDouble("precio");
                Producto producto = new Producto(id,nombre,cantidad,precio);
                this.productos.add(producto);
            }
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.adapter.notifyDataSetChanged();

    }
}