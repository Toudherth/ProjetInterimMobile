/**
 * MAD PROJECT 2021
 * Y2-S2
 * @author IT20133290 R.M.Isuru Sahan Kumarasingha
 */
package com.example.myapplication.database;

import com.example.myapplication.util.Common.CommonConstants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Connection {

    private DatabaseReference ref;

    public Connection(){
        ref = FirebaseDatabase.getInstance(CommonConstants.FIREBASE_URL_1).getReference();

    }


    public DatabaseReference getRef() {
        return ref;
    }

    public void setRef(DatabaseReference ref) {
        this.ref = ref;
    }



}
