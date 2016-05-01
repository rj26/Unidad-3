package com.example.raulterrazas.fiftygame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    private TextView txv2, txv3;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edtx1);
        txv2 = (TextView) findViewById(R.id.txt2);
        txv3 = (TextView) findViewById(R.id.txt3);
        SharedPreferences prefe = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String v = String.valueOf(prefe.getInt("Puntuación", 0));
        txv2.setText(v);
        num = 1 + (int) (Math.random() * 50);
    }
    public void Adivinar(View v) {
        int val = Integer.parseInt(edt1.getText().toString());
        if (num == val) {
            int puntuactual = Integer.parseInt(txv2.getText()
                    .toString());
            puntuactual++;
            txv2.setText(String.valueOf(puntuactual));
            txv3.setText("Vaya acertaste, Ha! Te crees muy listo, dime ahora que número es?");
            edt1.setText("");
            SharedPreferences pref =getSharedPreferences("Datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt("Puación", puntuactual);
            editor.commit();
        } else {
            if (val > num) {
                txv3.setText("Huy casi, pero te pasaste");
            } else {
                txv3.setText("Vamos casi lo tienes, pero aun te falta");
            }
        }
    }
}
