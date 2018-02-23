package Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.easyar.samples.helloarvideo.R;

/**
 * Created by Mr.Chen on 2017/8/27.
 */
public class VideoAdapter extends ArrayAdapter<Video> {

private int resourceId;

public VideoAdapter(Context context, int textViewResourceId,
                    List<Video> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        Video video = getItem(position); // 获取当前项的User实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
        view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        viewHolder = new ViewHolder();
        viewHolder.videoImage = (ImageView) view.findViewById (R.id.video_image);
        viewHolder.videoName = (TextView) view.findViewById (R.id.video_name);
        view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
        view = convertView;
        viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.videoImage.setImageResource(video.getImageId());
        viewHolder.videoName.setText(video.getName());
        return view;
        }

class ViewHolder {
    ImageView videoImage;
    TextView videoName;
}

}

