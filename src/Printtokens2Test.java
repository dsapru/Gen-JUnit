import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;

public class Printtokens2Test {
	Printtokens2 obj, fileTest;
			
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fileTest = new Printtokens2(); // open_charcter_stream_test
	}

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	    public void open_character_stream_with_file() {
	        String fname = "./myfile.txt"; //pass blank argument to fail
	        BufferedReader reader = fileTest.open_character_stream(fname);
	        assertNotNull(reader);
	        //System.out.println("open_character_stream_test Success");
	 	}

	    @Test
	    public void open_character_stream_no_file() {
	        BufferedReader reader = fileTest.open_character_stream(null);
	        assertNotNull(reader);
	        //System.out.println("open_character_stream_test Success");
	    }

	    @Test
	    public void open_token_stream() {
	        //PrintTokens tokens = new PrintTokens();
	        String fname = "./myfile.txt"; //pass blank argument to fail
	        BufferedReader reader = fileTest.open_character_stream(fname);
	        assertNotNull("assert that reader is not null", reader);
	        //System.out.println("open_token_stream_test Success");
	    }
	    
	    @Test
	    public void get_token_test() {
	    	
	    	String fname = "./myfile.txt"; //pass blank argument to fail
	        BufferedReader reader = fileTest.open_character_stream(fname);
	        Assert.assertNotEquals(null,fileTest.get_token(reader));
	        
	    }
	    
	    @Test
	    public void get_token_test1() {
	    	
	    	String fname = "./myfile.txt"; //pass blank argument to fail
	        BufferedReader reader = fileTest.open_character_stream(fname);
	        int res = fileTest.get_char(reader);
            char ch = (char)res;
            assertTrue(fileTest.is_spec_symbol(ch));
	    }
	    
	    @Test
	    public void get_token_test2() {
	    	int id;
	    	String fname = "./myfile.txt"; //pass blank argument to fail
	        BufferedReader reader = fileTest.open_character_stream(fname);
	        int res = fileTest.get_char(reader);
            char ch = (char)res;
            id=2;
            assertEquals(false,fileTest.is_token_end(id, res));
	    }
	    
	    @Test
	    public void get_token_test3() {
	    	int id;
	    	String fname = "./myfile.txt"; //pass blank argument to fail
	        BufferedReader reader = fileTest.open_character_stream(fname);
	        int res = fileTest.get_char(reader);
            char ch = (char)res;
            id=1;
            assertEquals(false,fileTest.is_token_end(id, res));
	    }
	    
	    @Test
	    public void is_token_endtest()
	    {
	    	int id, res;
	    	id = 1;
	    	res = -1; 
	    	assertTrue(fileTest.is_token_end(id,res));
	   
	    	id = 1;
	    	res = 34; 
	    	assertTrue(fileTest.is_token_end(id,res));
	   
	    	id = 1;
	    	res = 78; 
	    	assertEquals(false,fileTest.is_token_end(id,res));
	   
	    	id = 1;
	    	res = 10; 
	    	assertTrue(fileTest.is_token_end(id,res));
	   
	    	id = 1;
	    	res = 13; 
	    	assertTrue(fileTest.is_token_end(id,res));
	    	
	    	id = 2;
	    	res = -1; 
	    	assertTrue(fileTest.is_token_end(id,res));
	   
	    	id = 2;
	    	res = 78; 
	    	assertEquals(false,fileTest.is_token_end(id,res));
	   
	    	id = 2;
	    	res = 10; 
	    	assertTrue(fileTest.is_token_end(id,res));
	   
	    	id = 2;
	    	res = 11; 
	    	assertFalse(fileTest.is_token_end(id,res));
	   
	    	id = 2;
	    	res = 13; 
	    	assertTrue(fileTest.is_token_end(id,res));
	       
	    	char ch = '(';
	    	assertTrue(fileTest.is_spec_symbol(ch));
	    	
	    	id = 0; 
	    	res = 0;
	    	assertFalse(fileTest.is_token_end(id, res));

	    }

	    @Test
	    public void token_type() {
	        assertEquals(0,obj.token_type("$"));
	        assertEquals(1,obj.token_type("and"));
	        assertEquals(2,obj.token_type("]"));
	        assertEquals(3,obj.token_type("only"));
	        assertEquals(5,obj.token_type("//gta"));
	        assertEquals(41,obj.token_type("3"));
	        assertEquals(42,obj.token_type("\"Test\""));
	        assertEquals(43,obj.token_type("#A"));
	    	//System.out.println("token_type_test Success");
	    }
	    
	    @Test
	    public void token_type_fail() {
	    	
	    	Assert.assertNotEquals(43,obj.token_type("$"));
	    	Assert.assertNotEquals(42,obj.token_type("and"));
	    	Assert.assertNotEquals(41,obj.token_type("]"));
	    	Assert.assertNotEquals(5,obj.token_type("only"));
	    	Assert.assertNotEquals(3,obj.token_type("//gta"));
	    	Assert.assertNotEquals(2,obj.token_type("3"));
	    	Assert.assertNotEquals(1,obj.token_type("\"Test\""));
	    	Assert.assertNotEquals(0,obj.token_type("#A"));
//	      	System.out.println("token_type_test fail");
	    }
	
	    
	    @Test
	    public void print_token_errtest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="^";
	    	fileTest.print_token(x);
	    	assertEquals("error,\"^\".\n",output.toString());
	    }
	    
	    @Test
	    public void print_token_keywordtest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="and";
	    	fileTest.print_token(x);
	    	assertEquals("keyword,\"and\".\n",output.toString());
	    }
	    
	    @Test
	    public void print_token_identtest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="every";
	    	fileTest.print_token(x);
	    	assertEquals("identifier,\"every\".\n",output.toString());
	    }
	    
	    @Test
	    public void print_token_numtest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="2";
	    	fileTest.print_token(x);
	    	assertEquals("numeric,2.\n",output.toString());
	    }

	    @Test
	    public void print_token_strtest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="\"Test\"";
	    	fileTest.print_token(x);
	    	assertEquals("string,\"Test\".\n",output.toString());
	    }
	    
	    @Test
	    public void print_token_chartest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="#A";
	    	fileTest.print_token(x);
	    	assertEquals("character,\"A\".\n",output.toString());
	    }

	    @Test
	    public void print_token_commenttest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="/";
	    	fileTest.print_token(x);
	    	assertEquals("comment,\"/\".\n",output.toString());
	    }

	    @Test
	    public void is_comment() {
	        assertEquals(true,obj.is_comment("/"));
	    	//System.out.println("is_comment_test Success");
	    }

	    @Test
	    public void is_comment_fail() {
	        assertEquals(false,obj.is_comment("abc"));
	    	//System.out.println("is_comment_test fail");
	    }
	
	    @Test
	    public void is_keyword() {
	        assertEquals(true,obj.is_keyword("and"));
	    	//System.out.println("is_keyword_test Success");
	    }

	    @Test
	    public void is_keyword_fail() {
	        assertEquals(false,obj.is_keyword("int"));
	    	//System.out.println("is_keyword_test fail");
	    }
	    
	    @Test
	    public void is_char_constant() {
	        assertEquals(true,obj.is_char_constant("#A"));
	    	//System.out.println("is_char_constant_test Success");
	    }

	    @Test
	    public void is_char_constant_fail() {
	        assertEquals(false,obj.is_char_constant("A"));
	    	//System.out.println("is_char_constant_test fail");
	    }

	    @Test
	    public void is_num_constant() {
	        assertEquals(true,obj.is_num_constant("3"));
	        //System.out.println("is_str_constant_test Success");
	    }

	    @Test
	    public void is_num_constant_fail() {
	    	assertEquals(false,obj.is_num_constant("abcd"));
	        //System.out.println("is_str_constant_test fail");
	    }

	    @Test
	    public void is_str_constant() {
	        assertEquals(true,obj.is_str_constant("\"T\""));
	        assertEquals(true,obj.is_str_constant("\"Test\""));
	        //System.out.println("is_str_constant_test Success");
	    }

	    @Test
	    public void is_str_constant_fail() {
	    	assertEquals(false,obj.is_str_constant(" "));
	        //System.out.println("is_str_constant_test fail");
	    }

	    @Test
	    public void is_identifier() {
	        assertEquals(true,obj.is_identifier("t"));
	        assertEquals(true,obj.is_identifier("test"));
	        //System.out.println("is_identifier_test Success");
	    }

	    @Test
	    public void is_identifier_fail() {
	    	assertEquals(false,obj.is_identifier("123"));
	        //System.out.println("is_identifier_test fail");
	    }

	    @Test
	    public void print_spec_laprentest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="(";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("lparen.\n",output.toString());
	    }

	    @Test
	    public void print_spec_rparentest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x=")";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("rparen.\n",output.toString());
	    }

	    @Test
	    public void print_spec_lsquaretest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="[";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("lsquare.\n",output.toString());
	    }

	    @Test
	    public void print_spec_rsquaretest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="]";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("rsquare.\n",output.toString());
	    }

	    @Test
	    public void print_spec_quotetest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="'";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("quote.\n",output.toString());
	    }
	    
	    @Test
	    public void print_spec_bquotetest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x="`";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("bquote.\n",output.toString());
	    }

	    @Test
	    public void print_spec_commatest()
	    {
	    	final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    	System.setOut(new PrintStream(output));
	    	String x=",";
	    	fileTest.print_spec_symbol(x);
	    	assertEquals("comma.\n",output.toString());
	    }

	    @Test
	    public void is_spec_symbol() {
	        assertEquals(true,obj.is_spec_symbol('('));
	        assertEquals(true,obj.is_spec_symbol(')'));
	        assertEquals(true,obj.is_spec_symbol('['));
	        assertEquals(true,obj.is_spec_symbol(']'));
	        assertEquals(true,obj.is_spec_symbol('\''));
	        assertEquals(true,obj.is_spec_symbol(','));
	        assertEquals(true,obj.is_spec_symbol('`'));
	        //System.out.println("is_spec_symbol_test Success");
	    }

	    @Test
	    public void is_spec_symbol_fail() {
	        assertEquals(false,obj.is_spec_symbol('a'));
	    	//System.out.println("is_spec_symbol_test fail");
	    }

}