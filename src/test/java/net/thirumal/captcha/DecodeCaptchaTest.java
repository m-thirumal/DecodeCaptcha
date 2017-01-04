/**
 * 
 */
package net.thirumal.captcha;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

/**
 * @author Thirumal
 *
 */
@RunWith(JUnitPlatform.class)
public class DecodeCaptchaTest {
	
	DecodeCaptcha captcha = new DecodeCaptcha();
	
	@Test
	public void getCaptchaInStringTest() {
		Assert.assertEquals("The Expected text is Wooing", "Wooing", captcha.getCaptchInString("captcha\\test.jpeg"));
	}

}
