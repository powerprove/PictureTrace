package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash
{
    public static String getMd5(String value)
    {
        String result;
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes());
            byte[] byteData = md.digest();
            StringBuffer sb = new StringBuffer();

            for (byte data : byteData)
            {
                sb.append(Integer.toString((data & 0xff) + 0x100, 16).substring(1));
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            result = null;
        }
        return result;
    }
}
