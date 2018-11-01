package com.shop.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.BrandDao;
import com.shop.dao.StyleDao;
import com.shop.domain.Brand;
import com.shop.domain.Style;
import com.shop.service.BrandService;

/**
 * @Description: 品牌业务层实现类
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

	@Resource(name="brandDao")
	private BrandDao brandDao;
	@Resource(name="styleDao")
	private StyleDao styleDao;
	/**
	 * 根据品牌名称获取品牌
	 * @param brandName 品牌名称
	 * @return
	 */
	public Brand getBrandByName(String brandName) {
		return brandDao.getBrandByName(brandName);
	}
	
	/**
	 * 获取所有的品牌
	 */
	@Override
	public List<Brand> getAllBrands() {
		return brandDao.getAllBrand();
	}

	/**
	 * 获取指定页码的款式
	 * @param pageNo 页码
	 * @param pageSize 页码大小
	 * @return
	 */
	public List<Brand> getBrandByPage(int pageNo, int pageSize) {
		List<Brand> brands = brandDao.getAllBrand(pageNo, pageSize);
		//处理品牌中的款式显示：111,111,111
		for(int i = 0;i < brands.size();i++){
			Set<Style> styles = brands.get(i).getStyles();
			if(styles.size()>0){
				Iterator<Style> iterator = styles.iterator();
				StringBuffer buffer = new StringBuffer();
				while(iterator.hasNext()){
					buffer.append(iterator.next().getStyleName()+",");
				}
				brands.get(i).setStyleString(buffer.substring(0,buffer.length()-1));   //去掉最后一个,
			}
		}
		return brands;
	}

	/**
	 * 获取品牌的总数
	 * 
	 */
	public long getBrandCount() {
		return brandDao.getBrandCount();
	}

	/**
	 * 取得品牌的编号
	 * 编号规则：如果没有则设置为400001
	 * 否则为maxId + 1
	 */
	public String getBrandId() {
		String brandId;
		Brand brand = brandDao.getMaxIdBrand();
		if(brand!=null){
			brandId = String.valueOf(Integer.valueOf(brand.getBrandId())+1);
		}
		else {
			brandId = "400001";
		}
		return brandId;
	}

	/**
	 * 根据品牌拼音获取 品牌实力
	 * @param brandSpell 品牌拼音
	 * @return
	 */
	public Brand getBrandBySpell(String brandSpell) {
		return brandDao.getBrandBySpell(brandSpell);
	}

	/**
	 * 根据品牌编号获取品牌实例
	 * @param brandId 品牌编号
	 * @return
	 */
	public Brand getBrandById(String brandId) {
		return brandDao.get(brandId);
	}

	/**
	 * 保存或者修改品牌
	 * @param brand  品牌
	 */
	public void saveOrUpdateBrand(Brand brand) {
		brandDao.saveOrUpdateBrand(brand);
	}

	/**
	 * 根据编号删除品牌实例
	 * @param brandId
	 */
	public void deleteBrand(String brandId) {
		brandDao.delete(brandId);
	}

	//根据分类来获取品牌
	public List<Brand> getBrandByCategory(String categoryId) {
		//获取该分类的款式
		List<Style> styles = styleDao.getStyleByCategory(categoryId);
		//根据款式获取品牌
		Set<Brand> sets = new HashSet<Brand>();
		for (int i = 0; i < styles.size(); i++) {
			List<Brand> brands = brandDao.getBrandByStyleId(styles.get(i).getStyleId());
			sets.addAll(brands);
		}
		return new ArrayList<Brand>(sets);
	}
	
	/**
	 * 获取某个字母开头所有品牌
	 * @param string 开头字母
	 * @return 该字母开头所有品牌
	 */
	public List<Brand> getBrandBypytb(String string) {
		List<Brand> brands = new ArrayList<Brand>();
		//如果是0-9开头的则HQL语句为语句为
		String hql = null;
		if("0-9".equals(string)){
			StringBuffer hqlBuffer = new StringBuffer("from Brand as b where b.brandSpell like ");
			for(int i = 0;i < 9;i++){
				hqlBuffer.append(" '"+i+"%' or b.brandSpell like");
			}
			hqlBuffer.append("'9%'");
			brands = brandDao.getBrandsBypytb(hqlBuffer.toString());
		}
		else{
			hql = "from Brand as b where b.brandSpell like '"+string+"%'";
			brands = brandDao.getBrandsBypytb(hql);
		}
		return brands;
	}
	
	/**
	 * 获取一些款式的品牌
	 * @param styles 款式
	 * @return 品牌
	 */
	public List<Brand> getBrandByStyle(List<Style> styles) {
		Set<Brand> set = new HashSet<Brand>();
		for (int i = 0; i < styles.size(); i++) {
			Style style = styles.get(i);
			List<Brand> brands = brandDao.getBrandByStyleId(style.getStyleId());
			set.addAll(brands);
		}
		return new ArrayList<Brand>(set);
	}

	/**
	 * 根据款式获取品牌
	 * @param styleId 款式编号
	 * @return 该款式的所有品牌
	 */
	public List<Brand> getBrandByStyleId(String styleId) {
		return brandDao.getBrandByStyleId(styleId);
	}
	
	/**
	 * 获取指定数量的品牌
	 * @param count 指定数量
	 * @return 指定数量的品牌信息
	 */
	public List<Brand> getBrand(int count) {
		return brandDao.getBrand(count);
	}	

}
