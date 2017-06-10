package com.example.johnatan.superrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class AtributoActivity extends AppCompatActivity {
    private SeekBar sk_atributo;
    private Button btn_jogar;
    private ImageView iv_personagem;
    int valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_atributo);
        btn_jogar = (Button) findViewById(R.id.btn_jogar);
        sk_atributo = (SeekBar) findViewById(R.id.sk_atributo);
        iv_personagem = (ImageView) findViewById(R.id.iv_personagem_atributo);
        Intent intent = getIntent();
        Bundle atributo = intent.getExtras();
        final Integer personagem = (Integer) atributo.get("escolha_personagem");
        if(personagem == 1){
            iv_personagem.setImageResource(R.drawable.j1);
        }else if(personagem == 2){
            iv_personagem.setImageResource(R.drawable.j2);
        }else{
            iv_personagem.setImageResource(R.drawable.j3);
        }
        final Integer habilidade = (Integer) atributo.get("habilidade");

        sk_atributo.setMax(100);
        sk_atributo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valor = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorTexto = Integer.toString(valor);
                Intent i = new Intent(getBaseContext(), JogadaActivity.class);
                i.putExtra("personagem", personagem);
                i.putExtra("valor", valorTexto);
                i.putExtra("habilidade", habilidade);
                startActivity(i);
            }
        });
    }
}
