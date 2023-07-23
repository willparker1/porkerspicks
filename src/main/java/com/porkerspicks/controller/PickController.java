package com.porkerspicks.controller;

import com.porkerspicks.domain.Pick;
import com.porkerspicks.domain.Post;
import com.porkerspicks.service.PickService;
import com.porkerspicks.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("picks")
public class PickController {

    private final PickService pickService;

    public PickController(PickService pickService) {
        this.pickService = pickService;
    }

    @GetMapping("/{postId}")
    public String getAllPicksForPost( @PathVariable Integer postId, Model model ) {
        model.addAttribute("picks", pickService.getAllPicksForPost( postId ) );
        return "posts";
    }

    @GetMapping("/create")
    public String createPick( Model model ) {
        model.addAttribute("pick", new Pick() );
        return "picksForm";
    }

    @GetMapping("/edit/{id}")
    public String editPick( @PathVariable Integer id, Model model  ) {
        model.addAttribute("post", pickService.findPick(id) );
        return "postForm";
    }

    @PostMapping
    public String savePick( Pick pick ) {
        pickService.savePick(pick);
        return "redirect:/picks";
    }

    @PostMapping("/update/{id}")
    public String updatePick( @PathVariable Integer id, Pick pick ) {
        Pick existingPick = pickService.findPick(id);
//        existingPick.setTitle(pick.getTitle());
//        existingPick.setContent(pick.getContent());
        pickService.savePick( existingPick );
        return "redirect:/picks";
    }

    @GetMapping("/delete/{id}")
    public String deletePick( @PathVariable Integer id ) {
        pickService.deletePick( id );
        return "redirect:/picks";
    }
}
