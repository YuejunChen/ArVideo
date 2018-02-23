package cn.easyar.samples.helloarvideo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Utils.User;
import Utils.UserAdapter;

public class MeFragment extends Fragment {
    private List<User> userList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the video_item for this fragment
        View view= inflater.inflate(R.layout.fragment_me, container, false);
        initCase();
        UserAdapter adapter = new UserAdapter(getActivity(), R.layout.info_item, userList);
        ListView listView = (ListView)view. findViewById(R.id.listView);
        listView.setAdapter(adapter);
        return view;
    }

    public void initCase(){
        User collection = new User("收藏", R.drawable.collection);
        userList.add(collection);
        User setting = new User("设置", R.drawable.seeting);
        userList.add(setting);
        User insurance = new User("联系我们", R.drawable.connection);
        userList.add(insurance);

    }
}
