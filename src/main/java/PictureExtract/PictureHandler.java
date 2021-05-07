package PictureExtract;

import PictureExtract.Extract.ExtractToFile;
import PictureExtract.JPG.JPGPicture;

import java.util.ArrayList;

public class PictureHandler
{
    private Picture picture;
    private String id;
    private int idx;
    private ExtractToFile extracttofile = null;

    public PictureHandler(String filename, String id, int idx)
    {
        this.picture = new JPGPicture(filename);
        this.id = id;
        this.idx = idx;
    }

    public void ExtractFullMetaData()
    {
        extractFileWrite(this.picture.getFullMetaData());
    }

    public void ExtractCoreMetaData()
    {
        extractFileWrite(this.picture.getCoreMetaData());
    }

    @Override
    public String toString() {
        return "PictureHandler{" +
                "picture=" + picture +
                '}';
    }

    private void extractFileCheck()
    {
        if (this.extracttofile == null)
            extracttofile = new ExtractToFile(this.picture.getFilename(), this.id, this.idx);
    }

    private void extractFileWrite(ArrayList<String> data)
    {
        extractFileCheck();
        this.extracttofile.FileWrite(data);
    }

}
