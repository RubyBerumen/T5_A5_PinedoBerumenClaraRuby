package com.example.t5_a5_pinedoberumenclararuby;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText caja1, caja2;
    Spinner spinner1, spinner2;
    int posicion1 = 1;
    int posicion2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caja1 = findViewById(R.id.caja1);
        caja2 = findViewById(R.id.caja2);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.spinner_conversion,
                android.R.layout.simple_spinner_item);

        spinner1 = findViewById(R.id.spinner1);
        spinner1.setAdapter(adaptador);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(adaptador);
        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        String texto = caja1.getText().toString();
        if (texto.equals(""))
            texto="0";
        double num = Double.parseDouble(texto);
        double res=num;

        if (parent.getId() == R.id.spinner1)
            posicion1=position;
        if (parent.getId() == R.id.spinner2)
            posicion2=position;

        switch (spinner1.getItemAtPosition(posicion1).toString()){
            case "Centigrados":
                switch (spinner2.getItemAtPosition(posicion2).toString()){
                    case "Fahrenheit":  res=(num*1.8)+32;  break;
                    case "Rankine":     res=(num*1.8)+32+ 459.67;  break;
                    case "Kelvin":      res=num+ 273.15;   break;
                    default:break;
                }
                break;
            case "Fahrenheit":
                switch (spinner2.getItemAtPosition(posicion2).toString()){
                    case "Centigrados": res=(num-32)/1.8;break;
                    case "Rankine":     res=num+459.67;  break;
                    case "Kelvin":      res=(num+459.67)/1.8;   break;
                    default:break;
                }
                break;
            case "Rankine":
                switch (spinner2.getItemAtPosition(posicion2).toString()){
                    case "Centigrados": res=(num-491.67) / 1.8;break;
                    case "Fahrenheit":  res=num-459.67;  break;
                    case "Kelvin":      res=num/1.8;   break;
                    default:break;
                }
                break;
            case "Kelvin":
                switch (spinner2.getItemAtPosition(posicion2).toString()){
                    case "Centigrados": res=num- 273.15;  break;
                    case "Fahrenheit":  res=(num* 1.8) - 459.67;  break;
                    case "Rankine":     res=num*1.8;  break;
                    default:break;
                }
                break;
            default:break;
        }
        caja2.setText(""+res);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}