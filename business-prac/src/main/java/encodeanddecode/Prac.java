package encodeanddecode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Prac {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String encodeStr = URLEncoder.encode("汉字", "utf-8");
        System.out.println(encodeStr);
        //encode:--->%E6%B1%89%E5%AD%97

        String decodeStr = URLDecoder.decode("%E6%B1%89%E5%AD%97", "utf-8");
        System.out.println(decodeStr);
        //decode:--->汉字

        byte[] bytes_utf8 = "知".getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes_utf8));

        Set<String> charsetNames = Charset.availableCharsets().keySet();
        System.out.println("-----the number of jdk1.67's charset is " + charsetNames.size() + "-----");
        for (Iterator it = charsetNames.iterator(); it.hasNext();) {
            String charsetName = (String) it.next();
            System.out.println(charsetName);
        }
    }
}
