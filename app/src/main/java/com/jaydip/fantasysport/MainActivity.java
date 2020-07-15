package com.jaydip.fantasysport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaydip.fantasysport.models.selectedContest;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    List<selectedContest> selectedContestList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Log.e("jaydip", "onActivityResult: ");
        if(resultCode == 220 ){
            selectedContest contes = (selectedContest) data.getSerializableExtra("selectedResult");
            selectedContestList.add(contes);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedContestList = new ArrayList<selectedContest>();
        final FrameLayout viewGroup = findViewById(R.id.framLayout);
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.framLayout,new HomeFrag()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.Bottom_nav_home:
                        manager.beginTransaction().replace(R.id.framLayout,new HomeFrag()).commit();
                        break;
                    case R.id.Bottom_nav_mycontest:
                        manager.beginTransaction().replace(R.id.framLayout,new ContestFrag(selectedContestList)).commit();
                        break;
                }
                return true;
            }
        });


    }
}