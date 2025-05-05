package org.example.modules.serviceprovider.unitconverter;

import org.example.modules.service.unitconverter.ConverterInfo;
import org.example.modules.service.unitconverter.UnitConverter;

import java.util.Map;
import java.util.Set;

@ConverterInfo(name = "Currency", description = "Convert between USD, EUR, SEK")
public class CurrencyConverter implements UnitConverter {

    private static final Map<String, Double> RATES = Map.of(
            "USD", 1.0,
            "EUR", 1.12905,
            "SEK", 0.10265
    );

    @Override
    public double doConvert(double value, String fromUnit, String toUnit) {
        if (!RATES.containsKey(fromUnit) || !RATES.containsKey(toUnit)) {
            throw new IllegalArgumentException(
                    "Unsupported unit: " + fromUnit + " or " + toUnit);
        }

        return value * RATES.get(fromUnit) / RATES.get(toUnit);
    }

    @Override
    public Set<String> supportedUnits() {
        return RATES.keySet();
    }
}
