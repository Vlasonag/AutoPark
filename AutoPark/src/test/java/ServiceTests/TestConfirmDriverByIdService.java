package ServiceTests;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.List;

import model.entity.Driver;
import model.service.ConfirmDriverByIdService;

import org.junit.Test;

public class TestConfirmDriverByIdService {
	private ConfirmDriverByIdService service = mock(ConfirmDriverByIdService.class);
	private List<Driver> list = mock(List.class);
	private List<Driver> spyOnList = spy(list);
	
	@Test
	public void TestConfirmAppointment() throws SQLException { 		
		doNothing().when(service).confirmDriverById(anyInt());
		assertEquals(list.size(), spyOnList.size());
	}

}
