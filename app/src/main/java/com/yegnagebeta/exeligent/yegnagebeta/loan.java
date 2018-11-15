package com.yegnagebeta.exeligent.yegnagebeta;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yegnagebeta.exeligent.yegnagebeta.Adapter.MyAdapter;
import com.yegnagebeta.exeligent.yegnagebeta.Adapter.MyRechargeAdapter;

import java.util.ArrayList;

/**
 * Created by Ghost on 12/16/2017.
 */

public class loan extends Fragment {

    View rootView;
    ArrayList<String> titleAmh=new ArrayList<>();
    ArrayList<String> titleEn=new ArrayList<>();
    ArrayList<String> desc=new ArrayList<>();
    ArrayList<Integer>iconsId= new ArrayList<>();
    ArrayList<Integer>arrowId=new ArrayList<>();



    FloatingActionButton fab;
//    MainActivity m = new MainActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.loan, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.loan_recyclerview);


        titleAmh.add("የምሽት loan");
        titleAmh.add("የምሽት loan");
        titleAmh.add("የምሽት loan");
        titleAmh.add("የምሽት loan");

        titleEn.add("night Package");
        titleEn.add("night Package");
        titleEn.add("night Package");
        titleEn.add("night Package");

        iconsId.add(R.drawable.ic_night);
        iconsId.add(R.drawable.ic_night);
        iconsId.add(R.drawable.ic_night);
        iconsId.add(R.drawable.ic_night);





        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyRechargeAdapter adapter =new MyRechargeAdapter(getContext(),titleAmh,titleEn,iconsId);
        recyclerView.setAdapter(adapter);



        return rootView;
    }


    private Uri ussdtocallable(String ussd) {

        String uriStirng = "";

        if (!ussd.startsWith("tel: "))
            uriStirng +="tel:";
        for(char c: ussd.toCharArray()){
            if(c=='#')
                uriStirng+=Uri.encode("#");
            else
                uriStirng +=c;
        }
        return Uri.parse(uriStirng);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:

                try{
                    if (resultCode== Activity.RESULT_OK) {
                        Uri contactData = data.getData();

                        Cursor c = getContext().getContentResolver().query(contactData, null, null, null, null);
                        c.moveToFirst();


                        String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                        int phoneNumIndx = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        String phoneNum = c.getString(phoneNumIndx);
                        if (name == null) {
                            name = "No Name";

                        }



                        //Phone.setText(phoneNum);
                        Toast.makeText(getContext(),name+": "+phoneNum,Toast.LENGTH_SHORT).show();


                        c.close();

                    }
                }catch(Exception e){
                    Log.e("Error",e.getMessage());

                }

                break;
        }
    }


}

