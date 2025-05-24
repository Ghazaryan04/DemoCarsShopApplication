package ge.tsu.DemoCarsShopApplication.controller;

import ge.tsu.DemoCarsShopApplication.model.ContactUs;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactUsControler {
    @GetMapping("/contact-us")
    public String contactUs(Model model) {
        model.addAttribute("contactUs", new ContactUs());
        return "contact-us";
    }

    @PostMapping("/contact-us")
    public String contactUs(@Valid @ModelAttribute("contactUs") ContactUs contactUs,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "contact-us";
        }
        redirectAttributes.addAttribute("successMessage ", "Message successfully sent to the contact us");
        return "redirect:/contact-us";
    }

}
