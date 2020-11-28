package com.example.holamundodos;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_claveprod, et_nombreprod, et_descripcionprod, et_cantidadprod, et_precioprod,et_clave;
    Button btnBuscar, btnCreate;
    RequestQueue requestQueue;

    private  static final String URL1 = "https://apkmoviles.sallevent.com.mx/save.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestQueue = Volley.newRequestQueue(this);
        //UI
        initUI();
        readClavein();
        btnCreate.setOnClickListener(this);
        btnBuscar.setOnClickListener(this);
    }

    private void initUI() {
        //edit text

        et_nombreprod = findViewById(R.id.et_nombreprod);
        et_precioprod = findViewById(R.id.et_precioprod);
        et_descripcionprod = findViewById(R.id.et_descripcionprod);
        et_cantidadprod = findViewById(R.id.et_cantidadprod);
        et_claveprod = findViewById(R.id.et_claveprod);
        et_clave = findViewById(R.id.et_clave);


        //BUTTONS
        btnBuscar = findViewById(R.id.btnBuscar);
        btnCreate = findViewById(R.id.btnCreate);
       readClavein();
    }

    @Override
    public  void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnCreate) {
            String clave = et_clave.getText().toString().trim();
            String nombre = et_nombreprod.getText().toString().trim();
            String precio = et_precioprod.getText().toString().trim();
            String descripcion = et_descripcionprod.getText().toString().trim();
            String cantidad = et_cantidadprod.getText().toString().trim();
            createProducto(clave,nombre, precio, descripcion, cantidad);

        }else if (id == R.id.btnBuscar){
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("clave",et_claveprod.getText().toString().trim());
            startActivity(intent);
            readClavein();
            LimpiarTxt();
        }
    }

    public void readClavein() {
        String URL = "https://apkmoviles.sallevent.com.mx/readindividual.php?" ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String  clavein, Finaz;
                        int numero;
                        try {
                            numero = 1;

                            clavein = response.getString("clave") ;
                            numero = numero + Integer.parseInt(clavein);
                            Finaz = String.valueOf(numero);
                            et_clave.setText(Finaz);


                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }









    public void LimpiarTxt() {
             et_clave.setText("");
            et_cantidadprod.setText("");
            et_nombreprod.setText("");
            et_precioprod.setText("");
            et_descripcionprod.setText("");
        }
        private void createProducto( final String et_clave, final String nombre, final String precio,  final String descripcion, final String cantidad) {

            StringRequest stringRequest = new  StringRequest (
                    Request.Method.POST,
                    URL1,
                    new Response.Listener<String>() {
                        @Override
                         public void onResponse(String response) {
                            Toast.makeText(MainActivity.this,  "Correct", Toast.LENGTH_SHORT).show();
                        }
                       },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error){

                    }
                 }

            ){
                @Override
                 protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put ("clave",et_clave);
                    params.put ("nombre" , nombre);
                    params.put ("precio" , precio);
                    params.put ("descripcion" , descripcion);
                    params.put ("cantidad" , cantidad);
                    return params;
                }

            };
            requestQueue.add(stringRequest);
        }

}