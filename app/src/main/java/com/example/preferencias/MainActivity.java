package com.example.preferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText campoUsuario, campoPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario=(EditText)findViewById(R.id.login);
        campoPass=(EditText)findViewById(R.id.pass);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.botonGuardar:
                guardarPreferencias();
                break;
            case R.id.botonCargar:
                cargarPreferencias();
        }
    }

    private void guardarPreferencias() {
        //Permite almacenar en un fichero las preferencias
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String usuario=campoUsuario.getText().toString();
        String pass=campoPass.getText().toString();

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("user",usuario);
        editor.putString("pass", pass);
        editor.commit();


    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user","");
        String pass=preferences.getString("pass","");

        campoUsuario.setText(user);
        campoPass.setText(pass);
    }
}