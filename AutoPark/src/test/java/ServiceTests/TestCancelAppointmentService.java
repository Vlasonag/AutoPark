package ServiceTests;


import java.util.List;

import model.entity.AppointmentDTO;
import model.service.CancelAppointmentService;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestCancelAppointmentService {
	
	private CancelAppointmentService service = mock(CancelAppointmentService.class);
	private List<AppointmentDTO> list = mock(List.class);
	private List<AppointmentDTO> spyOnList = spy(list);
	@Test
	public void testCancelAppointment() { 		
		doNothing().when(service).cancelAppointment(anyInt(), anyString());
		assertEquals(list.size(), spyOnList.size());
	}
}
