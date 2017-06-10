package com.example.johnatan.superrpg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JogadaActivity extends AppCompatActivity {
    private TextView tv_valor;
    private ImageView iv_computador;
    private TextView tv_velocidade_computador;
    private ImageView iv_personagem_jogar;
    private static int TEMPO = 3000;
    private TextView tv_habilidade_jogador;
    private TextView tv_habilidade_computador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_jogada);
        tv_valor = (TextView) findViewById(R.id.tv_valor);
        iv_computador = (ImageView) findViewById(R.id.iv_computador);
        tv_velocidade_computador = (TextView) findViewById(R.id.tv_velocidade_computador);
        iv_personagem_jogar = (ImageView) findViewById(R.id.iv_personagem_jogar);
        tv_habilidade_jogador = (TextView) findViewById(R.id.tv_habilidade_jogador);
        tv_habilidade_computador = (TextView) findViewById(R.id.tv_habilidade_computador);

        //
        Intent i2 = getIntent();
        Bundle i3 = i2.getExtras();
        String valor = i3.getString("valor");
        Integer personagem_jogar = (Integer) i3.get("personagem");
        Integer habilidade = (Integer) i3.get("habilidade");

        if(habilidade == 1){
            tv_habilidade_computador.setText("Velocidade");
            tv_habilidade_jogador.setText("Velocidade");
        }else if(habilidade == 2){
            tv_habilidade_computador.setText("Força");
            tv_habilidade_jogador.setText("Força");
        }else {
            tv_habilidade_computador.setText("Inteligência");
            tv_habilidade_jogador.setText("Inteligência");
        }

        if(personagem_jogar == 1){
            iv_personagem_jogar.setImageResource(R.drawable.j1);
        }else if(personagem_jogar == 2){
            iv_personagem_jogar.setImageResource(R.drawable.j2);
        }else{
            iv_personagem_jogar.setImageResource(R.drawable.j3);
        }

        String getValor = valor;
        int valorJogador = Integer.valueOf(getValor);
        tv_valor.setText(getValor);

        int escolhaComputador = (int) (Math.random()*100)+1;
        int personagemComputador = (int) (Math.random()*3)+1;

        if(personagemComputador == 1){
            iv_computador.setImageResource(R.drawable.c1);
        }else if(personagemComputador == 2){
            iv_computador.setImageResource(R.drawable.c2);
        }else if(personagemComputador == 3) {
            iv_computador.setImageResource(R.drawable.c3);
        }

        tv_velocidade_computador.setText(Integer.toString(escolhaComputador));

        if(escolhaComputador == valorJogador){
            Toast.makeText(getBaseContext(),
                    "EMPATE",Toast.LENGTH_LONG).show();
        }else if(escolhaComputador < valorJogador){
            Toast.makeText(getBaseContext(),
                    "JOGADOR GANHOU",Toast.LENGTH_LONG).show();
                    Score.score += 560;
        }else{
            Toast.makeText(getBaseContext(),
                    "JOGADOR PERDEU",Toast.LENGTH_LONG).show();
                    Score.score -= 260;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(i);
                finish();
            }
        },TEMPO);

    }
}
