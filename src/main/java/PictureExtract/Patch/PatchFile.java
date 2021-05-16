package PictureExtract.Patch;

import PictureExtract.Picture;
import PictureExtract.PrintFormat;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class PatchFile
{
    private String backupFilePath;
    private File patchFile;
    private Picture picture ;

    public PatchFile(String backupFilePath, Picture picture)
    {
        this.picture = picture;
        this.backupFilePath = backupFilePath;
        MakeBackupFile();
        patchFileOpen();
    }

    public void CRCWrite(String nickname)
    {
        if (picture == null)
        {
            System.out.format(PrintFormat.ErrorStringFormat,
                    this.getClass().getSimpleName(), PrintFormat.ErrorPatchSetPicture);
            return;
        }

        String CRCdata = picture.getCRCMetaData(nickname);
        String decodeCRCdata = Util.Hash.decodeHex(CRCdata);
        FilePatcher filepatcher = picture.getPatcher(this.patchFile);
        filepatcher.CRCWrite(decodeCRCdata);
    }

    private void MakeBackupFile()
    {
        MakeBackupFile makebackupfile = new MakeBackupFile();
        makebackupfile.makeBackup(this.picture.getFilename(), this.backupFilePath);
    }

    private void patchFileOpen()
    {
        this.patchFile = new File(this.backupFilePath);
    }

}
