import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp() {

        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
        System.out.println("Mock created!");
    }

    @Test
    public void testFetchData() {

        when(mockApi.getData()).thenReturn("Mock Data");

        String result = service.fetchData();

        assertEquals("Mock Data", result);
        System.out.println("testFetchData passed! Result: " + result);
    }

    @Test
    public void testFetchUserInfo() {

        when(mockApi.getUserInfo(1)).thenReturn("Navin");
        when(mockApi.getUserInfo(2)).thenReturn("Rahul");

        String user1 = service.fetchUserInfo(1);
        String user2 = service.fetchUserInfo(2);

        assertEquals("Navin", user1);
        assertEquals("Rahul", user2);
        System.out.println("testFetchUserInfo passed!");
    }

    @Test
    public void testVerifyMethodCalled() {

        when(mockApi.getData()).thenReturn("Test Data");

        service.fetchData();

        verify(mockApi, times(1)).getData();
        System.out.println("verify passed!");
    }

    @Test
    public void testFetchDataThrowsException() {

        when(mockApi.getData()).thenThrow(new RuntimeException("API Down!"));

        assertThrows(RuntimeException.class, () -> {
            service.fetchData();
        });
        System.out.println("exception stubbing passed!");
    }
}