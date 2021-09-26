package com.example.semana6_bolita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

import model.enviandoDatitos;

public class MainActivity extends AppCompatActivity {

    private Button arribaBoton, abajoBoton, derechaBoton, izquierdaBoton, colorboton;

    enviandoDatitos sendDatos;
    Gson gson;

    private String json;

    BufferedReader bfr;
    BufferedWriter bfw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arribaBoton = findViewById(R.id.arriba_button);
        abajoBoton = findViewById(R.id.abajo_button);
        derechaBoton = findViewById(R.id.derecha_button);
        izquierdaBoton = findViewById(R.id.izquierda_button);
        colorboton = findViewById(R.id.color_button);

        sendDatos = new enviandoDatitos();
        gson = new Gson();


        new Thread(
                () -> {
                    try {
                        Socket socket = new Socket("192.168.0.200", 9000);

                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        bfr = new BufferedReader(isr);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bfw = new BufferedWriter(osw);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();


        arribaBoton.setOnClickListener(
                (v) -> {
                    sendDatos.setSeñalesMoviento("arriba comadre");
                    sendDatos.setMovimientoPixel(4);
                    json = gson.toJson(sendDatos);
                    enviateMensaje(json);


                }
        );

        abajoBoton.setOnClickListener(
                (v) -> {
                    sendDatos.setSeñalesMoviento("abajo papito");
                    sendDatos.setMovimientoPixel(4);
                    json = gson.toJson(sendDatos);
                    enviateMensaje(json);


                }
        );

        derechaBoton.setOnClickListener(
                (v) -> {
                    sendDatos.setSeñalesMoviento("derecha mi rey");
                    sendDatos.setMovimientoPixel(4);
                    json = gson.toJson(sendDatos);
                    enviateMensaje(json);


                }
        );

        izquierdaBoton.setOnClickListener(
                (v) -> {
                    sendDatos.setSeñalesMoviento("izquierda macarena");
                    sendDatos.setMovimientoPixel(4);
                    json = gson.toJson(sendDatos);
                    enviateMensaje(json);


                }
        );

        colorboton.setOnClickListener(
                (v) -> {
                    sendDatos.setSeñalesMoviento("coloreate nene");
                    sendDatos.setR(new Random().nextInt(256)+0);
                    sendDatos.setG(new Random().nextInt(256)+0);
                    sendDatos.setB(new Random().nextInt(256)+0);
                    json = gson.toJson(sendDatos);
                    enviateMensaje(json);

                }
        );

    }


    public void enviateMensaje(String mensajito) {
        new Thread(
                () -> {
                    try {
                        bfw.write(mensajito + "\n");
                        bfw.flush();

                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                }

        ).start();

    }






}