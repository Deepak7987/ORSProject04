package com.rays.pro4.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Bean.BankBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.BankModel;

public class BankTest {
	
	

		public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
			// testAdd();
			//testDelete();
			// testLogin();
			// testFindByPk();
			// testUpdate();
			//testSearch();
			// getRoleid();
			// getList();
			//authenticate();
		}

		


		private static void testSearch() {
			try {
				BankBean bean = new BankBean();
				BankModel model = new BankModel();
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
					bean = (BankBean) it.next();
					System.out.println(bean.getId());
					System.out.println(bean.getName());
					System.out.println(bean.getAmount());
					
				}
			} catch (ApplicationException e) {
				e.printStackTrace();
			}

		}

		private static void testUpdate() throws DuplicateRecordException {
			try {
				BankBean bean = new BankBean();
				BankModel model = new BankModel();
				bean = model.findByPK(3L);
				bean.setName("Deepak");
				bean.setAmount(200);
				
				model.update(bean);

				System.out.println("test update succ");

			} catch (ApplicationException e) {
				e.printStackTrace();
			}

		}

		private static void testFindByPk() {
			try {
				BankBean bean = new BankBean();
				long pk = 5L;
				BankModel model = new BankModel();
				bean = model.findByPK(pk);
				if (bean == null) {
					System.out.println("Test find by pk fail");
				}
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getAmount());
				
			} catch (ApplicationException e) {
				e.printStackTrace();
			}

		}

		

		public static void testDelete() throws ApplicationException {
			BankBean bean = new BankBean();
			bean.setId(2L);
			BankModel model = new BankModel();
			model.delete(bean);

		}

		public static void testAdd() {
			try {
				BankBean bean = new BankBean();

				
				bean.setId(1);
				bean.setName("Kapil");
				bean.setAmount(100);
				
				BankModel model = new BankModel();

				long pk = model.add(bean);
				BankBean addedbean = model.findByPK(pk);
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



