package id.univmulia.tipstech;

public class Upload {
    private String imgTitle;
    private String imgDesc;
    private String imgUrl;

    public Upload() {
    }

    public Upload(String imgTitle,String imgDesc, String imgUrl) {
        if(imgTitle.trim().equals("") || imgDesc.trim().equals(""))
        {
            imgTitle="Please Fill Text Below";
        }
        this.imgTitle = imgTitle;
        this.imgDesc = imgDesc;
        this.imgUrl = imgUrl;
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
