import org.example.modules.service.calculator.Calculator;
import org.example.modules.serviceprovider.calculator.FunnyCalculator;
import org.example.modules.serviceprovider.calculator.NormalCalculator;

module org.example.modules.serviceprovider {
    requires org.example.modules.service;

    //Välj
    provides Calculator with FunnyCalculator;
}