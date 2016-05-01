package com.example.raulterrazas.stremail;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.edtx1);
        SharedPreferences pref = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        edt1.setText(pref.getString("Email",""));
    }
    public void Hecho(View v) {
        SharedPreferences pref = getSharedPreferences("Datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Email", edt1.getText().toString());
        editor.commit();
        finish();
    }
}
