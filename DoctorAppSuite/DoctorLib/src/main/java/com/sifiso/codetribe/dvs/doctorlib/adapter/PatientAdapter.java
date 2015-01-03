package com.sifiso.codetribe.dvs.doctorlib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sifiso.codetribe.dvs.doctorlib.R;
import com.sifiso.codetribe.dvs.doctorlib.dto.PatientfileDTO;
import com.sifiso.codetribe.dvs.doctorlib.util.Util;

import java.util.Date;
import java.util.List;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class PatientAdapter extends ArrayAdapter<PatientfileDTO> {

    public interface PatientfileAdapterListener {
        public void onPatientfileData(PatientfileDTO patientfile);
    }

    private final LayoutInflater mInflater;
    private final int mLayoutRes;
    private List<PatientfileDTO> mList;
    private Context ctx;
    private PatientfileAdapterListener listener;

    public PatientAdapter(Context context, int resource, List<PatientfileDTO> list, PatientfileAdapterListener listener) {
        super(context, resource, list);
        this.mLayoutRes = resource;
        mList = list;
        this.listener = listener;
        ctx = context;
        this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    class Holder {
        TextView PV_count, PV_stnd_no, PV_name, PV_date_made, PV_code;
    }

    Holder h;

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        h = new Holder();
        if (v == null) {
            v = mInflater.inflate(mLayoutRes, null);
            h.PV_code = (TextView) v.findViewById(R.id.PV_code);
            h.PV_count = (TextView) v.findViewById(R.id.PV_count);
            h.PV_date_made = (TextView) v.findViewById(R.id.PV_date_made);
            h.PV_name = (TextView) v.findViewById(R.id.PV_name);
            h.PV_stnd_no = (TextView) v.findViewById(R.id.PV_stnd_no);
            v.setTag(h);
        } else {
            h = (Holder) v.getTag();
        }
        final PatientfileDTO dto = mList.get(position);
        h.PV_date_made.setText(Util.getLongDateTime(new Date(dto.getDateMade())));
        h.PV_stnd_no.setText(dto.getClient().getStandNumber());
        h.PV_count.setText("" + (position + 1));
        h.PV_name.setText(dto.getClient().getSurname() + ", " + dto.getClient().getName());
        h.PV_code.setText(dto.getDoctor().getSurgery().getCode());
        animateView(v);
        return v;
    }

    public void animateView(final View view) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.grow_fade_in_center);
        a.setDuration(2500);
        if (view == null)
            return;
        view.startAnimation(a);
    }
}
