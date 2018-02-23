package cn.easyar.samples.helloarvideo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import Utils.Video;
import Utils.VideoAdapter;

public class HomeFragment extends Fragment {
    private SearchView mSearchView;
    private List<Video> videoList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the video_item for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        mSearchView=(SearchView)view.findViewById(R.id.searchView);
        initVideo();
        VideoAdapter adapter = new VideoAdapter(getActivity(), R.layout.video_item, videoList);
        ListView listView = (ListView)view. findViewById(R.id.videoList);
        listView.setAdapter(adapter);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;
    }
    public void initVideo(){
        Video collection = new Video("语文", R.drawable.collection);
        videoList.add(collection);
        Video setting = new Video("数学", R.drawable.seeting);
        videoList.add(setting);
        Video insurance = new Video("英语", R.drawable.connection);
        videoList.add(insurance);
    }
}