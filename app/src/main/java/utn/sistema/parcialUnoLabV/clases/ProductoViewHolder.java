package utn.sistema.parcialUnoLabV.clases;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import utn.sistema.parcialUnoLabV.R;

public class ProductoViewHolder extends RecyclerView.ViewHolder
{
    TextView txtNombre;
    TextView txtCantidad;
    TextView txtPrecio;

    public ProductoViewHolder(@NonNull View itemView)
    {
        super(itemView);
        this.txtNombre = itemView.findViewById(R.id.txtNombre);
        this.txtCantidad = itemView.findViewById(R.id.txtCantidad);
        this.txtPrecio = itemView.findViewById(R.id.txtPrecio);
    }
}
