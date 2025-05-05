package org.example.modules.serviceconsumer.consumer;

import org.example.modules.service.unitconverter.ConverterInfo;
import org.example.modules.service.unitconverter.UnitConverter;

import java.util.*;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final List<UnitConverter> CONVERTERS =
            ServiceLoader.load(UnitConverter.class)
                    .stream()
                    .map(ServiceLoader.Provider::get)
                    .toList();

    public static void main(String[] args) {

        while (true) {
            printOptions();

            Optional<String> fromOpt = readUnit("From unit: ");
            if (fromOpt.isEmpty()) break;
            Optional<String> toOpt   = readUnit("To unit:   ");
            if (toOpt.isEmpty())   break;

            String fromUnit = fromOpt.get();
            String toUnit   = toOpt.get();

            double value = readValidValue();

            Optional<UnitConverter> converter =
                    CONVERTERS.stream()
                            .filter(c -> c.canConvert(fromUnit, toUnit))
                            .findFirst();

            if (converter.isEmpty()) {
                System.out.printf("No converter found for '%s' → '%s'.%n",
                        fromUnit, toUnit);
                continue;
            }

            double result = converter.get().convert(value, fromUnit, toUnit);
            System.out.printf("%f %s = %f %s%n%n",
                    value, fromUnit, result, toUnit);
        }
        SCANNER.close();
    }

    private static Optional<String> readUnit(String unitPrompt) {
        System.out.print(unitPrompt);
        String input = SCANNER.next();
        return "x".equalsIgnoreCase(input) ? Optional.empty()
                : Optional.of(input);
    }

    private static double readValidValue() {
        while (true) {
            System.out.print("Value: ");
            if (SCANNER.hasNextDouble()) {
                double value = SCANNER.nextDouble();
                if (value > 0) return value;
                System.out.println("Value must be greater than 0.");
            } else {
                System.out.println("Not a valid number.");
            }
            SCANNER.next();
        }
    }

    private static void printOptions() {
        System.out.println("\nAllowed units (enter X to exit)");
        System.out.println("=============");
        for (UnitConverter c : CONVERTERS) {
            ConverterInfo info = c.getClass().getAnnotation(ConverterInfo.class);
            System.out.printf("%s — %s%n", info.name(), info.description());
        }
        System.out.println("=============");
    }
}
