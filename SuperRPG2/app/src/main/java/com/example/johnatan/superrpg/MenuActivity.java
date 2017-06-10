package com.example.johnatan.superrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity{
    private Button btn_selecionar1;
    private Button btn_selecionar2;
    private Button btn_selecionar3;
    private TextView tv_score;
    //int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);
        btn_selecionar1 = (Button) findViewById(R.id.btn_selecionar1);
        btn_selecionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selecionar1 = new Intent(getBaseContext(), EscolhaActivity.class);
                selecionar1.putExtra("escolha", "1");
                startActivity(selecionar1);
            }
        });
        btn_selecionar2 = (Button) findViewById(R.id.btn_selecionar2);
        btn_selecionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selecionar2 = new Intent(getBaseContext(), EscolhaActivity.class);
                selecionar2.putExtra("escolha", "2");
                startActivity(selecionar2);
            }
        });
        btn_selecionar3 = (Button) findViewById(R.id.btn_selecionar3);
        btn_selecionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selecionar3 = new Intent(getBaseContext(), EscolhaActivity.class);
                selecionar3.putExtra("escolha", "3");
                startActivity(selecionar3);
            }
        });
        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText(Integer.toString(Score.score));



    }
}
