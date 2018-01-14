package com.happytrees.searchlocations;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //SUGAR ORM --> YET TO COME///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int PLACE_PICKER_REQUEST = 1;
    Button btnPlacePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlacePicker = (Button) findViewById(R.id.btnPlacePicker);
        btnPlacePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PLACE PICKER -->  provides a UI dialog that displays an interactive map with list of nearby places and search box with suggestions
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(MainActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //RESULT OF PLACE PICKER
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);

                String toastName = String.format("Place: %s", place.getName());//get place name
                String toastAddress = String.format("Address: %s", place.getAddress());//get place address
                LatLng location = place.getLatLng();//get place LatLng
                double lat = location.latitude;
                double lng = location.longitude;
                //PICTURE YET TO COME
                //DESTINATION YET TO COME
            }
        }
    }
}
