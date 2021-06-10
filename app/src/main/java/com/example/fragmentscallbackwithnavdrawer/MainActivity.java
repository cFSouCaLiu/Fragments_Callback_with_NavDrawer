package com.example.fragmentscallbackwithnavdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.fragmentscallbackwithnavdrawer.utils.Gol;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    //la gestion des fragms :
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    // creat de la navigview :
    private NavigationView navigationView;
    Button btn_addFragment;




    private static final String emplacement = MainActivity.class.getSimpleName();

    public void initUi() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_navigationView);
        btn_addFragment = findViewById(R.id.btn_addFragment);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gol.addLog(emplacement, "onCreate");
// ajout d un  listener s/ btn_addFragment pr affich  le frgm qd clic :


        // ajout de la meth de init du UI :
        initUi();

        btn_addFragment.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   addFragment();
                                               }
                                           }
        );
        // ajout du 1er frgm :
//        addFragment();

        // ajout du support pour la gestion de la toolbar :
        setSupportActionBar(toolbar);
        //ajout de la gestion des options d'accessibilite
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this, // : le contexte
                drawerLayout, // : le layout de MainActivity
                toolbar, // : la toolbar
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        // ajout d un  listener sur le bt hamburger :
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        //
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
//            addFragment();
            // Force  l affichage du 1er frgm  au demarrage
            navigationView.setCheckedItem(R.id.nav_fragment_1);
        }

        // Force  l affichage du 1er frgm  au demarrage
        // navigationView.setCheckedItem(R.id.nav_fragment_1);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void addFragment() {
        fragmentManager = getSupportFragmentManager();
        //commencer la discussion :
        fragmentTransaction = fragmentManager.beginTransaction();
        // appel de neos frgms :
        Fragment_01 fragment_01 = new Fragment_01();
        // ajout au container de fragm :
        fragmentTransaction.add(R.id.fragment_container, fragment_01);
        fragmentTransaction.addToBackStack("addToBackStack1");
        //finalis de la creat du frgm :
        fragmentTransaction.commit();



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_fragment_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_01()).
                        commit();
                break;
            case R.id.nav_fragment_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_02()).
                        commit();
                break;
            case R.id.nav_fragment_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_03()).
                        commit();
                break;
            case R.id.nav_fragment_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_04()).
                        commit();
                break;
            case R.id.nav_fragment_5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_05()).
                        commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    protected void onStart() {
        super.onStart();
        Gol.addLog(emplacement, "onPause");
    }

    protected void onResume() {
        super.onResume();
        Gol.addLog(emplacement, "onResume");
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}