package com.cyorg.example.kalaihousingexpenses.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cyorg.example.kalaihousingexpenses.R;
import com.cyorg.example.kalaihousingexpenses.fragments.MaterialExpensesFragment;

/**
 * Created by HCL on 12/4/2016.
 */
public class ExpensesActivity extends AppCompatActivity {

    private final String LOG_TAG = ExpensesActivity.class.getSimpleName();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Fragment Manager fot the current activity. This will be used later for loading other fragments in the same container.
        fragmentManager = getFragmentManager();

        //Add MaterialExpenses Fragment as Initial
        fragmentManager.beginTransaction().add(R.id.main_container,new MaterialExpensesFragment(),MaterialExpensesFragment.FRAGMENT_TAG).commit();

    }
}
