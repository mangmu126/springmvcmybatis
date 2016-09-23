package cn.itcast.ssm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.Service.ItemsService;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception
	{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	@RequestMapping("/editItem")
	public String editItem(Model model,Integer id) throws Exception
	{
		// 调用service查询商品信息
		Items item =itemsService.findItemById(id);
		model.addAttribute("items",item);
		return "items/editItems";
		
	}
	@RequestMapping("/editItemsSubmit")
	public String editItemSubmit(Integer id, ItemsCustom itemsCustom) throws Exception
	{
		System.out.println(itemsCustom);
		itemsService.saveItem(id, itemsCustom);
		return "success";
	}
}
