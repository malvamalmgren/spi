package org.example.modules.serviceconsumer.consumer;

import org.example.modules.service.calculator.Calculator;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        Calculator calculator;
        ServiceLoader<Calculator> calculators = ServiceLoader.load(Calculator.class);
        calculator = calculators.findFirst().orElseThrow();
        //??? (ställt in i Main config -> Modify options -> 'Add dependencies with "provided" scope to classpath')

        //För att upptäcka? module-path i runtime kör detta
        //  java --module-path ".\service\target\classes\;.\serviceconsumer\target\classes\;.\serviceprovider\target\classes\" -m org.example.modules.serviceconsumer/org.example.modules.serviceconsumer.consumer.Main
        //eller
        //  cd .\runtime\  (mappen med de byggda jar-filerna)
        //  java --module-path ".\" -m org.example.modules.serviceconsumer/org.example.modules.serviceconsumer.consumer.Main


        System.out.println(calculator.add(1,2));
    }
}
