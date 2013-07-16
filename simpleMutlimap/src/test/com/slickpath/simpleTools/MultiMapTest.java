package test.com.slickpath.simpleTools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.slickpath.simpleTools.MultiMap;

public class MultiMapTest{

	private static final String KEY1 = "Key1";
	private static final String KEY2 = "Key2";
	private static final String KEY3 = "Key3";
	private static final String KEY4 = "Key4";
	private static final String KEY5 = "Key5";
	private static final String KEY6 = "Key6";

	private String getValue(final String key1, final String key2 )
	{
		return key1 + "_" + key2;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		final MultiMap<String, String> multimap = new MultiMap<String, String>();
		multimap.add(KEY1, KEY2, getValue(KEY1, KEY2));
		multimap.add(KEY1, KEY2, getValue(KEY1, KEY2));
		assertEquals("There should only be 1 entry", 1, multimap.size());
		multimap.add(KEY1, KEY2, getValue(KEY1, KEY3));
		assertEquals("There should only be 1 entry", 1, multimap.size());
		multimap.add(KEY1, KEY2, getValue(KEY1, KEY2));
		assertEquals("There should only be 1 entry", 1, multimap.size());
		multimap.add(KEY1, KEY2, getValue(KEY1, KEY2));
		assertEquals("There should only be 1 entry", 1, multimap.size());
		multimap.add(KEY1, KEY3, getValue(KEY1, KEY2));
		assertEquals("There should only be 2 entries", 2, multimap.size());
		multimap.add(KEY1, KEY3, getValue(KEY1, KEY3));
		assertEquals("There should only be 2 entries", 2, multimap.size());
		multimap.add(KEY2, KEY1, getValue(KEY1, KEY2));
		assertEquals("There should only be 3 entries", 3, multimap.size());
	}

	@Test
	public void testPut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMultiMapKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllValues() {
		fail("Not yet implemented");
	}

	@Test
	public void testValues() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntrySet() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeys() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAllPrimaries() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

}
