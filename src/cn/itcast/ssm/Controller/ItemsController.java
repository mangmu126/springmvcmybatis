package cn.itcast.ssm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.Service.ItemsService;
import cn.itcast.ssm.po.ItemsCustom;

public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception
	{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		return modelAndView;
	}
	
	
}
