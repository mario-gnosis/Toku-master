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

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário on 28/09/2015.
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tela principal
        setContentView(R.layout.activity_main);

        //envia para a toolbar onde tem a historia dos tokusatsus
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

          //MENU DE INFORMAÇÕES E SETA DE VOLTAR DA TELA
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        //icone de Tokusatsus , Músicas e Vídeos
           TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setHorizontalScrollBarEnabled(false);
        tabLayout.setVerticalScrollBarEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
          return true;
    }

    //Colocando atividade nos icones do Menu
      public boolean OnMenuItemSelected(int featureId, MenuItem item){
        switch (item.getItemId()){

            case R.id.nav_home:
                break;
            case R.id.nav_informacao:
                Toast.makeText(this,"Falta direcionar para a tela correta!",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_musica:
                Toast.makeText(this,"Aqui vai te direcionar para uma tela com uma lista de músicas!",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_busca:
                Toast.makeText(this,"Você podera procuar algo do app!",Toast.LENGTH_LONG).show();
                break;
            case  R.id.nav_agradecimento:
                Toast.makeText(this,"Obrigado a todos que me ajudaram!",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_sugestao:
                Toast.makeText(this,"O que você achou do app!",Toast.LENGTH_LONG).show();
                break;
            case  R.id.nav_site_tokusatsus:
                Toast.makeText(this,"Procure no Google!",Toast.LENGTH_LONG).show();
                break;


        }

        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "O que você gostaria de procurar?", Toast.LENGTH_SHORT).show();
            return true;
        }

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

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new TokusatsuListFragment(), "Tokusatsus");
        adapter.addFragment(new MusicasListFragment(), "Músicas");
        adapter.addFragment(new VideoFragment(), "Vídeos");
        viewPager.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
