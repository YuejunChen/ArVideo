package cn.easyar.samples.helloarvideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ScanFragment extends Fragment {
    private ImageView imageButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the video_item for this fragment
        View view=inflater.inflate(R.layout.fragment_scan, container, false);
        imageButton=(ImageView)view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ArActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
