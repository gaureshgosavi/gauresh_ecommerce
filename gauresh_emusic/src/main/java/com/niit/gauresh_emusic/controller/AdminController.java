package com.niit.gauresh_emusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Category;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.Supplier;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Category category;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;

	// product list
	@RequestMapping("/viewProducts")
	public ModelAndView getAllProducts(@RequestParam(value = "msg", required = false) String msg) {
		ModelAndView model = new ModelAndView("page");
		model.addObject("product", product);
		model.addObject("productList", productDAO.list());

		model.addObject("categoryList", categoryDAO.list());
		model.addObject("supplierList", supplierDAO.list());

		if (msg != null)
			model.addObject("msg", msg);
		model.addObject("ifUserClickedViewProducts", true);
		return model;
	}

	// edit product
	@RequestMapping("/viewProducts/edit/{productId}")
	public ModelAndView editProduct(@PathVariable("productId") int id) {
		ModelAndView model = new ModelAndView("page");
		product = productDAO.get(id);
		model.addObject("product", product);

		model.addObject("categoryList", categoryDAO.list());
		model.addObject("supplierList", supplierDAO.list());
		model.addObject("productList", productDAO.list());

		model.addObject("ifUserClickedViewProducts", true);
		return model;
	}

	// delete product
	@RequestMapping("/viewProducts/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") int id) {
		ModelAndView model = new ModelAndView("page");
		String msg;
		product = productDAO.get(id);
		boolean flag = productDAO.delete(product);
		if (flag == true)
			msg = "Product deleted successfully";
		else
			msg = "Operation could not success";
		model.addObject("ifUserClickedDeleteProduct", true);
		return "redirect:/admin/viewProducts?msg=" + msg;
	}

	// category list
	@RequestMapping("/viewCategories")
	public ModelAndView getAllCategories(@RequestParam(value = "msg", required = false) String msg) {
		ModelAndView model = new ModelAndView("page");
		model.addObject("category", category);
		model.addObject("categoryList", categoryDAO.list());
		if (msg != null)
			model.addObject("msg", msg);
		model.addObject("ifUserClickedViewCategories", true);
		return model;
	}

	// add category
	@RequestMapping("/viewCategories/add")
	public String addCategory() {
		ModelAndView model = new ModelAndView("page");
		String msg;
		if (categoryDAO.create(category) == true)
			msg = "Successfully added new category";
		else
			msg = "Failed to create new category";
		return "redirect:/admin/viewCategories?msg=" + msg;
	}

	// update category
	@RequestMapping(value = "/viewCategories/update")
	public String updateCategory(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		String msg;
		category= categoryDAO.get(id);
		if (categoryDAO.saveOrUpdate(category) == true)
			msg = "Successfully added new category";
		else
			msg = "Failed to create new category";
		return "redirect:/admin/viewCategories?msg=" + msg;
	}

	// edit category
	@RequestMapping("/viewCategories/edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		category = categoryDAO.get(id);
		model.addObject("category", category);

		model.addObject("categoryList", categoryDAO.list());

		model.addObject("ifUserClickedEditCategory", true);
		return model;
	}

	// delete category
	@RequestMapping("/viewCategories/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		String msg;
		category = categoryDAO.get(id);
		boolean flag = categoryDAO.delete(category);
		if (flag == true)
			msg = "category deleted successfully";
		else
			msg = "Operation could not success";
		model.addObject("ifUserClickedDeleteCategory", true);
		return "redirect:/admin/viewCategories?msg=" + msg;
	}

	// supplier list
	@RequestMapping("/viewSuppliers")
	public ModelAndView getAllSupplier(@RequestParam(value = "msg", required = false) String msg) {
		ModelAndView model = new ModelAndView("page");
		model.addObject("supplier", supplier);
		model.addObject("supplierList", supplierDAO.list());
		if(msg != null)
			model.addObject("msg", msg);
		model.addObject("ifUserClickedViewSuppliers", true);
		return model;
	}

	// add supplier
	@RequestMapping(value = "/viewSuppliers/add")
	public String addsupplier(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		String msg;
		if (supplierDAO.saveOrUpdate(supplier) == true)
			msg = "Successfully added new supplier";
		else
			msg = "Failed to create new supplier";
		return "redirect:/admin/viewSuppliers?msg=msg";
	}
	
	// update supplier
		@RequestMapping(value = "/viewSuppliers/add")
		public String updateSupplier(@PathVariable("id") int id) {
			ModelAndView model = new ModelAndView("page");
			supplier= supplierDAO.get(id);
			String msg;
			if (supplierDAO.saveOrUpdate(supplier) == true)
				msg = "Successfully added new supplier";
			else
				msg = "Failed to create new supplier";
			return "redirect:/admin/viewSuppliers?msg="+msg;
		}

	// edit supplier
	@RequestMapping("/viewSuppliers/edit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		supplier = supplierDAO.get(id);
		model.addObject("supplier", supplier);
		
		model.addObject("supplierList", supplierDAO.list());
		
		model.addObject("ifUserClickedEditSupplier", true);
		return model;
	}

	// delete supplier
	@RequestMapping("/viewSuppliers/delete/{id}")
	public String deleteSupplier(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		String msg;
		supplier = supplierDAO.get(id);
		boolean flag = productDAO.delete(product);
		if (flag == true)
			msg = "Supplier deleted successfully";
		else
			msg = "Operation could not success";
		model.addObject("ifUserClickedDeleteSupplier", true);
		return "redirect:/admin/viewSuppliers?msg="+msg;
	}

}
