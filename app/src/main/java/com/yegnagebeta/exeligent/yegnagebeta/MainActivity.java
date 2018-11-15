package com.yegnagebeta.exeligent.yegnagebeta;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    private ViewPager mViewPager;
    private BottomNavigationView bottomnav;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        bottomnav = (BottomNavigationView)findViewById(R.id.bottomnavigationview);
        bottomnav.setOnNavigationItemSelectedListener(mOnNavigationSelectedListner);

        loadFragment(new Gebeta());




    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

          /*  case R.id.action_info:
                Intent i= new Intent(Menu.this,info.class);
                startActivity(i);*/
        }
        return super.onOptionsItemSelected(item);
    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationSelectedListner
            =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.gebeta_nav:
                    loadFragment(new Gebeta());
                    return true;
                case R.id.loan_nav:
                    toolbar.setTitle("loan");
                    loadFragment(new loan());
                    return true;
                case R.id.recharge_nav:
                    toolbar.setTitle("recharge");
                    loadFragment(new Recharge());
                    return true;

            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {

        FragmentTransaction  transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}