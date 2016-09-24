package cn.itcast.ssm.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsService {
	// 商品列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	// 根据id查询商品信息
	public ItemsCustom findItemById(Integer id) throws Exception;
	
	// 修改商品信息
	public void saveItem(Integer id,ItemsCustom itemsCustom)throws Exception;
	
	// 返回个json看看
	public void haha(HttpServletRequest request,HttpServletResponse response)throws Exception;
}
