package com.example.daini.practica28marzo.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.daini.practica28marzo.EscuchaButton;
import com.example.daini.practica28marzo.Model.ImaxesModel;
import com.example.daini.practica28marzo.Adapters.PagerAdapter;
import com.example.daini.practica28marzo.R;

import java.util.List;

public class SendMailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mail);


        //encontrar viewPager en xml
        ViewPager viewPager = (ViewPager) findViewById(R.id.miViewPager);

        //declaro clase PagerAdapter
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        //seteo adapter
        viewPager.setAdapter(pagerAdapter);

        //encontrar tab en xml
        TabLayout tabLayout = (TabLayout) findViewById(R.id.mi_tab_layout);

        //setear tab con view pager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Enviar");
        tabLayout.getTabAt(1).setText("Ver Historial");


    }
}
