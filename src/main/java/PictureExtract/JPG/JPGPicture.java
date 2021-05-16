package PictureExtract.JPG;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import PictureExtract.Patch.FilePatcher;
import PictureExtract.Picture;
import PictureExtract.PictureInfo;
import PictureExtract.PrintFormat;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.IOException;

public class JPGPicture extends Picture
{
    private Metadata metadata = null;
    private ArrayList<Directory> directoryList = new ArrayList<>();
    private ArrayList<Tag> tagList = new ArrayList<>();

    public JPGPicture(String filename)
    {
        super(filename);
        extractMetadata();
    }

    public void extractMetadata()
    {
        if (!directoryList.isEmpty() && !tagList.isEmpty())
            return;

        try
        {
            jpgFileOpen();
            fileAnalysis();
        }
        catch (ImageProcessingException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getFullMetaData()
    {
        printFullMetaData();
        ArrayList<String> fullMetadata = new ArrayList<>();

        for (Tag tag : this.tagList)
        {
            String metadata = String.format(PictureInfo.MetaDataFormat,
                    tag.getDirectoryName(), tag.getTagName(), tag.getDescription());
            fullMetadata.add(metadata);
        }

        return fullMetadata;
    }

    public ArrayList<String> getCoreMetaData()
    {

        ArrayList<String> coreMetadata = new ArrayList<>();

        for (Tag tag : this.tagList)
        {
            if (Arrays.asList(PictureInfo.CoreTagList).contains(tag.getTagName())) {
                String metadata = String.format(PictureInfo.MetaDataFormat,
                        tag.getDirectoryName(), tag.getTagName(), tag.getDescription());
                coreMetadata.add(metadata);
            }
        }

        return coreMetadata;
    }

    public String getMetaData(String tagName)
    {
        String result = null;

        for (Tag tag : this.tagList)
            if (tag.getTagName().equals(tagName))
                result = tag.getDescription();

        return result;
    }

    public String getCRCMetaData(String nickname)
    {
        String result = "";
        ArrayList<String> metadata = getCoreMetaData();

        for (String data : metadata)
            result.concat(data);

        result += nickname;
        result = Util.Hash.getMd5(result);
        return result;
    }

    public FilePatcher getPatcher(File file)
    {
        return new JPGPatcher(file);
    }

    private void fileAnalysis()
    {
        setMetaDataList();
        printFullMetaData();
        printCoreMetaData();
    }

    private void jpgFileOpen() throws ImageProcessingException, IOException
    {
        this.metadata = ImageMetadataReader.readMetadata(getFile());
    }

    private void setMetaDataList()
    {
        for (Directory directory : metadata.getDirectories())
        {
            this.directoryList.add(directory);
            this.tagList.addAll(directory.getTags());
        }
    }


    private void printFullMetaData()
    {
        System.out.format(PrintFormat.MetaDataPrintFrameFormat,
                PrintFormat.MetaDataPrintFullData, PrintFormat.MetaDataPrintStart);

        for (Tag tag : this.tagList)
            System.out.format(PrintFormat.MetaDataPrintFormtat,
                    tag.getDirectoryName(), tag.getTagName(), tag.getDescription());

        System.out.format(PrintFormat.MetaDataPrintFrameFormat,
                PrintFormat.MetaDataPrintFullData, PrintFormat.MetaDataPrintEnd);

    }

    private void printCoreMetaData()
    {
        System.out.format(PrintFormat.MetaDataPrintFrameFormat,
                PrintFormat.MetaDataPrintCoreData, PrintFormat.MetaDataPrintStart);

        for (Tag tag : this.tagList)
            if (Arrays.asList(PictureInfo.CoreTagList).contains(tag.getTagName()))
                System.out.format(PrintFormat.MetaDataPrintFormtat,
                        tag.getDirectoryName(), tag.getTagName(), tag.getDescription());

        System.out.format(PrintFormat.MetaDataPrintFrameFormat,
                PrintFormat.MetaDataPrintCoreData, PrintFormat.MetaDataPrintEnd);
    }

    @Override
    public String toString()
    {
        return PictureInfo.JPGFormat;
    }

}
