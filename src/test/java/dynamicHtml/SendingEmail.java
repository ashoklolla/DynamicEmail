package dynamicHtml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendingEmail {

	@Test 
	public static void TestMain() throws EmailException, Throwable {
		// TODO Auto-generated method stub

		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("testgit789@gmail.com", "testgit@789"));
		email.setSSLOnConnect(true);
		email.setFrom("testgit789@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("ashokkumar.lolla@outlook.com");
		email.send();
		System.out.println("Email sent successfully....");
		
		BufferedReader br = new BufferedReader(
	            new FileReader("./src/dynamicHtml/SendingEmail.java"));

	        File f = new File("./src/test/resources/source.html");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	        bw.write("<html>");
	        bw.write("<body>");
	        bw.write("<h1>ShowGeneratedHtml source</h1>");
	        bw.write("<textarea cols=75 rows=30>");

	        String line;
	        while ((line = br.readLine()) != null) {
	            bw.write(line);
	            bw.newLine();
	        }

	        bw.write("</text" + "area>");
	        bw.write("</body>");
	        bw.write("</html>");

	        br.close();
	        bw.close();
		
		
	}

}
