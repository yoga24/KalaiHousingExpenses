package com.cyorg.example.kalaihousingexpenses;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toolbar;

import com.cyorg.example.kalaihousingexpenses.activity.ExpensesActivity;
import com.cyorg.example.kalaihousingexpenses.fragments.LoginFragment;
import com.cyorg.example.kalaihousingexpenses.fragments.MainFragment;
import com.cyorg.example.kalaihousingexpenses.fragments.SuccessFragment;
import com.firebase.client.Firebase;

public class MainActivity extends Activity {

    private FragmentManager fragmentManager;

    private Firebase mRef;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.fragment_main);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_pref_name),MODE_PRIVATE);
        boolean isUserLoggedIn = sharedPreferences.getBoolean(getString(R.string.pref_login_check_key),false);


        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();

        if(!isUserLoggedIn) {
            fragmentTransaction.add(R.id.main_container, loginFragment, "LOGIN_FRAG");
        }   else    {
            //fragmentTransaction.add(R.id.main_container, new MainFragment(), "MAIN_FRAG");
                fragmentTransaction.remove(loginFragment);
                startActivity(new Intent(MainActivity.this, ExpensesActivity.class));
        }
        fragmentTransaction.commit();


//        final List<String> users = new ArrayList<>();
//
//
//        listView = (ListView) findViewById(R.id.frag_main_list_view);
        //final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item,R.id.list_item_text,users);
        //listView.setAdapter(adapter);



//        mRef = new Firebase("https://kalai-housing-expenses.firebaseio.com/").child("users");

//        User user = new User();
//        user.setUsername("dummyUser2");
//        user.setPassword("dummyPwd2");
//        user.setAdminApproved(false);
//        user.setAccessLevel(User.READ_ACCESS_LEVEL);
//
//        mRef.push().setValue(user);


        //Using a Custom EventListener
//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                try {
//
//
//                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                        User expense = ds.getValue(User.class);
//                        users.add(expense.getUsername());
//                    }
//                    adapter.notifyDataSetChanged();
//                    Log.i("FIREBASE_DATA", "***Expense Users List Size -> " + users.size());
//                }catch(Exception e){
//                    Log.e("MODEL_ERROR","Error Occurred while mapping to model");
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Log.e("FIREBASE",firebaseError.getMessage());
//            }
//        });


        //Using Firebase UI Adapter
//        Log.i("MainAct","Getting FireBase Ref");
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
//        Query qRef = ref.orderByChild("username");
//        if(ref == null)    {
//            Log.i("MainAct","Unable to get Reference");
//        }   else    {
//            Log.i("MainAct","Database Reference has been set");
//            try {
//                Log.i("MainAct", "KEY ---> " + ref.getKey());
//            }catch(Exception e) {
//                Log.e("MainAct","Exception Occurred -->" + e.getMessage());
//            }
//        }
//
//
//        FirebaseListAdapter<User> firebaseAdapter = new FirebaseListAdapter<User>(this,User.class,R.layout.list_item,qRef) {
//            @Override
//            protected void populateView(View v, User model, int position) {
//                Log.i("MainAct","Populating View");
//                TextView textView = (TextView) v.findViewById(R.id.list_item_text);
//                textView.setText(model.getUsername());
//
//            }
//        };
//
//        listView.setAdapter(firebaseAdapter);
    }
}
