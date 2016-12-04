package com.cyorg.example.kalaihousingexpenses.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Yoganand on 12/4/2016.
 * class FirebaseRefManager
 * Provides Database References needed for firebase db.
 */
public class FirebaseRefManager {

    public static final DatabaseReference MATERIAL_REF = FirebaseDatabase.getInstance().getReference().child(ExpenseConstants.FIREBASE_CHILD_MATERIAL);
    public static final DatabaseReference LABOUR_REF = FirebaseDatabase.getInstance().getReference().child(ExpenseConstants.FIREBASE_CHILD_LABOUR);
    public static final DatabaseReference USER_REF = FirebaseDatabase.getInstance().getReference().child(ExpenseConstants.FIREBASE_CHILD_USERS);

}
