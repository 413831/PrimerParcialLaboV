package utn.sistema.parcialUnoLabV.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import utn.sistema.parcialUnoLabV.EditarProducto;

public class ClickProducto implements View.OnClickListener
{
    Activity activity;
    int indice;

    public ClickProducto(Activity activity, int indice)
    {
        this.activity = activity;
        this.indice = indice;
    }

    @Override
    public void onClick(View v)
    {
        // Se navega hacia menu de EditarUsuario
        Intent intent = new Intent(this.activity, EditarProducto.class);

        intent.putExtra("index", this.indice);
        this.activity.startActivity(intent);
    }
}
