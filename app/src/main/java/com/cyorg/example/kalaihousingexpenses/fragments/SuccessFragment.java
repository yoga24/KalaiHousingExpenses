package com.cyorg.example.kalaihousingexpenses.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cyorg.example.kalaihousingexpenses.R;

/**
 * Created by HCL on 12/3/2016.
 */
public class SuccessFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =  inflater.inflate(R.layout.fragment_success,container,false);

        TextView welcomeText = (TextView) rootView.findViewById(R.id.welcome_text);


        welcomeText.setText("Welcome "+getActivity().getSharedPreferences(getString(R.string.shared_pref_name), Context.MODE_PRIVATE).getString(getString(R.string.pref_logged_in_user_key),"User"));

        return rootView;
    }
}
