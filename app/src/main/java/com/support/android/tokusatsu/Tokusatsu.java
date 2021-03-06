package com.support.android.tokusatsu;

import android.content.Context;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário on 28/09/2015.
 */
public class Tokusatsu  implements Serializable {

  public String name;
  public String photo;
 public String conteudo;
 public TextView txtContenido;



  public Tokusatsu(){}
  //txtContenido = (TextView) findViewById(R.id.conteudo_historia);

  public Tokusatsu(String name, String photo ){
    this.name = name;
    this.photo = photo;
  }


  public static List<Tokusatsu> prePopulate(){

    List<Tokusatsu> list = new ArrayList<>();


    list.add(new Tokusatsu("ByCrossers", "bycrosser"));
    list.add(new Tokusatsu("Black Kamen Rider", "black_kamen_rider"));
    list.add(new Tokusatsu("Cybercops", "cybercops"));
    list.add(new Tokusatsu("Changem", "changeman"));
    list.add(new Tokusatsu("Esper ou Vesper", "esper"));
    list.add(new Tokusatsu("Flashman", "flashman"));
    list.add(new Tokusatsu("Gyaban", "gyaban"));
    list.add(new Tokusatsu("Goggle Five", "goggle_five"));
    list.add(new Tokusatsu("Jaspion", "jaspion"));
    list.add(new Tokusatsu("Jiraya", "jiraya"));
    list.add(new Tokusatsu("Jiban", "jiban"));
    list.add(new Tokusatsu("Kamen Rider Black RX", "black_rider_rx"));
    list.add(new Tokusatsu("Lion Man", "lion_man"));
    list.add(new Tokusatsu("Lion Man Branco", "lion_branco"));
    list.add(new Tokusatsu("Machine Man", "machine_man"));
    list.add(new Tokusatsu("Maskman", "maskman"));
    list.add(new Tokusatsu("Metalder", "metalder"));
    list.add(new Tokusatsu("National Kid", "national_kid"));
    list.add(new Tokusatsu("Policial Espacial Shaider", "shaider"));
    list.add(new Tokusatsu("Ryakendo", "ryukendo"));
    list.add(new Tokusatsu("Robo Gigante", "robo_gigante"));
    list.add(new Tokusatsu("Spectreman", "spectreman"));
    list.add(new Tokusatsu("Spielvan", "spielvan"));
    list.add(new Tokusatsu("Solbrain", "solbrain"));
    list.add(new Tokusatsu("Sharivan", "sharivan"));
    list.add(new Tokusatsu("Ultraman", "ultraman"));
    list.add(new Tokusatsu("Ultraseven", "ultraseven"));
    list.add(new Tokusatsu("Ultraman Jack", "jack"));
    list.add(new Tokusatsu("Utraman Tiga", "ultraman_tiga"));
     list.add(new Tokusatsu("Vingadores do Espaço", "vingadores"));
    list.add(new Tokusatsu("Winspector", "winspector"));



    return list;
  }

  


  public int getPhotoResourceId(Context context) {
    return context.getResources().getIdentifier(photo, "drawable", context.getPackageName());
  }
  public int getConteudoResourceId(Context context) {
    return context.getResources().getIdentifier(photo, "values", context.getPackageName());
  }


}

