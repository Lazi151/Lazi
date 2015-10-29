package com.example.michael.conversion;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView actionBarTitle = new TextView(this);
        actionBarTitle.setText("Lazi");
        actionBarTitle.setTextColor(Color.WHITE);
        ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        layout.gravity = Gravity.CENTER_HORIZONTAL;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5cb85c")));
        getSupportActionBar().setCustomView(actionBarTitle);//should add layout as second paramater


        //buttons with intents for click events
        ImageButton placeOrderButton = (ImageButton) findViewById(R.id.placeOrderButton);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent placeOrderIntent = new Intent(getApplicationContext(), ChooseStore.class);
                startActivity(placeOrderIntent);
            }
        });

        ImageButton previousOrderButton=(ImageButton) findViewById(R.id.previousOrderButton);
        previousOrderButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent previousOrderIntent = new Intent(getApplicationContext(), PastOrders.class);
                startActivity(previousOrderIntent);
            }
        });
        ImageButton facebookButton = (ImageButton) findViewById(R.id.facebookButton);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Facebook
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.facebook_url)));
                startActivity(facebookIntent);
            }
        });

        ImageButton phoneButton = (ImageButton) findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+getString(R.string.phone_number)));
                startActivity(callIntent);
            }
        });

        final ImageButton emailButton = (ImageButton) findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setType("text/plain");
                emailIntent.setData(Uri.parse("mailto:"+getString(R.string.email)));
                startActivity(emailIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


