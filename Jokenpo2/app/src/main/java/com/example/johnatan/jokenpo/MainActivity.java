package com.example.johnatan.jokenpo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn_pedra;
    private Button btn_papel;
    private Button btn_tesoura;
    private Button jokenpo_ok;

    private EditText et_nome;
    private TextView nome_jogador;

    private ImageView img_jogador;
    private ImageView img_computador;

    private TextView tv_jogador;
    private TextView tv_computador;

    int placarJogador = 0;
    int placarComputador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_nome = (EditText) findViewById(R.id.et_nome);
        jokenpo_ok = (Button) findViewById(R.id.jokenpo_ok);

        jokenpo_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = et_nome.getText().toString();
                nome_jogador.setText(nome);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et_nome.getWindowToken(), 0);
            }
        });
        nome_jogador = (TextView) findViewById(R.id.nome_jogador);

        btn_papel = (Button) findViewById(R.id.btn_papel);
        btn_pedra = (Button) findViewById(R.id.btn_pedra);
        btn_tesoura = (Button) findViewById(R.id.btn_tesoura);

        img_jogador = (ImageView) findViewById(R.id.img_jogador);
        img_computador = (ImageView) findViewById(R.id.img_computador);

        tv_jogador = (TextView) findViewById(R.id.tv_jogador);
        tv_computador = (TextView) findViewById(R.id.tv_computador);

        btn_pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaComputador = (int) (Math.random()*3) + 1;
                if (escolhaComputador == 1){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.pedra_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.pedra_computador));
                    Toast.makeText(getBaseContext(), "EMPATE", Toast.LENGTH_SHORT).show();

                }else if (escolhaComputador == 2){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.pedra_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.papel_computador));
                    Toast.makeText(getBaseContext(), "COMPUTADOR GANHOU", Toast.LENGTH_SHORT).show();
                    placarComputador++;
                    tv_computador.setText(String.valueOf(placarComputador));

                }else if (escolhaComputador == 3){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.pedra_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.tesoura_computador));
                    Toast.makeText(getBaseContext(), "JOGADOR GANHOU", Toast.LENGTH_SHORT).show();
                    placarJogador++;
                    tv_jogador.setText(String.valueOf(placarJogador));

                }
            }
        });

        btn_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaComputador = (int) (Math.random()*3) + 1;
                if (escolhaComputador == 1){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.papel_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.pedra_computador));
                    Toast.makeText(getBaseContext(), "JOGADOR GANHOU", Toast.LENGTH_SHORT).show();
                    placarJogador++;
                    tv_jogador.setText(String.valueOf(placarJogador));

                }else if (escolhaComputador == 2){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.papel_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.papel_computador));
                    Toast.makeText(getBaseContext(), "EMPATE", Toast.LENGTH_SHORT).show();

                }else if (escolhaComputador == 3){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.papel_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.tesoura_computador));
                    Toast.makeText(getBaseContext(), "COMPUTADOR GANHOU", Toast.LENGTH_SHORT).show();
                    placarComputador++;
                    tv_computador.setText(String.valueOf(placarComputador));

                }
            }
        });

        btn_tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaComputador = (int) (Math.random()*3) + 1;
                if (escolhaComputador == 1){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.tesoura_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.pedra_computador));
                    Toast.makeText(getBaseContext(), "COMPUTADOR GANHOU", Toast.LENGTH_SHORT).show();
                    placarComputador++;
                    tv_computador.setText(String.valueOf(placarComputador));

                }else if (escolhaComputador == 2){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.tesoura_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.papel_computador));
                    Toast.makeText(getBaseContext(), "JOGADOR GANHOU", Toast.LENGTH_SHORT).show();
                    placarJogador++;
                    tv_jogador.setText(String.valueOf(placarJogador));

                }else if (escolhaComputador == 3){
                    img_jogador.setBackground( getResources().getDrawable(R.drawable.tesoura_jogador));
                    img_computador.setBackground( getResources().getDrawable(R.drawable.tesoura_computador));
                    Toast.makeText(getBaseContext(), "EMPATE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
