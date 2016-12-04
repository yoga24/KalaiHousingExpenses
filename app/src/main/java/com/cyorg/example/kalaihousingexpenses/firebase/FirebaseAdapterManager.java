package com.cyorg.example.kalaihousingexpenses.firebase;

import android.view.View;

import com.cyorg.example.kalaihousingexpenses.activity.ExpensesActivity;
import com.cyorg.example.kalaihousingexpenses.model.LabourExpense;
import com.cyorg.example.kalaihousingexpenses.model.MaterialExpense;
import com.firebase.ui.database.FirebaseListAdapter;

/**
 * Created by Yoganand on 12/4/2016.
 */
public class FirebaseAdapterManager {

    private static FirebaseListAdapter<LabourExpense> labourExpenseFirebaseListAdapter;
    private static FirebaseListAdapter<MaterialExpense> materialExpenseFirebaseListAdapter;

    public static void initializeListAdapters()  {
//        try {
//            labourExpenseFirebaseListAdapter = new FirebaseListAdapter<LabourExpense>(ExpensesActivity.) {
//                @Override
//                protected void populateView(View v, LabourExpense labourExpense, int position) {
//
//                }
//            };
    }

}
