package PictureExtract;

import java.util.ArrayList;
import java.util.Arrays;

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
    }

    public void fileExtract()
    {
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

    private void fileAnalysis()
    {
        setMetaDataList();
        printFullMetaData();
        printCoreMetaData();
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

    private void jpgFileOpen() throws ImageProcessingException, IOException
    {
        this.metadata = ImageMetadataReader.readMetadata(getFile());
    }
}
