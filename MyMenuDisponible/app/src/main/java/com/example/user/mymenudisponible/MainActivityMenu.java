package com.example.user.mymenudisponible;


import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityMenu extends AppCompatActivity {

    private String TAG = "Main";

    private TypedArray images;
    private ImageView itemImage;
    TextView precio;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        final Menu[] menus = new Menu[5];
        menus[0] = (new Menu(0.0, getResources().getIntArray(R.array.object_array)[0]));
        menus[1] = (new Menu(7.50, getResources().getIntArray(R.array.object_array)[0]));
        menus[2] = (new Menu(14.50, getResources().getIntArray(R.array.object_array)[1]));
        menus[3] = (new Menu(8.50, getResources().getIntArray(R.array.object_array)[2]));
        menus[4] = (new Menu(20.00, getResources().getIntArray(R.array.object_array)[3]));

        try {

            images = getResources().obtainTypedArray(R.array.object_image);

            itemImage = (ImageView) findViewById(R.id.imageView);

            final Spinner spinner = (Spinner) findViewById(R.id.spinner);

            precio = (TextView) findViewById(R.id.txv_precio);

            ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.object_array, R.layout.support_simple_spinner_dropdown_item);
            spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {

                        itemImage.setImageResource(images.getResourceId(spinner.getSelectedItemPosition(), -1));

                        precio.setText(String.valueOf(menus[position].precio));


                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "No se pudo cargar la imagen", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

           /* spinner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.drawable.ajigallina:
                            precio.setText("7.00 S/.");
                            break;
                        case R.drawable.arrozmarisco:
                            precio.setText("15.00 S/.");
                            break;
                        case R.drawable.arrozpollo:
                            precio.setText("9.00 S/.");
                            break;
                        case R.drawable.ceviche:
                            precio.setText("20.00 S/.");
                            break;
                    }
                }
            });
            */

            Log.v(TAG, "Ejecución OK");
        } catch (Exception e) {

            Log.e(TAG, "Error en en inicio de la aplicacion");
        }


    }
}


/*
        switch (view.getId()) {
        case R.drawable.ajigallina:
        precio.setText("7.00 S/.");
        break;
        case R.drawable.arrozmarisco:
        precio.setText("15.00 S/.");
        break;
        case R.drawable.arrozpollo:
        precio.setText("9.00 S/.");
        break;
        case R.drawable.ceviche:
        precio.setText("20.00 S/.");
        break;
        }
*/