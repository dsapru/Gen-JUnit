import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
	Printtokens2 obj, file;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		file = new Printtokens2();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	    	 String args[] = {"myfile.txt"};
	    	 String args1[] = {"myfile.txt","blank.txt","blank1.txt"};
	    	 String args2[] = {"blank.txt"};
	    	 String args3[] = {""};
	    	 
	    	try
			{
				file.main(args);
	    		assert(true);
	    		file.main(args3);
				assert(true);
				file.main(args2);
				assert(true);
				file.main(args1);				
				assert(true);
		
			}
			
			catch(Exception e)
				{
				e.printStackTrace();
				assert(false);
				
			}

	    		    	
	}
	

}
