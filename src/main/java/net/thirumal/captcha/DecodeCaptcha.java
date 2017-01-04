package net.thirumal.captcha;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

/**
 * @author Thirumal
 *
 */
public class DecodeCaptcha {
	
    public String getCaptchInString(String fileName )  {
    	BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead(fileName);
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String captchaInString = outText.getString();
        System.out.println("OCR output: " + captchaInString);

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
        api.close();
        return captchaInString.replaceAll("\\s+","");
    }
}
