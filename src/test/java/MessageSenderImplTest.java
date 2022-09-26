import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.geo.GeoServiceImpl.*;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {

    private MessageSenderImpl messageSender;
    Map<String, String> headers = new HashMap<String, String>();
    @Mock
    private GeoServiceImpl geoServiceIml;

    @Mock
    private LocalizationServiceImpl localizationServiceIml;

    @BeforeEach
    void setUp() {
        geoServiceIml = new GeoServiceImpl();
        localizationServiceIml = new LocalizationServiceImpl();
        messageSender = new MessageSenderImpl(geoServiceIml, localizationServiceIml);
        System.out.println("Test START!");
    }

    @AfterEach
    void tearDown() {
        System.out.println("\nTest OK!");
    }

    @Test
    void sendRusIp() {
        headers.put(IP_ADDRESS_HEADER, "172.123.12.19");
        Assertions.assertEquals(messageSender.send(headers), "Добро пожаловать");

    }

    @Test
    void sendRusName() {
        headers.put(IP_ADDRESS_HEADER, MOSCOW_IP);
        Assertions.assertEquals(messageSender.send(headers), "Добро пожаловать");

    }

    @Test
    void sendUsaIp() {
        headers.put(IP_ADDRESS_HEADER, "96.44.183.149");
        Assertions.assertEquals(messageSender.send(headers), "Welcome");

    }

    @Test
    void sendUsaName() {
        headers.put(IP_ADDRESS_HEADER, NEW_YORK_IP);
        Assertions.assertEquals(messageSender.send(headers), "Welcome");

    }

}