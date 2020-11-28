package com.example.holamundodos;


import androidx.appcompat.app.AppCompatActivity;

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


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button btnDelete, btnEdit;
    EditText et_claveprod, et_nombreprod, et_descripcionprod, et_cantidadprod, et_precioprod,et_clave2;

    String clave;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        requestQueue = Volley.newRequestQueue(this);

        Bundle extras = getIntent().getExtras();
        if (extras!=null) {
            clave = extras.getString("clave");
        }
        //UI
        initUI();

        readProd();

        btnDelete.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
    }

    private void initUI() {
        //edit text

        et_nombreprod = findViewById(R.id.et_nombreprod);
        et_precioprod = findViewById(R.id.et_precioprod);
        et_descripcionprod = findViewById(R.id.et_descripcionprod);
        et_cantidadprod = findViewById(R.id.et_cantidadprod);
        et_claveprod = findViewById(R.id.et_claveprod);
        et_clave2 = findViewById(R.id.et_clave2);

        //BUTTONS
        btnDelete = findViewById(R.id.btnEdit);
        btnEdit = findViewById(R.id.btnDelete);
    }

    private void readProd() {
        String URL = "https://apkmoviles.sallevent.com.mx/read.php?clave=" + clave;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String   clave , nombre, precio, descripcion, cantidad;
                        try {
                            clave  = response.getString("clave");
                            nombre = response.getString("nombre_producto");
                            precio = response.getString("precio_producto");
                            descripcion = response.getString("descripcion_producto");
                            cantidad = response.getString("cantidad_producto");

                            et_clave2.setText(clave);
                            et_nombreprod.setText(nombre);
                            et_precioprod.setText(precio);
                            et_descripcionprod.setText(descripcion);
                            et_cantidadprod.setText(cantidad);


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


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnEdit) {
            String clave = et_clave2.getText().toString().trim();
            String nombre =  et_nombreprod.getText().toString().trim();
            String precio =  et_precioprod.getText().toString().trim();
            String descripcion =  et_descripcionprod.getText().toString().trim();
            String cantidad =  et_cantidadprod.getText().toString().trim();

            updateProd(clave ,nombre, precio, descripcion, cantidad);

        } else if (id == R.id.btnDelete) {
            String idClave = et_claveprod.getText().toString().trim();

            removeUser(idClave);

        }
    }

    private void updateProd(final String clave, final String nombre, final String precio, final String descripcion, final String cantidad) {
        String URL = "https://apkmoviles.sallevent.com.mx/edit.php";
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity2.this, "Actualizado Correctamente", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("clave",clave);
                params.put("nombre_producto",nombre);
                params.put("precio_producto",precio);
                params.put("descripcion_producto",descripcion);
                params.put("cantidad_producto",cantidad);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void removeUser(final String idClave) {
        String URL = "https://apkmoviles.sallevent.com.mx/delete.php";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("clave",idClave);
                return params;
            }
        };
            requestQueue.add(stringRequest);
    }
}

