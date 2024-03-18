package com.rays.pro4.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Bean.LessionBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.LessionModel;

public class LessionTest {
	
	
	

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		// testAdd();
		//testDelete();
		// testLogin();
		// testFindByPk();
		 //testUpdate();
		//testSearch();
		// getRoleid();
		// getList();
		//authenticate();
	}

	


	private static void testSearch() {
		try {
			LessionBean bean = new LessionBean();
			LessionModel model = new LessionModel();
			List list = new ArrayList();
			// bean.setFirstName("Roshani");
			// bean.setLastName("Bandhiye");
			// bean.setLogin("banti@gmail.com");
			// bean.setId(8L);
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (LessionBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getSubject());
				
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testUpdate() throws DuplicateRecordException {
		try {
			LessionBean bean = new LessionBean();
			LessionModel model = new LessionModel();
			bean = model.findByPK(3L);
			bean.setName("ggg");
			bean.setSubject("chemistry");
			
			model.update(bean);

			System.out.println("test update succ");

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testFindByPk() {
		try {
			LessionBean bean = new LessionBean();
			long pk = 5L;
			LessionModel model = new LessionModel();
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getSubject());
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	

	public static void testDelete() throws ApplicationException {
		LessionBean bean = new LessionBean();
		bean.setId(2L);
		LessionModel model = new LessionModel();
		model.delete(bean);

	}

	public static void testAdd() {
		try {
			LessionBean bean = new LessionBean();

			
			bean.setId(1);
			bean.setName("Deepak");
			bean.setSubject("physics");
			
			LessionModel model = new LessionModel();

			long pk = model.add(bean);
			LessionBean addedbean = model.findByPK(pk);
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





