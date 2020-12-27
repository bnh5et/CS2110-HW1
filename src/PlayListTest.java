import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayListTest {
	Song s1; 
	Song s2;
	Song s3;
	PlayList pl;
	
	@Before
	public void setup() {
		s1 = new Song("Bob Dylan", "Hurricane",3,42);
		s2 = new Song(s1);
		pl.addSong(s1); pl.addSong(s2); pl.addSong(s3);
	}
	
	@Test
	public void test() {
		

	}

}
