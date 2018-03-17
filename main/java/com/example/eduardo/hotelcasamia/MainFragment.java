package com.example.eduardo.hotelcasamia;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {

    private Button btnMeetUs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /* Buttons of Main Screen */

        /* Button Meet Us */
        btnMeetUs = getView().findViewById(R.id.btn_MeetUs);
        btnMeetUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMeetUs = new Intent(getActivity(), GalleryActivity.class);
                startActivity(intentMeetUs);
            }
        });
    }
}//End class
