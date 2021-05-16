package PictureExtract;

import PictureExtract.Extract.ExtractToFile;
import PictureExtract.JPG.JPGPicture;
import PictureExtract.Patch.PatchFile;
import PictureExtract.Patch.PatchInfo;


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
        this.extractFileCheck();
    }

    public void ExtractFullMetaData()
    {
        this.extracttofile.FullFileWrite(this.picture.getFullMetaData());
    }

    public void ExtractCoreMetaData()
    {
        this.extracttofile.CoreFileWrite(this.picture.getCoreMetaData());
    }

    public void encryptFile()
    {
        PatchFile encryptfile = new PatchFile(PatchInfo.DefaultPath + "/" + this.picture.getFile().getName()
                ,this.picture);
        encryptfile.CRCWrite(this.id);
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


}
