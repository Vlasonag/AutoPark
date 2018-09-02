package ServiceTests;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.List;

import model.entity.Car;
import model.service.CreateCarService;

import org.junit.Test;

public class TestCreateCarService {

	private CreateCarService service = mock(CreateCarService.class);
	private List<Car> list = service.getAll();
	private List<Car> spyOnList = spy(list);
	
	@Test
	public void TestConfirmAppointment() throws SQLException{ 		
		doNothing().when(service).createCar(anyString(), anyString());
		assertEquals(list.size(), spyOnList.size());
		
	}
}
