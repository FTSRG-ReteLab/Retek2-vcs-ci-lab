package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TrainSensorTest {

    TrainController trainController;
    TrainUser trainUser;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        trainController = mock(TrainController.class);
        trainUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(trainController, trainUser);
    }

    @Test
    public void absoluteSpeedLimitIsTooHigh() {
        trainSensor.overrideSpeedLimit(501);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void absoluteSpeedLimitIsTooLow() {
        trainSensor.overrideSpeedLimit(-1);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void absoluteSpeedLimitIsValid() {
        trainSensor.overrideSpeedLimit(50);
        verify(trainUser, times(0)).setAlarmState(true);
    }

    @Test
    public void relativeSpeedLimitIsInvalid() {
        when(trainController.getReferenceSpeed()).thenReturn(150);
        trainSensor.overrideSpeedLimit(50);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void relativeSpeedLimitIsValid() {
        when(trainController.getReferenceSpeed()).thenReturn(150);
        trainSensor.overrideSpeedLimit(100);
        verify(trainUser, times(0)).setAlarmState(true);
    }

    @Test
    public void setSpeedLimitTest() {
        trainSensor.overrideSpeedLimit(100);
        Assert.assertEquals(100, trainSensor.getSpeedLimit());
    }
}
