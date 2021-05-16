package PictureExtract.JPG;

import PictureExtract.Patch.FilePatcher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JPGPatcher extends FilePatcher
{

    public JPGPatcher(File file)
    {
        super(file);
    }

    public void CRCWrite(String CRCdata)
    {
        try {
            FileWriter filewriter = new FileWriter(getFile().getPath(), true);
            filewriter.write(CRCdata);
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
