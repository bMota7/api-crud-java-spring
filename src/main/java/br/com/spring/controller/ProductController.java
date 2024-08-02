package br.com.spring.controller;

import br.com.spring.domain.Products;
import br.com.spring.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listar")
    public ModelAndView toList(Long usersId, ModelMap model) {
        model.addAttribute("products", productService.toRecover());
        return new ModelAndView("/products/list", model);
    }

    @GetMapping("/cadastro")
    public String preSave(Products products) {
        return "/products/add";
    }

    @PostMapping("/salvar")
    public String toSave(@Valid @ModelAttribute("products") Products products, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/products/add";
        }

        productService.toSave(products);
        attr.addFlashAttribute("mensagem", "Produto cadastrado com sucesso.");
        return "redirect:/products/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preUpdate(@PathVariable("id") long id, ModelMap model) {
        Products products = productService.recoverById(id);
        model.addAttribute("products", products);
        return new ModelAndView("/products/add", model);
    }

    @PutMapping("/salvar")
    public String toUpdate(@Valid @ModelAttribute("products") Products products, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/products/add";
        }

        productService.toUpdate(products);
        attr.addFlashAttribute("mensagem", "Produto atualizado com sucesso.");
        return "redirect:/products/listar";
    }

    @GetMapping("/{id}/remover")
    public String toDelete(Long id, RedirectAttributes attr) {
        productService.toDelete(id);
        attr.addFlashAttribute("mensagem", "Produto excluído com sucesso.");
        return "redirect:/products/listar";
    }

}
