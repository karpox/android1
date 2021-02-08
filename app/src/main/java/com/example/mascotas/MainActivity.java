package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascota();
        inicializarAdaptador();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.menu_favoritos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascota(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Teddy", R.drawable.dog1, 0));
        mascotas.add(new Mascota("Firulais", R.drawable.dog6, 0));
        mascotas.add(new Mascota("Tobby", R.drawable.dog3, 0));
        mascotas.add(new Mascota("Solovino", R.drawable.dog7, 0));
        mascotas.add(new Mascota("Bruno", R.drawable.dog4, 0));
        mascotas.add(new Mascota("Pancho", R.drawable.dog8, 0));
        mascotas.add(new Mascota("Kaiser", R.drawable.dog5, 0));
        mascotas.add(new Mascota("Aristoteles", R.drawable.dog2, 0));



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                // User chose the "Settings" item, show the app settings UI...

                Intent intent = new Intent(this, FavoritosActivity.class);
                intent.putExtra("key", mascotas);

                startActivity(intent);

                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
