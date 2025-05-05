import org.example.modules.service.unitconverter.UnitConverter;
import org.example.modules.serviceprovider.unitconverter.CurrencyConverter;
import org.example.modules.serviceprovider.unitconverter.LengthConverter;
import org.example.modules.serviceprovider.unitconverter.TemperatureConverter;

module org.example.modules.serviceprovider {

    requires org.example.modules.service;

    provides UnitConverter with LengthConverter,
                                TemperatureConverter,
                                CurrencyConverter;
}
