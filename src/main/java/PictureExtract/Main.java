package PictureExtract;

public class Main
{

    public static void main(String[] args)
    {
        PictureHandler  picturehandler = new PictureHandler("./Resource/test.jpg", "powerprove", 1);
        picturehandler.ExtractFullMetaData();
        picturehandler.ExtractCoreMetaData();
        System.out.println(picturehandler);
    }
}
