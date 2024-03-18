package com.rays.pro4.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Bean.ProductBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.ProductModel;

public class ProductTest {
	
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		//testAdd();
		//testDelete();
		// testLogin();
		// testFindByPk();
		// testUpdate();
	testSearch();
		// getRoleid();
		// getList();
		//authenticate();
	}

	


	private static void testSearch() {
		try {
			ProductBean bean = new ProductBean();
			ProductModel model = new ProductModel();
			List list = new ArrayList();
			// bean.setFirstType("Roshani");
			// bean.setLastType("Bandhiye");
			// bean.setLogin("banti@gmail.com");
			// bean.setId(8L);
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (ProductBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getSize());
				System.out.println(bean.getPrize());
				
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testUpdate() throws DuplicateRecordException {
		try {
			ProductBean bean = new ProductBean();
			ProductModel model = new ProductModel();
			bean = model.findByPK(3L);
			bean.setName("Soap");
			bean.setDescription("Soap");
			bean.setSize("3");
			bean.setPrize("30");
			
			model.update(bean);

			System.out.println("test update succ");

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testFindByPk() {
		try {
			ProductBean bean = new ProductBean();
			long pk = 5L;
			ProductModel model = new ProductModel();
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getSize());
			System.out.println(bean.getPrize());
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	

	public static void testDelete() throws ApplicationException {
		ProductBean bean = new ProductBean();
		bean.setId(2L);
		ProductModel model = new ProductModel();
		model.delete(bean);

	}

	public static void testAdd() {
		try {
			ProductBean bean = new ProductBean();

			
			bean.setId(1);
			bean.setName("Dove");
			bean.setDescription("this is soap");
			bean.setSize("4");
			bean.setPrize("50");
			ProductModel model = new ProductModel();

			long pk = model.add(bean);
			ProductBean addedbean = model.findByPK(pk);
			System.out.println("Test add succ");

			if (addedbean == null) {
				System.out.println("Test add fail");
			}

			System.out.println("record insert");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}












