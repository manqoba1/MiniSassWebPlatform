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
import com.sifiso.codetribe.dvs.doctorlib.adapter.VisitAdapter;
import com.sifiso.codetribe.dvs.doctorlib.dto.DoctorDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.ResponseDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.VisitDTO;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VisitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisitFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "doctor";
    private static final String ARG_PARAM2 = "response";
    private DoctorDTO doctor = new DoctorDTO();
    private ResponseDTO response = new ResponseDTO();
    private ListView FV_list;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VisitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisitFragment newInstance(ResponseDTO response) {
        VisitFragment fragment = new VisitFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, response);
        fragment.setArguments(args);
        return fragment;
    }

    public VisitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            response = (ResponseDTO) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    View v;
    Context ctx;
    VisitAdapter visitAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_visit, container, false);
        FV_list = (ListView) v.findViewById(R.id.FP_list);
        if (response != null) {
            visitAdapter = new VisitAdapter(ctx, R.layout.visit_view_custom, response.getDoctor().getVisitList(), new VisitAdapter.VisitAdapterListener() {
                @Override
                public void onVisitData(VisitDTO visit) {

                }
            });
            FV_list.setAdapter(visitAdapter);
        }
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(VisitDTO visit) {
        if (mListener != null) {
            mListener.onFragmentInteraction(visit);
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
        public void onFragmentInteraction(VisitDTO uri);
    }

}
