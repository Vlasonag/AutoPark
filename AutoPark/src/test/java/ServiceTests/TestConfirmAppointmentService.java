package ServiceTests;

import static org.junit.Assert.*; 
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.List;

import model.entity.AppointmentDTO;
import model.service.CancelAppointmentService;
import model.service.ConfirmAppointmentService;

import org.junit.Test;

public class TestConfirmAppointmentService {
	private ConfirmAppointmentService service = mock(ConfirmAppointmentService.class);
	private AppointmentDTO app = mock(AppointmentDTO.class);
	private AppointmentDTO spyOnApp = spy(app);
	@Test
	public void TestConfirmAppointment() { 		
		doNothing().when(service).confirmAppointment(anyString());
		assertEquals(app.getCar_model(), spyOnApp.getCar_model());
	}
}
