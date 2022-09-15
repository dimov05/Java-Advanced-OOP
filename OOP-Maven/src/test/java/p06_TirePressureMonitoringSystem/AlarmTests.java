package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlarmTests {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void constructor(){
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    //TODO: sensor PSI < 17 check alarmOn == true?
    //TODO: sensor PSI > 23 check alarmOn == true?
    //TODO: sensor 17 >= PSI <= 23 check alarmOn == false?
    @Test
    public void testLowerPsiAndAlarmOnMethodShouldBeTrue(){
        //Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.2);
        //Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testHigherPsiAndAlarmOnMethodShouldBeTrue(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(24.2);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testCheckWorkingWithCorrectData(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.3);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}
