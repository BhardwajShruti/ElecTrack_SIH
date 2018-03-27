package com.example.android.electracksih;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class Device_Detail extends AppCompatActivity {
  Device_Fragment dvFrame = null;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                { Log.i("abb","bba");
                    dvFrame= new Device_Fragment();
                    FragmentManager fm= getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
//ft.detach(tvframe);

                    ft.replace(R.id.container, dvFrame);
                    ft.commit();
                    Log.i("a","b");

                }
                case R.id.navigation_dashboard:{ Log.i("abb","bba");
                    dvFrame= new Device_Fragment();
                    FragmentManager fm= getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
//ft.detach(tvframe);

                    ft.replace(R.id.container, dvFrame);
                    ft.commit();
                    Log.i("a","b");}

                case R.id.navigation_notifications:{ Log.i("abb","bba");
                    dvFrame= new Device_Fragment();
                    FragmentManager fm= getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
//ft.detach(tvframe);

                    ft.replace(R.id.container, dvFrame);
                    ft.commit();
                    Log.i("a","b");}

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device__detail);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
