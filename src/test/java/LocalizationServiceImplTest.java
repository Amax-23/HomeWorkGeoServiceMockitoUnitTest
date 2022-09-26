import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

class LocalizationServiceImplTest {
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl();
        System.out.println("Test START!");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Test OK!");

    }

    @Test
    void localeRus() {
        String country = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals("Добро пожаловать", country);
    }

    @Test
    void localeUsa() {
        String country = localizationService.locale(Country.USA);
        Assertions.assertEquals("Welcome", country);
    }

    @Test
    void localeGermany() {
        String country = localizationService.locale(Country.GERMANY);
        Assertions.assertEquals("Welcome", country);
    }

    @Test
    void localeBrazil() {
        String country = localizationService.locale(Country.BRAZIL);
        Assertions.assertEquals("Welcome", country);
    }

}