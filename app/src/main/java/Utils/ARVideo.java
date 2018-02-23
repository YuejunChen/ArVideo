//================================================================================================================================
//
//  Copyright (c) 2015-2017 VisionStar Information Technology (Shanghai) Co., Ltd. All Rights Reserved.
//  EasyAR is the registered trademark or trademark of VisionStar Information Technology (Shanghai) Co., Ltd in China
//  and other countries for the augmented reality technology developed by VisionStar Information Technology (Shanghai) Co., Ltd.
//
//================================================================================================================================

package Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import cn.easyar.FunctorOfVoidFromVideoStatus;
import cn.easyar.StorageType;
import cn.easyar.VideoPlayer;
import cn.easyar.VideoStatus;
import cn.easyar.VideoType;

public class ARVideo
{
    private VideoPlayer player;
    private boolean prepared;
    private boolean found;
    private String path;
    private Context context;
    private AlertDialog.Builder builder;


    public ARVideo()
    {
        player = new VideoPlayer();
        prepared = false;
        found = false;
    }
    public ARVideo(Context videoContext)
    {
        player = new VideoPlayer();
        prepared = false;
        found = false;
        context=videoContext;
        builder= new AlertDialog.Builder(context);
        builder.setTitle("播放结束");
        builder.setMessage("您要收藏这段视频吗？");

    }
    public void dispose()
    {
        player.close();
    }

    public void openVideoFile(final String path, int texid)
    {
        this.path = path;
        player.setRenderTexture(texid);
        player.setVideoType(VideoType.Normal);
        player.open(path, StorageType.Assets, new FunctorOfVoidFromVideoStatus() {
            @Override
            public void invoke(int status) {
                setVideoStatus(path,status);
            }
        });
    }
    public void openTransparentVideoFile(String path, int texid)
    {
        this.path = path;
        player.setRenderTexture(texid);
        player.setVideoType(VideoType.TransparentSideBySide);
        player.open(path, StorageType.Assets, new FunctorOfVoidFromVideoStatus() {
            @Override
            public void invoke(int status) {
                setVideoStatus(status);
            }
        });
    }
    public void openStreamingVideo(String url, int texid)
    {
        this.path = url;
        player.setRenderTexture(texid);
        player.setVideoType(VideoType.Normal);
        player.open(url, StorageType.Absolute, new FunctorOfVoidFromVideoStatus() {
            @Override
            public void invoke(int status) {
                setVideoStatus(status);
            }
        });
    }

    public void setVideoStatus(int status)
    {
        Log.i("HelloAR", "video: " + path + " (" + Integer.toString(status) + ")");
        if (status == VideoStatus.Ready) {
            prepared = true;
            if (found) {
                player.play();
            }
        } else if (status == VideoStatus.Completed) {
            builder.show();
        }
    }
    public void setVideoStatus(final String path, int status)
    {
        Log.i("HelloAR", "video: " + path + " (" + Integer.toString(status) + ")");
        if (status == VideoStatus.Ready) {
            prepared = true;
            if (found) {
                player.play();
            }
        } else if (status == VideoStatus.Completed) {
            builder.setPositiveButton("收藏", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    Toast.makeText(context, "收藏成功"+path, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    player.play();
                }
            });
            builder.show();
        }
    }

    public void onFound()
    {
        found = true;
        if (prepared) {
            player.play();
        }
    }
    public void onLost()
    {
        found = false;
        if (prepared) {
            player.pause();
        }
    }
    public boolean isRenderTextureAvailable()
    {
        return player.isRenderTextureAvailable();
    }
    public void update()
    {
        player.updateFrame();
    }

    public void replay(){player.seek(0);}

    public void  pause(){player.pause();}

    public void  play(){player.play();}
}
