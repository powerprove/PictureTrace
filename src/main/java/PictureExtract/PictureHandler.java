package PictureExtract;

public class PictureHandler
{
    private Picture picture;

    public PictureHandler(String filename)
    {
        this.picture = new JPGPicture(filename);
    }

    public void PictureExtract()
    {
        this.picture.fileExtract();
    }

    @Override
    public String toString() {
        return "PictureHandler{" +
                "picture=" + picture +
                '}';
    }
}
