//package ge.tsu.DemoCarsShopApplication.config; // შეცვალეთ თქვენი პაკეტის სახელით
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AppConfigViewer implements CommandLineRunner {
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    @Value("${server.port}")
//    private int serverPort;
//
//    @Value("${myconfig.environment.message}")
//    private String environmentMessage;
//
//    @Value("${external.service.url}")
//    private String externalServiceUrl;
//
//    @Value("${external.api.key}")
//    private String externalApiKey;
//
//    @Value("${report.output.directory}")
//    private String reportOutputDirectory;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("\n--- Spring Boot Application Configuration ---");
//        System.out.println("Application Name: " + appName);
//        System.out.println("Server Port: " + serverPort);
//        System.out.println("Environment Message: " + environmentMessage);
//        System.out.println("External Service URL: " + externalServiceUrl);
//        System.out.println("External API Key: " + externalApiKey);
//        System.out.println("Report Output Directory: " + reportOutputDirectory);
//        System.out.println("----------------------------------------------\n");
//    }
//}