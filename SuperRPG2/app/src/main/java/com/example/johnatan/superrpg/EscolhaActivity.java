package com.example.johnatan.superrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EscolhaActivity extends AppCompatActivity {
    private Button btn_velocidade;
    private Button btn_forca;
    private Button btn_inteligencia;
    private ImageView iv_personagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha);

        iv_personagem = (ImageView) findViewById(R.id.iv_personagem_escolha);
        Intent intent = getIntent();
        Bundle escolha = intent.getExtras();
        final Integer escolha_personagem = Integer.parseInt((String) escolha.get("escolha"));
        if(escolha_personagem == 1){
            iv_personagem.setImageResource(R.drawable.j1);
        }else if(escolha_personagem == 2){
            iv_personagem.setImageResource(R.drawable.j2);
        }else{
            iv_personagem.setImageResource(R.drawable.j3);
        }

        btn_velocidade = (Button) findViewById(R.id.btn_velocidade);
        btn_velocidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), AtributoActivity.class);
                ir.putExtra("escolha_personagem", escolha_personagem);
                ir.putExtra("habilidade", 1);
                startActivity(ir);
            }
        });
        btn_forca = (Button) findViewById(R.id.btn_forca);
        btn_forca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), AtributoActivity.class);
                ir.putExtra("habilidade", 2);
                ir.putExtra("escolha_personagem", escolha_personagem);
                startActivity(ir);
            }
        });
        btn_inteligencia = (Button) findViewById(R.id.btn_inteligencia);
        btn_inteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), AtributoActivity.class);
                ir.putExtra("habilidade", 3);
                ir.putExtra("escolha_personagem", escolha_personagem);
                startActivity(ir);
            }
        });
    }
}
