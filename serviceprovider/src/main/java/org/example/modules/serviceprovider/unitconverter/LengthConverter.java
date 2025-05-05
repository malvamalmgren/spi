package org.example.modules.serviceprovider.unitconverter;

import org.example.modules.service.unitconverter.ConverterInfo;
import org.example.modules.service.unitconverter.UnitConverter;

import java.util.Map;
import java.util.Set;

@ConverterInfo(name = "Length", description = "Convert between m, cm, mm, ft, in, yd")
public class LengthConverter implements UnitConverter {

    private static final Map<String, Double> UNITS = Map.of(
            "M",  1.0,
            "CM", 0.01,
            "MM", 0.001,
            "FT", 0.3048,
            "IN", 0.0254,
            "YD", 0.9144
    );

    @Override
    public double doConvert(double value, String fromUnit, String toUnit) {

        if (!UNITS.containsKey(fromUnit) || !UNITS.containsKey(toUnit)) {
            throw new IllegalArgumentException(
                    "Unsupported unit: " + fromUnit + " or " + toUnit);
        }

        double metres = value * UNITS.get(fromUnit);

        return metres / UNITS.get(toUnit);
    }

    @Override
    public Set<String> supportedUnits() {
        return UNITS.keySet();
    }
}
