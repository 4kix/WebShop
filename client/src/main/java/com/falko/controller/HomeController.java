package com.falko.controller;

import com.falko.model.Product;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@ComponentScan(basePackages = "com.falko.service")
public class HomeController {

    private final CountryService countryService;

    private final ProductService productService;

    private final TypeService typeService;

    private final CartService cartService;

    @Autowired
    public HomeController(final CountryService countryService, final ProductService productService, final TypeService typeService, final CartService cartService) {
        this.countryService = countryService;
        this.productService = productService;
        this.typeService = typeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
        model.addAttribute("user", getPrincipal());
    }

    @RequestMapping(value = {"", "/", "/index", "/home"}, method = RequestMethod.GET)
    public ModelAndView viewAllProductsOnFirstPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getAllProduct(1, 6);
        int amountOfProduct = productService.getAllProduct().size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6 + 1));
        modelAndView.addObject("url", "/home/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/home/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewAllProductsOnSpecificPage(@PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getAllProduct(numberOfPage, 6);
        int amountOfProduct = productService.getAllProduct().size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6 + 1));
        modelAndView.addObject("url", "/home/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public void showImage(@PathVariable("id") final int id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(productService.getProductById(id).getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
    public ModelAndView viewSpecificTypeProductsOnFirstPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getProductsByType(id, 1, 6);
        int amountOfProduct = productService.getProductsByType(id).size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6 + 1));
        modelAndView.addObject("url", "/type/" + id + "/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/type/{id}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewSpecificTypeProductsOnSpecificPage(@PathVariable("id") final int id, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getProductsByType(id, numberOfPage, 6);
        int amountOfProduct = productService.getProductsByType(id).size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6 + 1));
        modelAndView.addObject("url", "/type/" + id + "/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    public ModelAndView viewSpecificCountryProductsOnFirstPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getProductsByCountry(id, 1, 6);
        int amountOfProduct = productService.getProductsByCountry(id).size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6 + 1));
        modelAndView.addObject("url", "/country/" + id + "/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/country/{id}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewSpecificCountryProductsOnSpecificPage(@PathVariable("id") final int id,  @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getProductsByCountry(id, numberOfPage, 6);
        int amountOfProduct = productService.getProductsByCountry(id).size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6  + 1));
        modelAndView.addObject("url", "/country/" + id + "/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchProducts(@RequestParam("searchValue") final String searchValue) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getProductsBySearch(new String (searchValue.getBytes ("iso-8859-1"), "UTF-8"), 1, 6);
        int amountOfProduct = productService.getProductsBySearch(new String (searchValue.getBytes ("iso-8859-1"), "UTF-8")).size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6  + 1));
        modelAndView.addObject("url", "/search/");
        modelAndView.addObject("openedPage", 1);
        modelAndView.addObject("searchValue", new String (searchValue.getBytes ("iso-8859-1"), "UTF-8"));
        return modelAndView;
    }

    @RequestMapping(value = "/search/{searchValue}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView searchProducts(@PathVariable("searchValue") final String searchValue, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.getProductsBySearch(searchValue, numberOfPage, 6);
        int amountOfProduct = productService.getProductsBySearch(searchValue).size();
        modelAndView.addObject("products", productList);
        modelAndView.addObject("amountOfPages", (amountOfProduct % 6 == 0) ? (amountOfProduct / 6) : (amountOfProduct / 6  + 1));
        modelAndView.addObject("url", "/search/");
        modelAndView.addObject("openedPage", numberOfPage);
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
