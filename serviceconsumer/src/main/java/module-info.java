module org.example.modules.serviceconsumer {
    //Behöver service-modulen
    requires org.example.modules.service;
    //Använder interfacet Calculator
    uses org.example.modules.service.calculator.Calculator;
}