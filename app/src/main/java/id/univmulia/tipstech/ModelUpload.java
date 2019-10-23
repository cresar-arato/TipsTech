package id.univmulia.tipstech;

public class ModelUpload {
    private String imgTitle;
    private String imgDesc;
    private String imgUrl;
    private String key;

    public ModelUpload() {
    }

    public ModelUpload(String imgTitle, String imgDesc, String imgUrl) {
        if(imgTitle.trim().equals("") || imgDesc.trim().equals(""))
        {
            imgTitle="Please Fill Text Below";
        }
        this.imgTitle = imgTitle;
        this.imgDesc = imgDesc;
        this.imgUrl = imgUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
