package com.example.raulterrazas.sdsaver;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText edt1,edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.edtx1);
        edt2=(EditText)findViewById(R.id.edtx2);
    }
    public void Guardar(View v) {
        String nomarch = edt1.getText().toString();
        String conte = edt2.getText().toString();
        try {
            File Sd = Environment.getExternalStorageDirectory();
            Toast.makeText(this,Sd.getAbsolutePath(),Toast.LENGTH_LONG).show();
            File file = new File(Sd.getAbsolutePath(), nomarch);
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(file));
            osw.write(conte);
            osw.flush();
            osw.close();
            Toast.makeText(this, "Su Archivo A Sido Guardado Exitosamente",
                    Toast.LENGTH_SHORT).show();
            edt1.setText("");
            edt2.setText("");
        } catch (IOException ioe) {
            Toast.makeText(this, "Error, No Se A Guardado El Archivo Correctamente",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void Cargar(View v) {
        String nombarch = edt1.getText().toString();
        File SD = Environment.getExternalStorageDirectory();
        File file = new File(SD.getAbsolutePath(), nombarch);
        try {
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String todo = "";
            while (linea != null) {
                todo = todo + linea + " ";
                linea = br.readLine();
            }
            br.close();
            archivo.close();
            edt2.setText(todo);

        } catch (IOException e) {
            Toast.makeText(this, "Error, El Archivo No Se Puede Leer",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
