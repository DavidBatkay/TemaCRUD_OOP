package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertorController {

    @GetMapping("/convert")
    public ModelAndView convertCurrency(@RequestParam double suma, @RequestParam String from,@RequestParam String to,@RequestParam double rate) {
        double result;
        String currency;

        if (from.equalsIgnoreCase("RON") && to.equalsIgnoreCase("EUR")) {
            result = suma / rate;
            currency = "EURO";
        } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("RON")) {
            result = suma * rate;
            currency = "RON";
        } else {
            result = 0;
            currency = "Invalid conversion";
        }

        ModelAndView mav = new ModelAndView("/WEB-INF/views/convert.jsp");
        mav.addObject("result", result);
        mav.addObject("currency", currency);

        return mav;
    }
}
