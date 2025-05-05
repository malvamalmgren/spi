package org.example.modules.service.unitconverter;

import java.util.Locale;
import java.util.Set;

public interface UnitConverter {

    /**
     * Convert a value between two units.
     * <br>The method is case‑insensitive:
     * “eur” and “EUR” are equivalent.
     */
    default double convert(double value, String fromUnit, String toUnit) {
        return doConvert(
                value,
                canonical(fromUnit),
                canonical(toUnit)
        );
    }

    /** True if this converter can handle both units. */
    default boolean canConvert(String fromUnit, String toUnit) {
        return supportedUnits().containsAll(
                Set.of(canonical(fromUnit), canonical(toUnit)));
    }

    /** Valid units, in canonical form (UPPER‑CASE). */
    Set<String> supportedUnits();

    /**
     * Internal conversion.
     */
    double doConvert(double value, String fromUnit, String toUnit);

    private static String canonical(String s) {
        return s == null ? null : s.trim().toUpperCase(Locale.ROOT);
    }
}
