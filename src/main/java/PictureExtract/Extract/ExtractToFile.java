package PictureExtract.Extract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import PictureExtract.PrintFormat;
import Util.Hash;

public class ExtractToFile
{
    private String filename;
    private String originalFilename;
    private String id;
    private int idx;

    private File file;
    //private FileWriter filewriter;

    public ExtractToFile(String originalFilename, String id, int idx)
    {
        this.originalFilename = originalFilename;
        this.id = id;
        this.idx = idx;
        FileOpen();
    }

    public boolean FileWrite(String Data)
    {
        try {
            FileWriter filewriter = new FileWriter(this.file, true);
            filewriter.write(Data);
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void FileWrite(ArrayList<String> Data)
    {
        if (Data.isEmpty())
        {
            System.out.format(PrintFormat.ErrorStringFormat,
                    this.getClass().getSimpleName(), PrintFormat.ErrorStringArrayEmpty);
        }

        try
        {
            FileWriter filewriter = new FileWriter(this.file, true);
            for (String data : Data)
                filewriter.write(data);
            filewriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    private void FileOpen()
    {
        this.file = new File(ExtractInfo.DefaultPath +
                "/" + Hash.getMd5(this.originalFilename + this.id + this.idx));
    }


}
