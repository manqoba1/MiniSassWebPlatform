package com.sifiso.codetribe.dvs.doctorapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sifiso.codetribe.dvs.doctorlib.adapter.PagerAdapter;
import com.sifiso.codetribe.dvs.doctorlib.dto.PatientfileDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.RequestDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.ResponseDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.VisitDTO;
import com.sifiso.codetribe.dvs.doctorlib.fragment.PatientFragment;
import com.sifiso.codetribe.dvs.doctorlib.fragment.VisitFragment;
import com.sifiso.codetribe.dvs.doctorlib.toolbox.BaseVolley;
import com.sifiso.codetribe.dvs.doctorlib.util.Statics;
import com.sifiso.codetribe.dvs.doctorlib.util.ToastUtil;
import com.sifiso.codetribe.dvs.doctorlib.util.WebSocketUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements PatientFragment.OnFragmentInteractionListener, VisitFragment.OnFragmentInteractionListener {
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mPager = (ViewPager) findViewById(R.id.pager);
        // pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pager_title_strip);
    }

    private int doctorID;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        doctorID = sp.getInt("doctorID", 0);
        getDoctorData(doctorID);
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

    private void build() {
        fragmentList = new ArrayList<Fragment>();
        Bundle data = new Bundle();
        data.putSerializable("response", response);

        visitFragment = new VisitFragment();
        visitFragment.setArguments(data);

        patientFragment = new PatientFragment();
        patientFragment.setArguments(data);

        fragmentList.add(visitFragment);
        fragmentList.add(patientFragment);

        initializeAdapter();
    }

    private void initializeAdapter() {
        adapter = new PagerAdapter(getSupportFragmentManager(), fragmentList);

        mPager.setAdapter(adapter);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                currentPageIndex = arg0;

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    public void setRefreshActionButtonState(final boolean refreshing) {
        if (mMenu != null) {
            final MenuItem refreshItem = mMenu.findItem(R.id.action_refresh);
            if (refreshItem != null) {
                if (refreshing) {
                    refreshItem.setActionView(R.layout.action_bar_progess);
                } else {
                    refreshItem.setActionView(null);
                }
            }
        }
    }

    private void getDoctorData(int doctorID) {
        RequestDTO w = new RequestDTO();
        w.setRequestType(RequestDTO.GET_DOCTOR_DATA);
        w.setDoctorID(doctorID);


        if (!BaseVolley.checkNetworkOnDevice(ctx)) {
            return;
        }
        setRefreshActionButtonState(true);
        WebSocketUtil.sendRequest(ctx, Statics.DVS_ENDPOINT, w, new WebSocketUtil.WebSocketListener() {
            @Override
            public void onMessage(final ResponseDTO r) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        response = r;
                        setRefreshActionButtonState(false);
                        build();

                    }
                });

            }

            @Override
            public void onClose() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setRefreshActionButtonState(false);
                        ToastUtil.errorToast(ctx, "Please Check Your Network Connectivity");
                    }
                });
            }

            @Override
            public void onError(final String message) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setRefreshActionButtonState(false);
                        ToastUtil.errorToast(ctx, message);
                    }
                });
            }
        });
    }

    ViewPager mPager;
    PagerTitleStrip pagerTitleStrip;
    Menu mMenu;
    ResponseDTO response;
    int currentPageIndex;
    PagerAdapter adapter;
    private List<Fragment> fragmentList;
    Context ctx;

    VisitFragment visitFragment;
    PatientFragment patientFragment;

    @Override
    public void onFragmentInteraction(VisitDTO uri) {

    }

    @Override
    public void onFragmentInteraction(PatientfileDTO uri) {

    }
}
