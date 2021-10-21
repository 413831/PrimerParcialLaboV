package utn.sistema.parcialUnoLabV.clases;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import utn.sistema.parcialUnoLabV.R;

public class ProductoViewHolder extends RecyclerView.ViewHolder
{
    TextView txtNombre;
    TextView txtCantidad;
    TextView txtPrecio;
    LinearLayout layout;

    public ProductoViewHolder(@NonNull View itemView)
    {
        super(itemView);

        this.layout = itemView.findViewById(R.id.layoutProducto);
        this.txtNombre = itemView.findViewById(R.id.txtNombre);
        this.txtCantidad = itemView.findViewById(R.id.txtCantidad);
        this.txtPrecio = itemView.findViewById(R.id.txtPrecio);
    }
}
