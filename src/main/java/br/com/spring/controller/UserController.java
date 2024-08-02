package br.com.spring.controller;

import br.com.spring.domain.Users;
import br.com.spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("listar")
    public ModelAndView toList(ModelMap model) {
        model.addAttribute("users", userService.toRecover());
        return new ModelAndView("/users/list", model);
    }

    @GetMapping("/cadastro")
    public String preSave(@ModelAttribute("users") Users users) {
        return "/users/add";
    }

    @PostMapping("/salvar")
    public String toSave(@Valid @ModelAttribute("users") Users users, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/users/add";
        }

        userService.toSave(users);
        attr.addAttribute("mensagem", "Usuário cadastrado com sucesso.");
        return "redirect:/users/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preUpdate(@PathVariable("id") long id, ModelMap model) {
        Users users = userService.recoverById(id);
        model.addAttribute("users", users);
        return new ModelAndView("/users/add", model);
    }

    @PutMapping("/salvar")
    public String toUpdate(@Valid @ModelAttribute("users") Users users, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/users/add";
        }

        userService.toUpdate(users);
        attr.addFlashAttribute("mensagem", "Usário atualizado com sucesso.");
        return "redirect:/users/listar";
    }

    @GetMapping("/{id}/remover")
    public String toDelet(@PathVariable("id") Long id, RedirectAttributes attr) {
        userService.toDelete(id);
        attr.addFlashAttribute("mensagem", "Usário excluído com sucesso.");
        return "redirect:/users/listar";
    }

}
