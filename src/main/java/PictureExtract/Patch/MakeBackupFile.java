package PictureExtract.Patch;

import java.io.*;

public class MakeBackupFile
{
    public File makeBackup(String realFilepath, String backupFilePath)
    {
        File backupFile = new File(backupFilePath);
        File realFile = new File(realFilepath);

        CopyData(realFile, backupFile);

        return backupFile;
    }

    private void CopyData(File realFile, File backupFile)
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream(realFile);
            FileOutputStream fileOutputStream = new FileOutputStream(backupFile);

            int fileByte;

            while ((fileByte = fileInputStream.read()) != -1)
            {
                fileOutputStream.write(fileByte);
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
