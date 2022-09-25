package test;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


class GeoServiceImplTest {
    private GeoServiceImpl geoService;

    @BeforeEach
    void setUp() {
        geoService = new GeoServiceImpl();
        System.out.println("Test START!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test OK!");
    }

    @Test
    void byIpMoscowIp() {
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        Location geo = geoService.byIp("172.");
        Assertions.assertEquals(geo.getCity(), location.getCity());
        Assertions.assertEquals(geo.getStreet(), location.getStreet());
        Assertions.assertEquals(geo.getBuiling(), location.getBuiling());
        Assertions.assertEquals(geo.getClass(), location.getClass());
        Assertions.assertEquals(geo.getCountry(), location.getCountry());

    }

    @Test
    void byIpMoscowName() {
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location geo = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        Assertions.assertEquals(geo.getCity(), location.getCity());
        Assertions.assertEquals(geo.getStreet(), location.getStreet());
        Assertions.assertEquals(geo.getBuiling(), location.getBuiling());
        Assertions.assertEquals(geo.getClass(), location.getClass());
        Assertions.assertEquals(geo.getCountry(), location.getCountry());

    }

    @Test
    void byIpNull() {
        Location location = new Location(null, null, null, 0);
        Location geo = geoService.byIp(GeoServiceImpl.LOCALHOST);
        Assertions.assertEquals(geo.getCity(), location.getCity());
        Assertions.assertEquals(geo.getStreet(), location.getStreet());
        Assertions.assertEquals(geo.getBuiling(), location.getBuiling());
        Assertions.assertEquals(geo.getClass(), location.getClass());
        Assertions.assertEquals(geo.getCountry(), location.getCountry());

    }

    @Test
    void byIpNewYork() {
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location geo = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        Assertions.assertEquals(geo.getCity(), location.getCity());
        Assertions.assertEquals(geo.getStreet(), location.getStreet());
        Assertions.assertEquals(geo.getBuiling(), location.getBuiling());
        Assertions.assertEquals(geo.getClass(), location.getClass());
        Assertions.assertEquals(geo.getCountry(), location.getCountry());

    }

    @Test
    void byIpNewYorkIp() {
        Location location = new Location("New York", Country.USA, null, 0);
        Location geo = geoService.byIp("96.");
        Assertions.assertEquals(geo.getCity(), location.getCity());
        Assertions.assertEquals(geo.getStreet(), location.getStreet());
        Assertions.assertEquals(geo.getBuiling(), location.getBuiling());
        Assertions.assertEquals(geo.getClass(), location.getClass());
        Assertions.assertEquals(geo.getCountry(), location.getCountry());

    }
}