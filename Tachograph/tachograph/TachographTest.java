package tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import com.google.common.collect.Table;

import hu.bme.mit.train.system.TrainSystem;
import tachograph.Tachograph;

class TachographTest {
	
	Tachograph tachograph;

	@Before
	public void before() {
		tachograph = new Tachograph();
	}
	
	@Test
	void isEmptyTest() {
		Assert.assertTrue(tachograph.getTable().isEmpty());
	}

}
