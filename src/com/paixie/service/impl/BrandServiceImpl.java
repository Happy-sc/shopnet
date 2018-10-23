package com.paixie.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.BrandDao;
import com.paixie.dao.StyleDao;
import com.paixie.domain.Brand;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;

/**
 * @Description: Ʒ��ҵ���ʵ����
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

	@Resource(name="brandDao")
	private BrandDao brandDao;
	@Resource(name="styleDao")
	private StyleDao styleDao;
	/**
	 * ����Ʒ�����ƻ�ȡƷ��
	 * @param brandName Ʒ������
	 * @return
	 */
	public Brand getBrandByName(String brandName) {
		return brandDao.getBrandByName(brandName);
	}
	
	/**
	 * ��ȡ���е�Ʒ��
	 */
	@Override
	public List<Brand> getAllBrands() {
		return brandDao.getAllBrand();
	}

	/**
	 * ��ȡָ��ҳ��Ŀ�ʽ
	 * @param pageNo ҳ��
	 * @param pageSize ҳ���С
	 * @return
	 */
	public List<Brand> getBrandByPage(int pageNo, int pageSize) {
		List<Brand> brands = brandDao.getAllBrand(pageNo, pageSize);
		//����Ʒ���еĿ�ʽ��ʾ��111,111,111
		for(int i = 0;i < brands.size();i++){
			Set<Style> styles = brands.get(i).getStyles();
			if(styles.size()>0){
				Iterator<Style> iterator = styles.iterator();
				StringBuffer buffer = new StringBuffer();
				while(iterator.hasNext()){
					buffer.append(iterator.next().getStyleName()+",");
				}
				brands.get(i).setStyleString(buffer.substring(0,buffer.length()-1));   //ȥ�����һ��,
			}
		}
		return brands;
	}

	/**
	 * ��ȡƷ�Ƶ�����
	 * 
	 */
	public long getBrandCount() {
		return brandDao.getBrandCount();
	}

	/**
	 * ȡ��Ʒ�Ƶı��
	 * ��Ź������û��������Ϊ400001
	 * ����ΪmaxId + 1
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
	 * ����Ʒ��ƴ����ȡ Ʒ��ʵ��
	 * @param brandSpell Ʒ��ƴ��
	 * @return
	 */
	public Brand getBrandBySpell(String brandSpell) {
		return brandDao.getBrandBySpell(brandSpell);
	}

	/**
	 * ����Ʒ�Ʊ�Ż�ȡƷ��ʵ��
	 * @param brandId Ʒ�Ʊ��
	 * @return
	 */
	public Brand getBrandById(String brandId) {
		return brandDao.get(brandId);
	}

	/**
	 * ��������޸�Ʒ��
	 * @param brand  Ʒ��
	 * @param style ��ʽ
	 */
	public void saveOrUpdateBrand(Brand brand, String style) {
		//�����ʽ
		String[] styles = style.split(",");
		Set<Style> styleSet = new HashSet<Style>();
		for(int i = 0;i < styles.length;i++){
			//���ݿ�ʽ��ȡ��ʽʵ��
			Style style2 = styleDao.getStyleByName(styles[i]);
			styleSet.add(style2);
		}
		brand.setStyles(styleSet);
		
		//�����ʽ
		brandDao.saveOrUpdateBrand(brand);
	}

	/**
	 * ���ݱ��ɾ��Ʒ��ʵ��
	 * @param brandId
	 */
	public void deleteBrand(String brandId) {
		brandDao.delete(brandId);
	}

	//���ݷ�������ȡƷ��
	public List<Brand> getBrandByCategory(String categoryId) {
		//��ȡ�÷���Ŀ�ʽ
		List<Style> styles = styleDao.getStyleByCategory(categoryId);
		//���ݿ�ʽ��ȡƷ��
		Set<Brand> sets = new HashSet<Brand>();
		for (int i = 0; i < styles.size(); i++) {
			List<Brand> brands = brandDao.getBrandByStyleId(styles.get(i).getStyleId());
			sets.addAll(brands);
		}
		return new ArrayList<Brand>(sets);
	}
	
	/**
	 * ��ȡĳ����ĸ��ͷ����Ʒ��
	 * @param string ��ͷ��ĸ
	 * @return ����ĸ��ͷ����Ʒ��
	 */
	public List<Brand> getBrandBypytb(String string) {
		List<Brand> brands = new ArrayList<Brand>();
		//�����0-9��ͷ����HQL���Ϊ���Ϊ
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
	 * ��ȡһЩ��ʽ��Ʒ��
	 * @param styles ��ʽ
	 * @return Ʒ��
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
	 * ���ݿ�ʽ��ȡƷ��
	 * @param styleId ��ʽ���
	 * @return �ÿ�ʽ������Ʒ��
	 */
	public List<Brand> getBrandByStyleId(String styleId) {
		return brandDao.getBrandByStyleId(styleId);
	}
	
	/**
	 * ��ȡָ��������Ʒ��
	 * @param count ָ������
	 * @return ָ��������Ʒ����Ϣ
	 */
	public List<Brand> getBrand(int count) {
		return brandDao.getBrand(count);
	}	

}
