package com.rays.pro4.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Bean.PaymentBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.PaymentModel;

public class PaymentTest {
	

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		// testAdd();
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
			PaymentBean bean = new PaymentBean();
			PaymentModel model = new PaymentModel();
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
				bean = (PaymentBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getType());
				System.out.println(bean.getAmount());
				
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testUpdate() throws DuplicateRecordException {
		try {
			PaymentBean bean = new PaymentBean();
			PaymentModel model = new PaymentModel();
			bean = model.findByPK(3L);
			bean.setType("Deepak");
			bean.setAmount(200);
			
			model.update(bean);

			System.out.println("test update succ");

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testFindByPk() {
		try {
			PaymentBean bean = new PaymentBean();
			long pk = 5L;
			PaymentModel model = new PaymentModel();
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getType());
			System.out.println(bean.getAmount());
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	

	public static void testDelete() throws ApplicationException {
		PaymentBean bean = new PaymentBean();
		bean.setId(2L);
		PaymentModel model = new PaymentModel();
		model.delete(bean);

	}

	public static void testAdd() {
		try {
			PaymentBean bean = new PaymentBean();

			
			bean.setId(1);
			bean.setType("Ankush");
			bean.setAmount(400);
			
			PaymentModel model = new PaymentModel();

			long pk = model.add(bean);
			PaymentBean addedbean = model.findByPK(pk);
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






