package PictureExtract.Patch;

import java.io.File;

abstract public class FilePatcher
{
    private File file;

    public FilePatcher(File file)
    {
        this.file = file;
    }

    public File getFile()
    {
        return this.file;
    }

    abstract public void CRCWrite(String CRCdata);
}
