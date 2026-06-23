import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VerifyInteractionTest {

    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    @Test
    public void testVerifyInteraction() {
        when(mockApi.getData()).thenReturn("Some Data");

        service.fetchData();

        verify(mockApi).getData();
        System.out.println("Test 1 passed: getData() called!");
    }

    @Test
    public void testVerifyExactTimes() {
        when(mockApi.getData()).thenReturn("Data");

        service.fetchData();
        service.fetchData();
        service.fetchData();

        verify(mockApi, times(3)).getData();
        System.out.println("Test 2 passed: getData() called 3 times!");
    }

    @Test
    public void testVerifyNeverCalled() {
        verify(mockApi, never()).getData();
        System.out.println("Test 3 passed: getData() never called!");
    }

    @Test
    public void testVerifyWithArgument() {
        when(mockApi.getUserInfo(5)).thenReturn("Navin");

        service.fetchUserInfo(5);

        verify(mockApi).getUserInfo(5);
        System.out.println("Test 4 passed: getUserInfo(5) called!");
    }

    @Test
    public void testVerifyWithAnyArgument() {
        when(mockApi.getUserInfo(anyInt())).thenReturn("Someone");

        service.fetchUserInfo(99);

        verify(mockApi).getUserInfo(anyInt());
        System.out.println("Test 5 passed: getUserInfo(anyInt) called!");
    }

    @Test
    public void testVerifyAtLeastAtMost() {
        when(mockApi.getData()).thenReturn("Data");

        service.fetchData();
        service.fetchData();

        verify(mockApi, atLeast(1)).getData();
        verify(mockApi, atMost(5)).getData();
        System.out.println("Test 6 passed: atLeast/atMost verify done!");
    }
}