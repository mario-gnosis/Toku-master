

package com.support.android.tokusatsu;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Mário on 28/09/2015.
 */
public class TokusatsuDetailActivity extends AppCompatActivity {

    public static final String EXTRA_OBJECT = "extra_object";
    private Tokusatsu tokusatsu;
    private TextView conteudo;
    private String[] recebeConteduto;


    /*
    Responsável por fazer a criação dos componentes na tela. Sempre que quiser trabalhar com um componente de tela
    usará o onCreate. Dentro do onCreate, há duas chamadas de métodos, o super.onCreate(savedInstanceState) que é
    o onCreate nativo da plataforma e o setContentView(R.layout.activity_main) que é onde relacionamos nosso layout
    com nossa Activity.
    */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        tokusatsu = (Tokusatsu) intent.getSerializableExtra(EXTRA_OBJECT);

        // parte superior da tela quando encolhe a imagem na parte a historia, musia e video
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            //Local onde adiciona a imagem na tela dos detalhes
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //pega o nome do Tokusatsus
        collapsingToolbar.setTitle(tokusatsu.name);

        loadBackdrop();

/*
        conteudo = (TextView) findViewById(R.id.conteudo_historia);
        switch (tokusatsu.name){

            case 0:
                recebeConteduto = getResources().getStringArray(R.array.history_bycrossers);
                findViewById(R.id.conteudo_historia) = getResources().getStringArray(R.array.history_bycrossers);
                break;
        }
*/


    }
    //Adiciona a imagem na tela de detalhes
    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(tokusatsu.getPhotoResourceId(this)).centerCrop().into(imageView);

        //Pega o contéudo que está em uma array no String\ Value
        int id = getResources().getIdentifier("history_" + tokusatsu.photo.toLowerCase(), "array", getPackageName());
        String[] description = getResources().getStringArray(id);
        String dee = "";
        for (String de : description){
            dee += de;
        }
        ( (TextView) findViewById(R.id.conteudo_historia) ).setText(dee);
    }

        //MENU DE CONF, BUSCA E ETC
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Sair) {
           AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Sair");
            alertDialog.show();


        System.exit(0);
    }

    return super.onOptionsItemSelected(item);
    }
    }


