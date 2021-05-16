package PictureExtract;

public class Main
{

    public static void main(String[] args)
    {
        //PictureHandler  picturehandler = new PictureHandler("./Resource/test.jpg", "powerprove", 1);
        PictureHandler  picturehandler = new PictureHandler(args[0], args[1], Integer.parseInt(args[2]));
        picturehandler.ExtractFullMetaData();
        picturehandler.ExtractCoreMetaData();
        System.out.println(picturehandler);
        picturehandler.encryptFile();
    }
}
