package com.sifiso.codetribe.dvs.doctorapp;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.sifiso.codetribe.dvs.doctorlib.dto.RequestDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.ResponseDTO;
import com.sifiso.codetribe.dvs.doctorlib.toolbox.BaseVolley;
import com.sifiso.codetribe.dvs.doctorlib.util.Statics;
import com.sifiso.codetribe.dvs.doctorlib.util.ToastUtil;
import com.sifiso.codetribe.dvs.doctorlib.util.WebSocketUtil;

import java.util.ArrayList;


public class Login extends Activity {
    private AutoCompleteTextView L_spinnerEmail;
    private EditText L_password;
    private Button L_login;
    Context ctx;
    private String email;
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ctx = getApplicationContext();
    }

    private void checkVirginity() {
        //ed.clear().commit();
        int doctorID = sp.getInt("doctorID", 0);
        if (doctorID > 0) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
    }

    private void build() {
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ed = sp.edit();
        L_spinnerEmail = (AutoCompleteTextView) findViewById(R.id.L_spinnerEmail);
        L_password = (EditText) findViewById(R.id.L_password);
        L_login = (Button) findViewById(R.id.L_login);


    }

    private View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            email = L_spinnerEmail.getText().toString();
            Log.i(LOG, email + "  " + L_password.getText().toString());
            userLogIn(email, L_password.getText().toString());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static String LOG = Login.class.getSimpleName();
    Gson gson = new Gson();

    private void userLogIn(String email, String password) {
        if (!BaseVolley.checkNetworkOnDevice(ctx)) {
            return;
        }

        RequestDTO r = new RequestDTO();
        r.setRequestType(RequestDTO.LOGIN_DOCTOR);
        r.setPin(password);
        r.setEmail(email);
        Log.d(LOG, "**** Stupid ****" + password + " " + email);
        try {
            WebSocketUtil.sendRequest(ctx, Statics.DVS_ENDPOINT, r, new WebSocketUtil.WebSocketListener() {
                @Override
                public void onMessage(ResponseDTO r) {
                    if (r.getStatusCode() == 0) {
                        ed.putInt("doctorID", r.getDoctor().getDoctorID());
                        ed.putString("email", r.getDoctor().getEmail());
                        ed.putString("doctor", gson.toJson(r.getDoctor()));
                        ed.commit();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("doctor", r.getDoctor());
                        startActivity(intent);
                        finish();
                    }
                }

                @Override
                public void onClose() {

                }

                @Override
                public void onError(String message) {

                }
            });
        } catch (Exception e) {
            Log.d(LOG, "**** Stupid ****", e);
        }
    }

    public void getEmail() {
        AccountManager am = AccountManager.get(getApplicationContext());
        Account[] accts = am.getAccounts();
        if (accts.length == 0) {
            //TODO - send user to create acct
            ToastUtil.errorToast(ctx, "No Accounts found. Please create one and try again");
            finish();
            return;
        }
        if (accts.length == 1) {
            email = accts[0].name;
            L_spinnerEmail.setVisibility(View.GONE);
            return;
        }
        final ArrayList<String> tarList = new ArrayList<String>();
        if (accts != null) {

            for (int i = 0; i < accts.length; i++) {
                tarList.add(accts[i].name);
            }

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    R.layout.xsimple_spinner_item, tarList);
            dataAdapter
                    .setDropDownViewResource(R.layout.xsimple_spinner_dropdown_item);
            L_spinnerEmail.setAdapter(dataAdapter);
            L_spinnerEmail
                    .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            email = tarList.get(position);
                        }
                    });

        }
    }
}
