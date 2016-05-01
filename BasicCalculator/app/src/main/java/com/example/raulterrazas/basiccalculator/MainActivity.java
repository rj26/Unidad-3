package com.example.raulterrazas.basiccalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText n1,n2,Dts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = (EditText) findViewById(R.id.txt3);
        n2 = (EditText) findViewById(R.id.txt4);
        Dts = (EditText) findViewById(R.id.txtD);
        Cargar();
    }
    public void Suma (View view) {
        Oper(1);
        Cargar();
    }
    public void  Resta (View view) {
        Oper(2);
        Cargar();
    }
    public void Multiplicación (View view) {
        Oper(3);
        Cargar();
    }
    public void División (View view) {
        Oper(4);
        Cargar();
    }
    private void Oper(int op) {
        String numu = n1.getText().toString();
        String numd = n2.getText().toString();
        if (!numu.equals("") && !numd.equals("")) {
            int ni1 = Integer.parseInt(numu);
            int ni2 = Integer.parseInt(numd);
            String r;
            switch (op) {
                case 1:
                    r=  S (ni1, ni2);
                    Toast.makeText(this, "La Suma es : " + r, Toast.LENGTH_SHORT).show();
                    Guardar (ni1 + " + " + ni2 + " = " + r);
                    break;
                case 2:
                    r = R (ni1, ni2);
                    Toast.makeText(this, "La Resta es : " + r, Toast.LENGTH_SHORT).show();
                    Guardar (ni1 + " - " + ni2 + " = " + r);
                    break;
                case 3:
                    r = M (ni1, ni2);
                    Toast.makeText(this, "La Multiplicación es: " + r, Toast.LENGTH_SHORT).show();
                    Guardar (ni1 + " * " + ni2 + " = " + r);
                    break;
                case 4:
                    r = D (ni1, ni2);
                    Toast.makeText(this, "La División : " + r, Toast.LENGTH_SHORT).show();
                    Guardar (ni1 + " / " + ni2 + " = " + r);
                    break;
                default:
                    break;
            }} else {
            Toast.makeText(this, "Ingrese otro número por favor", Toast.LENGTH_SHORT).show();
        }
    }
    private String S (int n1, int n2) {
        int S = n1 + n2;
        String result = "" + S;
        return result;
    }
    private String R (int n1, int n2) {
        int R = n1 - n2;
        String result = "" + R;
        return result;
    }
    private String M (int n1, int n2) {
        int M = n1 * n2;
        String result = "" + M;
        return result;
    }
    private String  D (int n1, int n2) {
        if (n2 != 0) {
            float D = n1 / n2;
            String result = "" +  D;
            return result;
        } else {
            return "No se puede dividir entre 0";
        }
    }
    private void Cargar (){
        String nomarch = "Resultados.txt";
        nomarch = nomarch.replace('/','-');
        boolean found = false;
        String[] Files = fileList();
        for(int f = 0;f<Files.length;f++)
            if(nomarch.equals(Files[f]))
                found = true;
        if(found==true){
            try {
                InputStreamReader file = new InputStreamReader(
                        openFileInput(nomarch));
                BufferedReader br = new BufferedReader(file);
                String linea = br.readLine();
                String T = "";
                while (linea != null) {
                    T = T+ linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                file.close();
                Dts.setText(T);
            } catch (IOException e) {}
        }else  { }
    }
    private void Guardar (String data_1){
        String nomarch = "Resultados.txt";
        nomarch = nomarch.replace('/','-');
        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput(
                    nomarch, Activity.MODE_PRIVATE));
            file.write(Dts.getText().toString()+"\n"+data_1);
            file.flush();
            file.close();
        } catch (IOException e) {
        }
    }
}