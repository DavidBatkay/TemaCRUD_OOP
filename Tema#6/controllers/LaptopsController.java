package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LaptopsController {

    @GetMapping("/laptops")
    public ModelAndView getLaptopBrand(@RequestParam("brand") String brand) {
        int length = brand.length();
        String parity = (length % 2 == 0) ? "par" : "impar";

        ModelAndView mav = new ModelAndView("/WEB-INF/views/laptops.jsp");
        mav.addObject("brand", brand);
        mav.addObject("length", length);
        mav.addObject("parity", parity);

        return mav;
    }
    
    @GetMapping("/laptop")
    public ModelAndView displayLaptop() {
        Laptop laptop = new Laptop("Dell", 2500, 16);

        ModelAndView mav = new ModelAndView("/WEB-INF/views/laptop.jsp");
        mav.addObject("lap", laptop);

        return mav;
    }

}
