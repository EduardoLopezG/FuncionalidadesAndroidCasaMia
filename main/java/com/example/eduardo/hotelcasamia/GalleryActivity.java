package com.example.eduardo.hotelcasamia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class GalleryActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private GalleryAdapter galleryAdapter;
    private List<Gallery> galleryList = new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        initData();//<----
        mTitle = (TextSwitcher)findViewById(R.id.title);//<-----
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(GalleryActivity.this);
                TextView txt = (TextView)inflater.inflate(R.layout.layout_title,null);
                return txt;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_buttom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        /* Set AdapterCoverFlow */
        galleryAdapter = new GalleryAdapter(galleryList,this);
        coverFlow = (FeatureCoverFlow)findViewById(R.id.coverFlow);
        coverFlow.setAdapter(galleryAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(galleryList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });
    }//End "onCreate"

    /* Create this method */
    private void initData() {
        galleryList.add(new Gallery("Noria Hotel CasaMia","https://78.media.tumblr.com/e6d3e33a4976ed613e986be323fdbbfa/tumblr_p5prsvS2ur1x9ezg5o1_1280.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/2d3e7d3aa81063756f4cf05d29c633b2/tumblr_p5ps3rRARi1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/3a21a49e9af684a25dd8fa5f4ab2c29c/tumblr_p5ps9wkiGK1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/54a600b0fab927b0e4159ef47eda54b9/tumblr_p5psayRaaL1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/b9923e37733a1bc9815aa6b374700bec/tumblr_p5psbugRol1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/c738fdbe3cc06556e6d2a8213402420a/tumblr_p5psciGAzb1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/f85f6aed8aef4db4664c70bbd50aa54e/tumblr_p5psdbfkKz1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/a18e8df4559444a8a14642709212bcba/tumblr_p5psduWs4t1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/a1976d007caac6e14c4123fa69d0aa80/tumblr_p5psepGJ0z1x9ezg5o1_540.jpg"));
        galleryList.add(new Gallery("Fotografía","https://78.media.tumblr.com/91e88d9ed5d7be6cc9ef51a048127016/tumblr_p5psfbTQPA1x9ezg5o1_540.jpg"));
    }
}//End Class
