package com.paixie.service;

import java.util.List;

import com.paixie.domain.Brand;
import com.paixie.domain.Style;

/**
 * @Description: Ʒ�Ƶ�ҵ���ӿ�
 */
public interface BrandService {

	/**
	 * ����Ʒ�����ƻ�ȡƷ��
	 * @param brandName Ʒ������
	 * @return
	 */
	Brand getBrandByName(String brandName);

	/**
	 * ��ȡ���е�Ʒ��
	 * @return
	 */
	List<Brand> getAllBrands();

	/**
	 * ��ȡָ��ҳ��Ŀ�ʽ
	 * @param pageNo ҳ��
	 * @param pageSize ҳ���С
	 * @return
	 */
	List<Brand> getBrandByPage(int pageNo, int pageSize);

	/**
	 * ��ȡƷ�Ƶ�����
	 * @return
	 */
	long getBrandCount();

	/**
	 * ȡ��Ʒ�Ƶı��
	 * @return
	 */
	String getBrandId();

	/**
	 * ����Ʒ��ƴ����ȡ Ʒ��ʵ��
	 * @param brandSpell Ʒ��ƴ��
	 * @return
	 */
	Brand getBrandBySpell(String brandSpell);

	/**
	 * ����Ʒ�Ʊ�Ż�ȡƷ��ʵ��
	 * @param brandId Ʒ�Ʊ��
	 * @return
	 */
	Brand getBrandById(String brandId);

	/**
	 * ��������޸�Ʒ��
	 * @param brand  Ʒ��
	 * @param style ��ʽ
	 * ��ʽ��Ҫ��һЩ����
	 */
	void saveOrUpdateBrand(Brand brand, String style);

	/**
	 * ���ݱ��ɾ��Ʒ��ʵ��
	 * @param brandId
	 */
	void deleteBrand(String brandId);
	

	/**
	 * ��ȡĳ����ĸ��ͷƷ��
	 * @param string ��ĸ
	 */
	List<Brand> getBrandBypytb(String string);

	/**
	 * ���ݷ�������ȡƷ��
	 * @param categoryId ������
	 */
	List<Brand> getBrandByCategory(String categoryId);
	
	/**
	 * ���ݿ�ʽ��ȡƷ��
	 * @param styleId ��ʽ���
	 */
	List<Brand> getBrandByStyleId(String styleId);
	
	/**
	 * ��ȡĳЩ��ʽ��Ʒ��
	 */
	List<Brand> getBrandByStyle(List<Style> styles);

	/**
	 * ��ȡָ��������Ʒ��
	 * @param count ָ������
	 */
	List<Brand> getBrand(int count);
}
