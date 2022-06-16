package com.example.demo.controller;

import com.example.demo.dto.CardDTO;
import com.example.demo.dto.CardSearchDTO;
import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Log4j2
public class CardController {
    private final CardService cardService;
    private final CategoryRepository categoryRepository;

    @GetMapping("/list")
    public void list(Model model, CardSearchDTO searchDTO, @RequestParam(required = false, defaultValue = "0") int page){

        System.out.println(searchDTO);
        PageResultDTO result = cardService.searchCard(searchDTO,page);

        List<Category> list = categoryRepository.findAll(Sort.by("id").descending());

        model.addAttribute("searchdto",searchDTO);
        model.addAttribute("result", result);
        model.addAttribute("categories",list);
    }


}
