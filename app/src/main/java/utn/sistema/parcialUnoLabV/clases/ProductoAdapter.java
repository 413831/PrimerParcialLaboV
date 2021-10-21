package utn.sistema.parcialUnoLabV.clases;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import utn.sistema.parcialUnoLabV.R;
import utn.sistema.parcialUnoLabV.clases.ProductoViewHolder;
import utn.sistema.parcialUnoLabV.listeners.ClickProducto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder>
{
    List<Producto> productos;
    Activity activity;

    public ProductoAdapter(List<Producto> lista)
    {
        this.productos = lista;
    }

    public ProductoAdapter(List<Producto> lista, Activity activity)
    {
        this.productos = lista;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position)
    {
        Producto producto = this.productos.get(position);

        View.OnClickListener onClickListener = new ClickProducto(this.activity,position);
        holder.layout.setOnClickListener(onClickListener);
        holder.txtNombre.setText(producto.getNombre());
        holder.txtCantidad.setText("Cantidad: " + String.valueOf(producto.getCantidad()));
        holder.txtPrecio.setText("Precio unidad: " + String.valueOf(producto.getPrecio()));
    }

    @Override
    public int getItemCount()
    {
        return this.productos.size();
    }
}
