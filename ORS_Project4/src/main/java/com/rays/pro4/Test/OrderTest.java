package com.rays.pro4.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Bean.OrderBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.OrderModel;

public class OrderTest {
	
	
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
			OrderBean bean = new OrderBean();
			OrderModel model = new OrderModel();
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
				bean = (OrderBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDob());
				System.out.println(bean.getOrdertype());
				
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testUpdate() throws DuplicateRecordException {
		try {
			OrderBean bean = new OrderBean();
			OrderModel model = new OrderModel();
			bean = model.findByPK(3L);
			bean.setName("Deepak");
			bean.setDob("06/09/1995");
			bean.setOrdertype("online");
			
			model.update(bean);

			System.out.println("test update succ");

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testFindByPk() {
		try {
			OrderBean bean = new OrderBean();
			long pk = 5L;
			OrderModel model = new OrderModel();
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDob());
			System.out.println(bean.getOrdertype());
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	

	public static void testDelete() throws ApplicationException {
		OrderBean bean = new OrderBean();
		bean.setId(2L);
		OrderModel model = new OrderModel();
		model.delete(bean);

	}

	public static void testAdd() {
		try {
			OrderBean bean = new OrderBean();

			
			bean.setId(1);
			bean.setName("Ankush");
			bean.setDob("27/04/1996");
			bean.setOrdertype("cash");
			
			OrderModel model = new OrderModel();

			long pk = model.add(bean);
			OrderBean addedbean = model.findByPK(pk);
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









