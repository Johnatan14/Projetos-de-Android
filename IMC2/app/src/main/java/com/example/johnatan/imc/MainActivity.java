package com.example.johnatan.imc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_peso;
    private EditText et_altura;
    private Button btn_calcular;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_peso = (EditText) findViewById(R.id.et_peso);
        et_altura = (EditText) findViewById(R.id.et_altura);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                int peso = Integer.parseInt(et_peso.getText().toString());
                float altura = Float.parseFloat(et_altura.getText().toString());
                float resultado = peso / (altura * altura);
                String toastResultado = String.valueOf(resultado);
                //
                if(resultado < 19){
                    tv_resultado.setText("Abaixo peso, procure seu médico!");
                    Toast.makeText(getBaseContext(),
                            toastResultado, Toast.LENGTH_LONG).show();
                }else if(resultado > 32){
                    tv_resultado.setText("Acima peso, procure seu médico!");
                    Toast.makeText(getBaseContext(),
                            toastResultado,Toast.LENGTH_LONG).show();
                }else{
                    tv_resultado.setText("Parabéns você está dentro do peso " +
                            "correto, mesmo assim visite o médico regularmente!");
                    Toast.makeText(getBaseContext(),
                            toastResultado,Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
