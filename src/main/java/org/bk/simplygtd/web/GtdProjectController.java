package org.bk.simplygtd.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.bk.simplygtd.domain.GtdProject;
import org.bk.simplygtd.service.GtdProjectService;
import org.bk.simplygtd.types.TypeWrapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@RequestMapping("/gtdprojects")
@Controller
public class GtdProjectController {
	@Resource private GtdProjectService gtdProjectService;
	

    @RequestMapping(value="read.json", method = RequestMethod.GET)
    public @ResponseBody Map<String, ? extends Object> jsonlist(@RequestParam(value = "start", required = false) Integer start, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "page", required = false, defaultValue="1") Integer page) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String userName = ((User)principal).getUsername();    	
		Map<String, Object> modelMap = new HashMap<String, Object>();
    	
    	int sizeNo = limit == null ? 10 : limit.intValue();
    	modelMap.put("data", this.gtdProjectService.findGTDProjectsByGtdUser(userName, page==null?0:(page.intValue()-1)*sizeNo, sizeNo));
    	Long totalSize =  this.gtdProjectService.countProjectsByUserName(userName);
    	modelMap.put("totalSize", totalSize);
		return modelMap;
    }

    @RequestMapping(value="create.json", method = RequestMethod.POST)
    public ModelAndView jsoncreate(@RequestBody GtdProject gtdProject) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String userName = ((User)principal).getUsername();    	
		Map<String, Object> modelMap = new HashMap<String, Object>();
		GtdProject gtdProjectUpdated = this.gtdProjectService.persistForUser(gtdProject, userName);
    	modelMap.put("success", "true");
    	modelMap.put("data", Collections.singletonList(gtdProjectUpdated));
    	MappingJacksonJsonView mappingJacksonView = new MappingJacksonJsonView();
		ModelAndView modelAndView = new ModelAndView(mappingJacksonView, modelMap);
		return modelAndView;
    	
    }

    @RequestMapping(value="update.json", method = RequestMethod.POST)
    public @ResponseBody TypeWrapper<GtdProject> jsonupdate(@RequestBody GtdProject gtdProject) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String userName = ((User)principal).getUsername();    	
//		Map<String, Object> modelMap = new HashMap<String, Object>();
		GtdProject gtdProjectUpdated = this.gtdProjectService.updateForUser(gtdProject, userName);
//    	modelMap.put("success", "true");
//    	modelMap.put("data", Collections.singletonList(gtdProjectUpdated));
//    	MappingJacksonJsonView mappingJacksonView = new MappingJacksonJsonView();
//		ModelAndView modelAndView = new ModelAndView(mappingJacksonView, modelMap);
		return new TypeWrapper<GtdProject>(Collections.singletonList(gtdProjectUpdated), true);
    	
    }

    @RequestMapping(value="delete.json", method = RequestMethod.POST)
    public ModelAndView jsondelete(@RequestBody GtdProject gtdProject) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		this.gtdProjectService.remove(this.gtdProjectService.findById(gtdProject.getId()));
    	modelMap.put("success", "true");
    	MappingJacksonJsonView mappingJacksonView = new MappingJacksonJsonView();
		ModelAndView modelAndView = new ModelAndView(mappingJacksonView, modelMap);
		return modelAndView;
    }
}
