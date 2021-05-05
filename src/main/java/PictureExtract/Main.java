package PictureExtract;

public class Main
{

    public static void main(String[] args)
    {
        PictureHandler  picturehandler = new PictureHandler("./Resource/test.jpg");
        picturehandler.PictureExtract();
        System.out.println(picturehandler);
    }
}
