package cn.itcast.ssm.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/editItemsSubmit",method={RequestMethod.POST})
	public String editItemSubmit(Integer id, ItemsCustom itemsCustom) throws Exception
	{
		System.out.println(itemsCustom);
		itemsService.saveItem(id, itemsCustom);
		return "success";
	}
	@RequestMapping("/maomao")
	public void haha(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"hahah\":\"maoamo\"}");

	}
	
}
