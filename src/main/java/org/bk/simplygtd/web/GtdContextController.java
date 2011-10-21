package org.bk.simplygtd.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.bk.simplygtd.service.GtdContextService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@RequestMapping("/gtdcontexts")
@Controller
public class GtdContextController {
	@Resource private GtdContextService gtdContextService;
	

    @RequestMapping(value="list.json", method = RequestMethod.GET)
    public ModelAndView jsonlist(@RequestParam(value = "start", required = false) Integer start, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "page", required = false, defaultValue="1") Integer page) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String userName = ((User)principal).getUsername();    	
		Map<String, Object> modelMap = new HashMap<String, Object>();
    	
    	int sizeNo = limit == null ? 10 : limit.intValue();
    	modelMap.put("gtdcontexts", this.gtdContextService.findContextsByGtdUserName(userName, page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
    	Long totalSize =  this.gtdContextService.countContextsByUserName(userName);
    	modelMap.put("totalSize", totalSize);

    	MappingJacksonJsonView mappingJacksonView = new MappingJacksonJsonView();
		ModelAndView modelAndView = new ModelAndView(mappingJacksonView, modelMap);
		return modelAndView;
    }
    
    @RequestMapping(value="save.json", method = RequestMethod.POST)
    public ModelAndView jsonsave(@RequestBody ContextSaveRequest contextSaveRequest) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String userName = ((User)principal).getUsername();    	
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Long> deleteIds = contextSaveRequest.getDeleteIds();
    	this.gtdContextService.removeContextWithIds(deleteIds);
    	this.gtdContextService.updateContextsForUser(contextSaveRequest.getUpdatedata(), userName);
    	this.gtdContextService.updateContextsForUser(contextSaveRequest.getNewdata(), userName);
    	modelMap.put("success", "true");
    	MappingJacksonJsonView mappingJacksonView = new MappingJacksonJsonView();
		ModelAndView modelAndView = new ModelAndView(mappingJacksonView, modelMap);
		return modelAndView;
    	
    }
    
    
}
