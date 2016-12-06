package com.niit.gauresh_emusic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.niit.gauresh_emusic.util.FileUtil;

;

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

	private static String productPath = "";
	private static String categoryPath = "";

	// product list
	@RequestMapping("/viewProducts")
	public ModelAndView getAllProducts(@RequestParam(value = "msg", required = false) String msg) {
		ModelAndView model = new ModelAndView("page");
		model.addObject("product", new Product());

		// checking for list to display
		List<Product> productList = productDAO.list();
		if (productList != null && !productList.isEmpty()) {
			model.addObject("productList", productDAO.list());
			model.addObject("categoryList", categoryDAO.list());
			model.addObject("supplierList", supplierDAO.list());
		}

		else {
			model.addObject("noProduct", "Oops!!! No product present.");
		}

		// checking for success/failure msg
		if (msg != null)
			model.addObject("msg", msg);
		model.addObject("ifUserClickedViewProducts", true);
		return model;
	}

	// add or update product
	@RequestMapping(value = "/viewProducts/product/save", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {

		// finding real path
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		// giving proper path for category images
		productPath = rootPath + "resources\\images\\product";

		String msg = null;
		System.out.println(product);
		if (product.getProductId() == 0) {
			boolean flag = productDAO.saveOrUpdate(product);
			if (flag == true) {
				FileUtil.upload(productPath, product.getImage(), product.getProductId() + ".png");
				msg = "Successfully added new product";
			} else {
				msg = "Failed to create new product";
			}
		} else {
			boolean flag = productDAO.saveOrUpdate(product);
			if (flag == true) {
				FileUtil.upload(productPath, product.getImage(), product.getProductId() + ".png");
				msg = "Successfully updated product";
			} else {
				msg = "Failed to update product";
			}
		}

		return "redirect:/admin/viewProducts?msg=" + msg;
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
		model.addObject("category", new Category());

		List<Category> categoryList = categoryDAO.list();
		if (categoryList != null && !categoryList.isEmpty()) {
			model.addObject("categoryList", categoryDAO.list());
		} else {
			model.addObject("noCategory", "Oops!!! No category present.");
		}

		// showing success or failure msg
		if (msg != null)
			model.addObject("msg", msg);
		model.addObject("ifUserClickedViewCategory", true);
		return model;
	}

	// add/update category
	@RequestMapping(value = "/viewCategories/category/save", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, HttpServletRequest request) {

		// finding real path
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		// giving path for category images
		categoryPath = rootPath + "resources\\images\\category";

		String msg = null;
		System.out.println(category);
		if (category.getId() == 0) {
			boolean flag = categoryDAO.saveOrUpdate(category);
			if (flag == true) {
				FileUtil.upload(categoryPath, category.getImage(), category.getId() + ".png");
				msg = "Successfully added new category";
			} else {
				msg = "Failed to create new category";
			}
		} else {
			boolean flag = categoryDAO.saveOrUpdate(category);
			if (flag == true) {
				FileUtil.upload(categoryPath, category.getImage(), category.getId() + ".png");
				msg = "Successfully updated category";
			} else {
				msg = "Failed to update category";
			}
		}
		return "redirect:/admin/viewCategories?msg=" + msg;
	}

	// edit category
	@RequestMapping("/viewCategories/edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		category = categoryDAO.get(id);
		model.addObject("category", category);

		model.addObject("categoryList", categoryDAO.list());

		model.addObject("ifUserClickedViewCategory", true);
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
		model.addObject("supplier", new Supplier());

		// checking supplier list
		List<Supplier> supplierList = supplierDAO.list();
		if (supplierList != null && !supplierList.isEmpty()) {
			model.addObject("supplierList", supplierDAO.list());
		} else {
			model.addObject("noSupplier", "Oops!!! No supplier present.");
		}

		// looking for any success failure msg
		if (msg != null)
			model.addObject("msg", msg);
		model.addObject("ifUserClickedViewSuppliers", true);
		return model;
	}

	// add/update supplier
	@RequestMapping(value = "/viewSuppliers/supplier/save", method = RequestMethod.POST)
	public String addsupplier(@ModelAttribute("supplier") Supplier supplier) {
		String msg = null;
		System.out.println(supplier);
		if (supplier.getId() == 0) {
			boolean flag = supplierDAO.saveOrUpdate(supplier);
			if (flag == true) {
				msg = "Successfully added new supplier";
			} else {
				msg = "Failed to create new supplier";
			}
		} else {
			boolean flag = supplierDAO.saveOrUpdate(supplier);
			if (flag == true) {
				msg = "Successfully updated supplier";
			} else {
				msg = "Failed to update supplier";
			}
		}
		return "redirect:/admin/viewSuppliers?msg=" + msg;
	}

	// edit supplier
	@RequestMapping("/viewSuppliers/edit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		supplier = supplierDAO.get(id);
		model.addObject("supplier", supplier);

		model.addObject("supplierList", supplierDAO.list());

		model.addObject("ifUserClickedViewSuppliers", true);
		return model;
	}

	// delete supplier
	@RequestMapping("/viewSuppliers/delete/{id}")
	public String deleteSupplier(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		String msg;
		supplier = supplierDAO.get(id);
		boolean flag = supplierDAO.delete(supplier);
		if (flag == true)
			msg = "Supplier deleted successfully";
		else
			msg = "Operation could not success";
		model.addObject("ifUserClickedDeleteSupplier", true);
		return "redirect:/admin/viewSuppliers?msg=" + msg;
	}

}
