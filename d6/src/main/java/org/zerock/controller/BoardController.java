package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	@Setter(onMethod_={@Autowired})	
	private BoardService service;
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("register get............");
		
	}
	
	@PostMapping("/register")
	public String registerPost(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("register post....");
		
		try {
			service.register(vo);
			rttr.addFlashAttribute("msg", "success");	
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri")Criteria cri, Model model)throws Exception {
		
		log.info("list....................");
		
		model.addAttribute("list", service.getList(cri));
		
		int totalCount = service.getTotal(cri);
		
		PageMaker pm = new PageMaker(cri, totalCount);
		
		model.addAttribute("pageMaker",pm);
		
		
	}
	
}






