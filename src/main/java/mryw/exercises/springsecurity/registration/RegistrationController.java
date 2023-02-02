package mryw.exercises.springsecurity.registration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/addregistration")
    public String addRegistration(@ModelAttribute Registration registration){
        registrationService.create(registration);
        return "registration";
    }

    @PatchMapping("/approve")
    public String approveRegistration(@RequestParam Long id, @RequestParam(defaultValue = "false") Boolean approved, Model model){
        registrationService.approveRegistration(id, approved);
        model.addAttribute("registrations", registrationService);
        return "registrations";
    }

    @GetMapping("/registration/{id}")
    public String getRegistration(@PathVariable Long id, Model model){
        registrationService.findById(id);
        model.addAttribute("registration", registrationService);
        return  "confirm";
    }

    @GetMapping("/registrations")
    private String getAllRegistrations(Model model){
        registrationService.findAll();
        model.addAttribute("registrations", registrationService);
        return "registrations";
    }

    @GetMapping({"/", "/index", "index.html"})
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("user", request.getRemoteUser());
        return "index";
    }
}
