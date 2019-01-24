package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import vo.AddProductVo;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		
		if(flag.equals("AddProduct"))
		{
			AddProduct(request,response);
		}
		if(flag.equals("selectpro"))
		{
			selectProduct(request,response);
		}
		
		
		
	}

	private void selectProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ProductDao productDao = new ProductDao();
		List l = productDao.selectProduct();
		session.setAttribute("selectpro", l);
		
		response.sendRedirect("Index.jsp");
		
	}

	private void AddProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub

		String productName = request.getParameter("productName");
		
		
		AddProductVo addProductVo = new AddProductVo();
		addProductVo.setProductName(productName);
		
		ProductDao productDao = new ProductDao();
		productDao.AddProduct(addProductVo);
	
		HttpSession session = request.getSession();
		List l = productDao.selectProduct();
		session.setAttribute("selectpro", l);
		
		response.sendRedirect("Index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
