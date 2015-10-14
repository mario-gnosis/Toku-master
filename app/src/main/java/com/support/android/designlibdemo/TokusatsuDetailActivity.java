/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.designlibdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Mário on 28/09/2015.
 */
public class TokusatsuDetailActivity extends AppCompatActivity {

    public static final String EXTRA_OBJECT = "extra_object";
    private Tokusatsu tokusatsu;


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


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(tokusatsu.name);

        loadBackdrop();
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(tokusatsu.getPhotoResourceId(this)).centerCrop().into(imageView);
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
            alertDialog.setMessage("Até logo!");
            alertDialog.show();


        System.exit(0);
    }

    return super.onOptionsItemSelected(item);
    }
    }


