package com.cyorg.example.kalaihousingexpenses.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.cyorg.example.kalaihousingexpenses.R;
import com.cyorg.example.kalaihousingexpenses.fragments.LabourExpensesFragment;
import com.cyorg.example.kalaihousingexpenses.fragments.MaterialExpensesFragment;

/**
 * Created by HCL on 12/4/2016.
 */
public class ExpensesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private final String LOG_TAG = ExpensesActivity.class.getSimpleName();
    FragmentManager fragmentManager;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        toolbar = (Toolbar) findViewById(R.id.expenses_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.expenses_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.expenses_navigation_view);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        //Get Fragment Manager fot the current activity. This will be used later for loading other fragments in the same container.
        fragmentManager = getFragmentManager();

        //Add MaterialExpenses Fragment as Initial
        Log.i(LOG_TAG,"Loading initial fragment - Material Expenses");
        fragmentManager.beginTransaction().replace(R.id.expenses_container,new MaterialExpensesFragment()).addToBackStack(MaterialExpensesFragment.FRAGMENT_TAG).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())   {
            case R.id.navigation_expenses_material:
                fragmentManager.beginTransaction().replace(R.id.expenses_container,new MaterialExpensesFragment()).addToBackStack(MaterialExpensesFragment.FRAGMENT_TAG).commit();
                return true;

            case R.id.navigation_expenses_labour:
                fragmentManager.beginTransaction().replace(R.id.expenses_container,new LabourExpensesFragment()).addToBackStack(LabourExpensesFragment.FRAGMENT_TAG).commit();
                return true;

            case R.id.navigation_expenses_all:
                Log.i(LOG_TAG, "All Expenses Fragment needs to be called");
                return false;
        }

        return false;
    }
}
