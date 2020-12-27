import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SongTest {

	Song s1; 
	Song s2;
	Song s3;
	
	@Before
	public void setup() {
		s1 = new Song("Bob Dylan", "Hurricane",3,42);
		s2 = new Song(s1);
		s3 = new Song("Taylor Swift", "Red", 4,20);
	}
	
	
	@Test
	public void testEquals() {
		boolean result = s1.equals(s3);
		assertEquals("", false, result);
	
	}
	
	@Test
	public void testCompareTo() {
		int result = s1.compareTo(s3);
		System.out.println(result);
		assertEquals("", -18, result);
	
	}

}
