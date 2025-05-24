package ge.tsu.DemoCarsShopApplication.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // მიუთითეთ სად არის თქვენი message ფაილები
        messageSource.setBasenames("classpath:messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600); // ქეშის განახლების სიხშირე
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        // SessionLocaleResolver ინახავს ენას მომხმარებლის სესიაში
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // დააყენეთ ნაგულისხმევი ენა
        localeResolver.setDefaultLocale(Locale.ENGLISH); // ან Locale.of("en")
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // LocaleChangeInterceptor საშუალებას აძლევს ენის შეცვლას URL პარამეტრის მეშვეობით (მაგალითად ?lang=ka)
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang"); // პარამეტრის სახელი URL-ში
        registry.addInterceptor(localeChangeInterceptor);
    }
}