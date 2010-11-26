package org.bk.simplygtd.web;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.bk.simplygtd.dao.GtdUserDao;
import org.bk.simplygtd.domain.CustomGtdUserAdapter;
import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;
import org.bk.simplygtd.service.GtdContextService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/gtdcontexts")
@Controller
public class GtdContextController {
	@Resource private GtdContextService gtdContextService;
	@Resource private GtdUserDao gtdUserDao;
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid GtdContext gtdContext, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("gtdcontext", gtdContext);
            return "gtdcontexts/create";
        }
        this.gtdContextService.persist(gtdContext);
        return "redirect:/gtdcontexts/" + encodeUrlPathSegment(gtdContext.getId().toString(), request);
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("gtdcontext", new GtdContext());
        return "gtdcontexts/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("gtdcontext", this.gtdContextService.findById(id));
        model.addAttribute("itemId", id);
        return "gtdcontexts/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model model) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	GtdUser gtdUser1 = ((CustomGtdUserAdapter)principal).getGtdUser();
    	GtdUser gtdUser = this.gtdUserDao.findById(gtdUser1.getId());
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            model.addAttribute("gtdcontexts", this.gtdContextService.findContextsByGtdUser(gtdUser, page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) this.gtdContextService.countContexts(gtdUser) / sizeNo;
            model.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            model.addAttribute("gtdcontexts", this.gtdContextService.findContextsByGtdUser(gtdUser1));
        }
        return "gtdcontexts/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid GtdContext gtdContext, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("gtdcontext", gtdContext);
            return "gtdcontexts/update";
        }
        this.gtdContextService.update(gtdContext);
        return "redirect:/gtdcontexts/" + encodeUrlPathSegment(gtdContext.getId().toString(), request);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("gtdcontext", this.gtdContextService.findById(id));
        return "gtdcontexts/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model model) {
        this.gtdContextService.remove(this.gtdContextService.findById(id));
        model.addAttribute("page", (page == null) ? "1" : page.toString());
        model.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/gtdcontexts?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
    private String encodeUrlPathSegment(String pathSegment, HttpServletRequest request) {
        String enc = request.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
