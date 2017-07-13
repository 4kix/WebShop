package com.falko.controller;

import com.falko.model.Sale;
import com.falko.service.interfaces.CartService;
import com.falko.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.falko.service")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("cartSize", cartService.getAmountOfSales());
        model.addAttribute("user", getPrincipal());
    }

    @RequestMapping(value="cart/add", method = RequestMethod.POST)
    public ModelAndView addSaleToCart(@RequestParam("id") final int idOfProduct, @RequestParam("url") final String url) {
        Sale sale = new Sale(productService.getProductById(idOfProduct), 1);
        cartService.addSale(sale);
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping(value="cart/addAmount", method = RequestMethod.POST)
    public ModelAndView addAmountOfSaleToCart(@RequestParam("amount") final int amount, @RequestParam("id") final int id, @RequestParam("url") final String url) {
        cartService.addSale(new Sale(productService.getProductById(id), amount));
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping(value="cart/view", method = RequestMethod.GET)
    public ModelAndView viewCart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("sales", cartService.getSales());
        modelAndView.addObject("finalPrice", cartService.getFinalPrice());
        return modelAndView;
    }

    @RequestMapping(value="cart/remove/{idOfProduct}", method = RequestMethod.GET)
    public ModelAndView removeSale(@PathVariable("idOfProduct") final int idOfProduct) {
        cartService.removeSale(new Sale(productService.getProductById(idOfProduct)));
        return new ModelAndView("redirect:/cart/view");
    }

    @RequestMapping(value="cart/plus/{idOfProduct}", method = RequestMethod.GET)
    public ModelAndView plusSale(@PathVariable("idOfProduct") final int idOfProduct) {
        cartService.addSale(new Sale(productService.getProductById(idOfProduct), 1));
        return new ModelAndView("redirect:/cart/view");
    }

    @RequestMapping(value="cart/minus/{idOfProduct}", method = RequestMethod.GET)
    public ModelAndView minusSale(@PathVariable("idOfProduct") final int idOfProduct) {
        cartService.addSale(new Sale(productService.getProductById(idOfProduct), -1));
        return new ModelAndView("redirect:/cart/view");
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
