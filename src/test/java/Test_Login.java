import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dws.genericutility.BaseClass;
import com.dws.genericutility.ListenerClass;

@Listeners(ListenerClass.class)
public class Test_Login extends BaseClass{
	
	@Test
	public void loginToDWS() throws EncryptedDocumentException, IOException {
		
		String homePageTitle=excelUtil.getStringDataFromExcel("Login", 1, 3);
		Assert.assertEquals(driver.getTitle(), homePageTitle);
	}

	
}
