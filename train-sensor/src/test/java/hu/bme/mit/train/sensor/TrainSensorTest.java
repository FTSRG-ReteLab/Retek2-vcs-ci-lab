package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

   TrainSensor sensor;

    @Before
    public void before() {
	TrainSystem system = new TrainSystem();
	sensor=system.getSensor();
	
    }

    @Test
    public void MySensortTest{
	sensor.overrideSpeedLimit(-10);        
	
	Assert.assertEquals(-10,sensor.getSpeedLimit());
    }
}
