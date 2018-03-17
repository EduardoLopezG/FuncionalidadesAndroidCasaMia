package com.example.eduardo.hotelcasamia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPlacesFragment extends Fragment {

    TextView textDescription;
    ImageView imageDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_places, container, false);

        textDescription = (TextView) view.findViewById(R.id.descriptionId);
        imageDetail = (ImageView) view.findViewById(R.id.imageDetailId);

        Bundle objectPlace = getArguments();
        PlacesVO place = null;
        if (objectPlace!=null){
            place = (PlacesVO) objectPlace.getSerializable("object");
            imageDetail.setImageResource(place.getImageDetail());
            textDescription.setText(place.getDescription());
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}//End class
