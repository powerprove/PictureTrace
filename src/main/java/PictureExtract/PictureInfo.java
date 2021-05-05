package PictureExtract;

public class PictureInfo
{
    public final static String JPGFormat = "JPG";
    public final static String PNGFORMAT = "png";

    public static String[] CoreTagList = {
            // File Directory
            "File Name",
            "File Size",
            "File Modified Date",

            // File Type Directory
            "Detected File Type Name",

            //Exif IFD0 Directory
            "Make",
            "Model",
            "Software",
            "Date/Time",

            //GPS Directory
            "GPS Latitude",
            "GPS Longitude",
            "GPS Altitude",
            "GPS Speed",

            // JPEG Directory
            "Image Height",
            "Image Width",
            "Version",

            // ICC Profile Directory
            "Profile Copyright",
            "Profile Date/Time"
    };
}