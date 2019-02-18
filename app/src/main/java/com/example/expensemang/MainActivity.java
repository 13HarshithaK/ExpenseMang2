package com.example.expensemang;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
public FragmentManager fragmentManager;
public FragmentTransaction ft;
public Fragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = this.getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.add(R.id.LayoutFrame, new Home2Fragment());
        ft.commit(); // save the changes

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id==R.id.action_addexp){
//            Toast.makeText(MainActivity.this,"Select from all sections",Toast.LENGTH_SHORT).show();
            fragmentManager = this.getSupportFragmentManager();
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.LayoutFrame, new AddExp());
            ft.addToBackStack(null).commit();

        }
        else if(id==R.id.action_addinc){
            fragmentManager = this.getSupportFragmentManager();
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.LayoutFrame, new AddInc());
            ft.addToBackStack(null).commit();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle bundle = new Bundle();

        if (id == R.id.nav_home) {
            fragmentManager = this.getSupportFragmentManager();
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.LayoutFrame, new Home2Fragment());
            ft.addToBackStack(null).commit();

        } else if (id == R.id.nav_bud) {
            fragmentManager = this.getSupportFragmentManager();
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.LayoutFrame, new Budget());
            ft.addToBackStack(null).commit();

        } else if (id == R.id.nav_dcc) {
            fragmentManager = this.getSupportFragmentManager();
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.LayoutFrame, new GenBreakup());
            ft.addToBackStack(null).commit();

        }  else if (id == R.id.nav_cat) {
            fragmentManager = this.getSupportFragmentManager();
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.LayoutFrame, new Category());
            ft.addToBackStack(null).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
