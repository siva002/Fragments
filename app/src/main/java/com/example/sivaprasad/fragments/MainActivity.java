package com.example.sivaprasad.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("ONFRAGMENT","On Fragment Interaction Listener");
    }

    public void onClickFragment1(View view) {
        fragment1 = new Fragment1();

        if (findViewById(R.id.main_layout) != null) {
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack("Fragment 1");
            fragmentTransaction.replace(R.id.fragment1, fragment1);
            fragmentTransaction.commit();
        }


    }

    public void onClickFragment2(View view) {


        fragment2 = new Fragment2();

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2, fragment2);
        fragmentTransaction.addToBackStack("Fragment 2");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }



}
