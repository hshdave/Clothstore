package com.a1694158.harshkumar.clothstore;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClothList extends AppCompatActivity {

    ArrayList<Clothes> arraycls;

    ListView lstv;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Clothes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_list);

        lstv =  (ListView) findViewById(R.id.lst_cloth);

        arraycls =  new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {

                    String nm = ds.child("Name").getValue().toString();
                    String url = ds.child("Url").getValue().toString();

                    arraycls.add(new Clothes(nm,url));
                }

                ClothListAdapter adapter = new ClothListAdapter(arraycls,ClothList.this);

                lstv.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
