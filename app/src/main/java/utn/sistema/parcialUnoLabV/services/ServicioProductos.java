package utn.sistema.parcialUnoLabV.services;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import utn.sistema.parcialUnoLabV.MainActivity;

public class ServicioProductos extends Thread
{
    Handler handler;

    public ServicioProductos(Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public void run()
    {
        this.getObjetos();
    }

    private void getObjetos()
    {
        // IP para Localhost
        String url = "http://XXX.XXX.X.X:3000/productos";

        HttpConnection httpConnection = HttpConnection.getInstance();
        String s = httpConnection.obtenerElementos(url);
        Log.d("respuesta",s);
        // Comunicacion para leer el mensaje
        Message message = new Message();
        message.obj = s;
        // Se puede configurar una constante para conectar un hilo
        // Se guarda mensaje dentro del handler
        this.handler.sendMessage(message);
    }
}
