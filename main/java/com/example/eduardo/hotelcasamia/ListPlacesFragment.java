package com.example.eduardo.hotelcasamia;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ListPlacesFragment extends Fragment {

    ArrayList<PlacesVO> listPlaces;
    RecyclerView recyclerPlaces;

    Activity activity;
    IComunicationFragments interfaceComunicaFragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_places, container, false);
        listPlaces = new ArrayList<>();
        recyclerPlaces = (RecyclerView) view.findViewById(R.id.recyclerId);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(getContext()));

        fullPlacesList();
        PlacesAdapter adapter =  new PlacesAdapter(listPlaces);
        recyclerPlaces.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Selecciono: "
                        +listPlaces.get(recyclerPlaces.getChildAdapterPosition(view)).getName(),Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.sendPlace(listPlaces.get(recyclerPlaces.getChildAdapterPosition(view)));
            }
        });
        return view;
    }

    /* Created this method */
    private void fullPlacesList() {
        listPlaces.add(new PlacesVO(getString(R.string.church_sedolores_name),getString(R.string.church_sedolores_short_description),getString(R.string.church_sedolores_large_description),R.drawable.churchdolores_list,R.drawable.churchdetail));
        /* Need to change */
        listPlaces.add(new PlacesVO("Museo Casa de Hidalgo","Info","12345",R.drawable.hidalgomuseum_list,R.drawable.hidalgohousedetail));
        listPlaces.add(new PlacesVO("Casa Museo José Alfredo Jiménez","Info","12345",R.drawable.josealmuseum_list,R.drawable.housejosealfredodetail));
        listPlaces.add(new PlacesVO("Museo de la Independencia","Info","12345",R.drawable.independence_list,R.drawable.independencedetail));
        listPlaces.add(new PlacesVO("Museo del vino","Info","12345",R.drawable.vinemuse_list,R.drawable.vinemuseumdetail));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicationFragments) this.activity;
        }
    }
}//End class
