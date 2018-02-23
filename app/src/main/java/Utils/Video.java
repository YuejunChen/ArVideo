package Utils;

/**
 * Created by Mr.Chen on 2017/8/20.
 */
public class Video {
    private String videoName;
    private int videoImage;

    public Video(String name, int imageId) {
        this.videoName = name;
        this.videoImage = imageId;
    }

    public String getName() {
        return videoName;
    }

    public int getImageId() {
        return videoImage;
    }
}
