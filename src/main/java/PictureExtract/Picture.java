package PictureExtract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

abstract public class Picture
{
    private String filename;
    private File file;

    public Picture(String filename)
    {
        this.filename = filename;
        fileOpen();
    }

    public void fileOpen()
    {
        this.file = new File(filename);
    }

    public boolean checkFileOpen()
    {
        if (file.isFile()) {
            return true;
        }
        return false;
    }

    public String getFilename()
    {
        return filename;
    }

    public File getFile()
    {
        if (checkFileOpen())
            return file;
        return null;
    }

    abstract public String toString();
    abstract public void extractMetadata();
    abstract public ArrayList<String> getFullMetaData();
    abstract public ArrayList<String> getCoreMetaData();
    abstract public String getMetaData(String tagName);
}
