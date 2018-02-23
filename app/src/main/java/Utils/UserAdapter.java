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
public class UserAdapter extends ArrayAdapter<User> {

private int resourceId;

public UserAdapter(Context context, int textViewResourceId,
                   List<User> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        User order = getItem(position); // 获取当前项的User实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
        view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        viewHolder = new ViewHolder();
        viewHolder.userImage = (ImageView) view.findViewById (R.id.image);
        viewHolder.userName = (TextView) view.findViewById (R.id.name);
        view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
        view = convertView;
        viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.userImage.setImageResource(order.getImageId());
        viewHolder.userName.setText(order.getName());
        return view;
        }

class ViewHolder {
    ImageView userImage;
    TextView userName;
}

}

