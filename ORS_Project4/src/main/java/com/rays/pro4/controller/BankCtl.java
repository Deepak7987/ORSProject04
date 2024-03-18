package com.rays.pro4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.pro4.Bean.BankBean;
import com.rays.pro4.Bean.BaseBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.BankModel;
import com.rays.pro4.Util.DataUtility;
import com.rays.pro4.Util.DataValidator;
import com.rays.pro4.Util.PropertyReader;
import com.rays.pro4.Util.ServletUtility;

@WebServlet(name = "BankCtl", urlPatterns = { "/ctl/BankCtl" })
public class BankCtl  extends BaseCtl{

	@Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("uctl Validate");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name","First name must contains alphabet only");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("amount"))) {
			request.setAttribute("amount", PropertyReader.getValue("error.require", " amount"));
			pass = false;
		} else if (!DataValidator.isInteger(request.getParameter("amount"))) {
			request.setAttribute("amount", "Last name must contains alphabet only");
			pass = false;
		}
		

		return pass;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#populateBean(javax.servlet.http.
	 * HttpServletRequest)
	 */

	protected BaseBean populateBean(HttpServletRequest request) {
		System.out.println(" uctl Base bean P bean");

		BankBean bean = new BankBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));

		bean.setName(DataUtility.getString(request.getParameter("name")));

		bean.setAmount(DataUtility.getInt(request.getParameter("amount")));

		
		populateDTO(bean, request);


		return bean;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		log.debug("BankCtl Method doGet Started");
	System.out.println("u ctl do get 1111111");
		String op = DataUtility.getString(request.getParameter("operation"));
//		// get model
		BankModel model = new BankModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			System.out.println("in id > 0  condition");
			BankBean bean;
			try {
				bean = model.findByPK(id);
				System.out.println("Ankit11111111111");
			System.out.println(bean);
				ServletUtility.setBean(bean, request);
			} catch (ApplicationException e) {
			//log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
			}
		}
		
		ServletUtility.forward(ORSView.BANK_VIEW, request, response);
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("uctl Do Post");

System.out.println("dopodt ....");
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println(op);
		long id = DataUtility.getLong(request.getParameter("id"));

		System.out.println(">>>><<<<>><<><<><<><>**********" + id + op);
		BankBean bean = (BankBean) populateBean(request);
		BankModel model = new BankModel();
		if ( OP_UPDATE.equalsIgnoreCase(op)) {
			
			System.out.println(" search chalii ctl DoPost 11111111");

			bean.getId();
				

					// System.out.println("hi i am in dopost update");
					try {
						model.update(bean);
					} catch (ApplicationException | DuplicateRecordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ServletUtility.setBean(bean, request);
					System.out.println(" U ctl DoPost 222222");
					ServletUtility.setSuccessMessage("Bank is successfully Updated", request);
					ServletUtility.forward(getView(), request, response);
				
			}else if(OP_SAVE.equalsIgnoreCase(op)) {
					System.out.println(" save chaliii.... DoPost 33333");
					
					long pk;
			
						try {
							pk = model.add(bean);
							bean.setId(pk);
						} catch (ApplicationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DuplicateRecordException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						 ServletUtility.setBean(bean, request);

							ServletUtility.setSuccessMessage("Bank is successfully Added", request);
					
					ServletUtility.forward(getView(), request, response);
					
					
				}
				/*
				 * ServletUtility.setBean(bean, request);
				 * ServletUtility.setSuccessMessage("Bank is successfully saved", request);
				 */

			
		 else if (OP_DELETE.equalsIgnoreCase(op)) {
			System.out.println(" U ctl D p 5555555");

			 bean = (BankBean) populateBean(request);
			try {
				model.delete(bean);
				System.out.println(" u ctl D Post  6666666");
				ServletUtility.redirect(ORSView.BANK_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			System.out.println(" U  ctl Do post 77777");

			ServletUtility.redirect(ORSView.BANK_LIST_CTL, request, response);
			return;
		}
//		ServletUtility.forward(getView(), request, response);


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#getView()
	 */
	@Override
	protected String getView() {
		return ORSView.BANK_VIEW;
	}

}



