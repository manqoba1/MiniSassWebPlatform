package com.sifiso.codetribe.dvs.doctorlib.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sifiso.codetribe.dvs.doctorlib.R;
import com.sifiso.codetribe.dvs.doctorlib.adapter.PatientAdapter;
import com.sifiso.codetribe.dvs.doctorlib.dto.DoctorDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.PatientfileDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.RequestDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.ResponseDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.VisitDTO;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PatientFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PatientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "doctor";
    private static final String ARG_PARAM2 = "response";


    // TODO: Rename and change types of parameters
    private DoctorDTO doctor =new DoctorDTO();
    private ResponseDTO response = new ResponseDTO();
    private ListView FP_list;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment= new  PatientFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PatientFragment newInstance(ResponseDTO response) {
        PatientFragment fragment = new PatientFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, response);
        fragment.setArguments(args);
        return fragment;
    }

    public PatientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = getActivity().getApplicationContext();
        if (getArguments() != null) {
            response = (ResponseDTO) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    View v;
    PatientAdapter patientAdapter;
    private Context ctx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_patient, container, false);
        FP_list = (ListView) v.findViewById(R.id.FP_list);
        if (response != null) {
            patientAdapter = new PatientAdapter(ctx, R.layout.patient_view, response.getDoctor().getPatientfileList(), new PatientAdapter.PatientfileAdapterListener() {
                @Override
                public void onPatientfileData(PatientfileDTO patientfile) {

                }
            });
            FP_list.setAdapter(patientAdapter);
        }
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(PatientfileDTO patient) {
        if (mListener != null) {
            mListener.onFragmentInteraction(patient);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(PatientfileDTO uri);
    }

}
