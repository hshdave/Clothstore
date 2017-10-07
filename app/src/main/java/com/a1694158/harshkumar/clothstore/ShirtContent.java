package com.a1694158.harshkumar.clothstore;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ShirtContent extends AppCompatActivity {

    ImageView imgv;
    TextView txtnm;
    Spinner spn;
    EditText editnm;

    Button btn_trade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_content);


        editnm = (EditText) findViewById(R.id.edt_name);
        imgv = (ImageView) findViewById(R.id.img_cimg);
        txtnm = (TextView) findViewById(R.id.txt_name);
        spn = (Spinner) findViewById(R.id.spn_size);
        btn_trade = (Button) findViewById(R.id.btn_td);

        Intent i = getIntent();

        String nm = i.getStringExtra("name");
        String ph = i.getStringExtra("path");


        Picasso.with(ShirtContent.this).load(ph).into(imgv);
        txtnm.setText(nm);


            btn_trade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String nm2 = editnm.getText().toString();

                    System.out.println("Edit text  "+nm2);

                    if(nm2.isEmpty())
                    {
                        Toast.makeText(ShirtContent.this,"Please Enter Name of Product",Toast.LENGTH_LONG).show();
                    }
                    else {

                        Snackbar bar = Snackbar.make(findViewById(R.id.shrtcon),"Transaction Pending!", Snackbar.LENGTH_INDEFINITE);
                        bar.setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(ShirtContent.this,"Trade Cancel",Toast.LENGTH_LONG).show();
                            }
                        });
                        bar.show();
                    }

                }
            });




    }
}
