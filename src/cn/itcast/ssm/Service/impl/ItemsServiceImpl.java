package cn.itcast.ssm.Service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.Service.ItemsService;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public ItemsCustom findItemById(Integer id) throws Exception {
		// TODO Auto-generated method stub
			Items items = itemsMapper.selectByPrimaryKey(id);
			ItemsCustom itemsCustom = null;
			if(items!=null)
			{
				itemsCustom = new ItemsCustom();
				BeanUtils.copyProperties(items, itemsCustom);
			}
			return itemsCustom;	
	}
	@Override
	public void saveItem(Integer id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	

}
