package Utils;

/**
 * Created by Mr.Chen on 2017/8/20.
 */
public class User {
    private String name;
    private int imageId;

    public User(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
