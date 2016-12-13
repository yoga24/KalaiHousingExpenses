package com.cyorg.example.kalaihousingexpenses.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cyorg.example.kalaihousingexpenses.R;
import com.cyorg.example.kalaihousingexpenses.firebase.FirebaseRefManager;
import com.cyorg.example.kalaihousingexpenses.model.LabourExpense;
import com.cyorg.example.kalaihousingexpenses.model.MaterialExpense;
import com.cyorg.example.kalaihousingexpenses.utils.CommonUtils;
import com.firebase.ui.database.FirebaseListAdapter;

/**
 * Created by HCL on 12/4/2016.
 */
public class LabourExpensesFragment extends Fragment{

    private static final String LOG_TAG = LabourExpensesFragment.class.getSimpleName();
    public static final String FRAGMENT_TAG = LabourExpensesFragment.class.getSimpleName();

    private Activity parentActivity;

    ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            parentActivity = (Activity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i(LOG_TAG,"Initiating LabourExpense Fragment");

        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Get ListVIew from Fragment
        listView = (ListView) rootView.findViewById(R.id.frag_main_list_view);

        parentActivity.getActionBar().setTitle("Expenses");
        parentActivity.getActionBar().setSubtitle("Labour Expenses");

        //Initialize FragmentListAdapter and Populate view
        FirebaseListAdapter<LabourExpense> labourExpenseFirebaseListAdapter = new FirebaseListAdapter<LabourExpense>(getActivity(), LabourExpense.class, R.layout.list_item, FirebaseRefManager.LABOUR_REF) {
            @Override
            protected void populateView(View v, LabourExpense model, int position) {
                TextView amtText = (TextView) v.findViewById(R.id.list_amt_text);
                TextView dateText = (TextView) v.findViewById(R.id.list_date_text);

                amtText.setText(CommonUtils.formatAmountAsCurrency(model.getAmount()));
                dateText.setText(CommonUtils.getDateFromMilli(model.getDate()));
            }
        };

        listView.setAdapter(labourExpenseFirebaseListAdapter);

        return rootView;
    }

}
