package com.happytrees.searchlocations;

import com.orm.SugarRecord;


//DONT USE LATLNG CAUSE SUGAR ORM DOESNT KNOW HOW TO DEAL WITH IT --> USE LATITUDE AND LONGITUDE VARIABLES INSTEAD
public class SearchedLocation extends SugarRecord {//name of this java class will be name of table saved inside sugar orm database

String name;
String address;
double latitude;
double longitude;
//photo of place yet to come
    //destination from current location yet to come

    //required empty constructor
    public SearchedLocation() {
    }

}
