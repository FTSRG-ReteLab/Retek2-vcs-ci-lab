package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.system.TrainSystem;
import hu.bme.mit.train.interfaces.TrainSensor;


public class TrainSensorTest {

   TrainSensor sensor;

    @Before
    public void before() {
	TrainSystem system = new TrainSystem();
	sensor=system.getSensor();
	
    }

    @Test
    public void MySensortTest(){
	sensor.overrideSpeedLimit(-10);        
	
	Assert.assertEquals(-10,sensor.getSpeedLimit());
    }
}
