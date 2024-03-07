package com.example.app_valorant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.app_valorant.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new TabelaFragment());

        binding.bottomNavigationView.setOnItemReselectedListener(item ->{

            switch (item.getItemId()){

                case R.id.Tabela:
                    replaceFragment(new TabelaFragment());
                    break;
                case R.id.Cronograma:
                    replaceFragment(new CronogramaFragment());
                    break;
                case R.id.Noticias:
                    replaceFragment(new NoticiasFragment());
                    break;
                case R.id.Times:
                    replaceFragment(new TimesFragment());
                    break;
                case R.id.Jogadores:
                    replaceFragment(new JogadoresFragment());
                    break;


            }


            return true;
        } );

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}