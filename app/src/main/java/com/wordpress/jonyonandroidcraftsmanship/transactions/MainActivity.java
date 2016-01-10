package com.wordpress.jonyonandroidcraftsmanship.transactions;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
    }

    public void addFirst(View view) {
        FirstFragment firstFragment = new FirstFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.llFragmentContainer, firstFragment, getString(R.string.first_tag));
        fragmentTransaction.commit();
    }

    public void removeFirst(View view) {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag(getString(R.string.first_tag));
        if (firstFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(firstFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, R.string.message, Toast.LENGTH_LONG).show();
        }
    }

    public void replaceFirst(View view) {
        SecondFragment secondFragment = new SecondFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.llFragmentContainer, secondFragment, getString(R.string.second_tag));
        fragmentTransaction.commit();
    }

    public void addSecond(View view) {
        SecondFragment secondFragment = new SecondFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.llFragmentContainer, secondFragment, getString(R.string.second_tag));
        fragmentTransaction.commit();
    }

    public void removeSecond(View view) {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag(getString(R.string.second_tag));
        if (secondFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(secondFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, R.string.message, Toast.LENGTH_LONG).show();
        }
    }

    public void replaceSecond(View view) {
        FirstFragment firstFragment = new FirstFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.llFragmentContainer, firstFragment, getString(R.string.first_tag));
        fragmentTransaction.commit();
    }

    public void attachFirst(View view) {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag(getString(R.string.first_tag));
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (firstFragment != null) {
            fragmentTransaction.attach(firstFragment);
            fragmentTransaction.commit();
        }
    }

    public void detachFirst(View view) {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag(getString(R.string.first_tag));
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (firstFragment != null) {
            fragmentTransaction.detach(firstFragment);
            fragmentTransaction.commit();
        }
    }
}
