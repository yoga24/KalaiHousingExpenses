package com.cyorg.example.kalaihousingexpenses.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cyorg.example.kalaihousingexpenses.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Yoganand on 12/1/2016.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.getSimpleName();

    private Activity parentActivity;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText username;
    private EditText password;

    private Button loginBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    parentActivity.getSharedPreferences(getString(R.string.shared_pref_name), Context.MODE_PRIVATE).edit().putString(getString(R.string.pref_logged_in_user_key),user.getEmail().split("@")[0]).commit();
                    callSuccessLoginFragment();
                    Log.i(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.i(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    private void callSuccessLoginFragment() {
        parentActivity.getFragmentManager().beginTransaction().replace(R.id.main_container,new MainFragment()).commit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_login,container,false);

        Log.i(TAG,"RootView created Successfully");

        username = (EditText) rootView.findViewById(R.id.loginEmail);
        password = (EditText) rootView.findViewById(R.id.loginPwd);
        loginBtn = (Button) rootView.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmptyFields())
                    Toast.makeText(parentActivity , "One or more fields are empty", Toast.LENGTH_LONG).show();
                else{
                    mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(parentActivity, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                                    if(task.isSuccessful()) {
                                        //Toast.makeText(parentActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_LONG).show();
                                        String[] user = username.getText().toString().split("@");
                                        parentActivity.getSharedPreferences(getString(R.string.shared_pref_name), Context.MODE_PRIVATE).edit().putString(getString(R.string.pref_logged_in_user_key),user[0]).commit();
                                        callSuccessLoginFragment();
                                    }

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Log.w(TAG, "signInWithEmail:failed", task.getException());
                                        Toast.makeText(parentActivity,"Login Failed",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }

//                else{
//                    Toast.makeText(parentActivity , "Success", Toast.LENGTH_LONG).show();
//                }
            }
        });

        Log.i(TAG,"Returning root view");
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity) {
            parentActivity = (Activity) context;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private boolean checkEmptyFields(){
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
            return true;
        return false;
    }
}
