package org.example.modules.serviceprovider.unitconverter;

import org.example.modules.service.unitconverter.ConverterInfo;
import org.example.modules.service.unitconverter.UnitConverter;

import java.util.Set;

@ConverterInfo(name = "Temperature", description = "Convert between °C, °F, K")
public class TemperatureConverter implements UnitConverter {

    private static final Set<String> UNITS = Set.of("C", "F", "K");

    @Override
    public double doConvert(double value, String fromUnit, String toUnit) {

        double temperatureUnit = switch (fromUnit) {
            case "C" -> value;
            case "F" -> (value - 32) * 5 / 9.0;
            case "K" -> value - 273.15;
            default  -> throw new IllegalArgumentException("Unsupported unit: " + fromUnit);
        };

        return switch (toUnit) {
            case "C" -> temperatureUnit;
            case "F" -> (temperatureUnit * 9 / 5.0) + 32;
            case "K" -> temperatureUnit + 273.15;
            default  -> throw new IllegalArgumentException("Unsupported unit: " + toUnit);
        };
    }

    @Override
    public Set<String> supportedUnits() {
        return UNITS;
    }
}
