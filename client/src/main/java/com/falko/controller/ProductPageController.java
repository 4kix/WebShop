package com.falko.controller;

import com.falko.service.interfaces.CartService;
import com.falko.service.interfaces.CountryService;
import com.falko.service.interfaces.ProductService;
import com.falko.service.interfaces.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.falko.service")
public class ProductPageController {

    private final CountryService countryService;

    private final ProductService productService;

    private final TypeService typeService;

    private final CartService cartService;

    @Autowired
    public ProductPageController(final CountryService countryService, final ProductService productService, final TypeService typeService, final CartService cartService) {
        this.countryService = countryService;
        this.productService = productService;
        this.typeService = typeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
    }

    @ModelAttribute
    public void leftMenu(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @RequestMapping(value="/product-details/{id}", method = RequestMethod.GET)
    public ModelAndView viewProductInfo(@PathVariable("id") final int idOfProduct) {
        ModelAndView modelAndView = new ModelAndView("product-details");
        modelAndView.addObject("product", productService.getProductById(idOfProduct));
        modelAndView.addObject("recommendedProducts1", productService.getAllProduct(1, 3));
        modelAndView.addObject("recommendedProducts2", productService.getAllProduct(2, 3));
        return modelAndView;
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}