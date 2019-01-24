package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.addressing.policy.AddressingPolicyMapConfigurator;

import dao.MachineDao;
import dao.ProductDao;
import vo.AddProductVo;
import vo.MachineOneVo;
import vo.MachineTwoVo;
import vo.tuna;

/**
 * Servlet implementation class AddMachineWork
 */
@WebServlet("/AddMachineWork")
public class AddMachineWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMachineWork() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag.equals("m1"))
		{
			try {
				AddMachineOneDetail(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag.equals("m2"))
		{
			try {
				AddMachineTwoDetail(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag.equals("m3"))
		{
			try {
				AddMachineThreeDetail(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void AddMachineThreeDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		response.sendRedirect("view/MachineThree.jsp");
	}

	private void AddMachineTwoDetail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		int productInHour = Integer.parseInt(request.getParameter("productInHour"));
		int productInMin = Integer.parseInt(request.getParameter("productInMin"));
		int productInSec = Integer.parseInt(request.getParameter("productInSec"));
		
		tuna t = new tuna();
		 t.setTime(productInHour, productInMin, productInSec);
		 String productInTime =  t.toMilitry();
		 
		System.out.println(productInTime);
		int productOutHour = Integer.parseInt(request.getParameter("productOutHour"));
		int productOutMin = Integer.parseInt(request.getParameter("productOutMin"));
		int productOutSec = Integer.parseInt(request.getParameter("productOutSec"));

		t.setTime(productOutHour, productOutMin, productOutSec);
		String productOutTime = t.toMilitry();
		int ProductId = Integer.parseInt(request.getParameter("ProductId"));
		System.out.println(productOutTime);
		
		String time1 = productInTime;
		String time2 = productOutTime;

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		long milliseconds = date2.getTime() - date1.getTime(); 
        long minutes = (milliseconds / 1000) / 60;
        long seconds = (milliseconds / 1000) % 60;

        int hours = (int) (minutes / 60); //since both are ints, you get an int
        int min = (int) (minutes % 60);
        
        t.setTime(hours, min, (int) seconds);
        String workingTime =  t.toMilitry();
        System.out.println(workingTime);
        
        HttpSession session = request.getSession();
        
        String waitingTime = (String) session.getAttribute("workingTimeOfMachineOne");
        System.out.println(waitingTime);
        
        AddProductVo addProductVo = new AddProductVo();
		addProductVo.setProductId(ProductId);
		
		int mId =  (int) session.getAttribute("mId");
		MachineOneVo machineOneVo = new MachineOneVo();
		machineOneVo.setMachineId(mId);
			
		
		MachineTwoVo machineTwoVo = new MachineTwoVo();
		machineTwoVo.setProductInTime(productInTime);
		machineTwoVo.setProductOutTime(productOutTime);
		machineTwoVo.setWorkingTime(workingTime);
		machineTwoVo.setWaitingTime(waitingTime);
		machineTwoVo.setAddProductVo(addProductVo);
		machineTwoVo.setMachineOneVo(machineOneVo);
		
		MachineDao machineTwoDao = new MachineDao();
		machineTwoDao.machineTwoDetail(machineTwoVo);
        
		List l =  machineTwoDao.machineGetDetail(mId);
		MachineTwoVo twoVo = (MachineTwoVo) l.get(0);
		int m2Id = twoVo.getMachineId();
		
		MachineDao machineOneDao = new MachineDao();
		machineOneDao.updateWaitingTime(workingTime,m2Id);
		
        
        response.sendRedirect("view/MachineThree.jsp");
		
	}

	private void AddMachineOneDetail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		int productInHour = Integer.parseInt(request.getParameter("productInHour"));
		int productInMin = Integer.parseInt(request.getParameter("productInMin"));
		int productInSec = Integer.parseInt(request.getParameter("productInSec"));
		
		 tuna t = new tuna();
		 t.setTime(productInHour, productInMin, productInSec);
		 String productInTime =  t.toMilitry();
		 System.out.println(productInTime);
		int productOutHour = Integer.parseInt(request.getParameter("productOutHour"));
		int productOutMin = Integer.parseInt(request.getParameter("productOutMin"));
		int productOutSec = Integer.parseInt(request.getParameter("productOutSec"));
		
		t.setTime(productOutHour, productOutMin, productOutSec);
		String productOutTime =  t.toMilitry();
		int ProductId = Integer.parseInt(request.getParameter("ProductId"));
		System.out.println(productOutTime);
		
		String time1 = productInTime;
		String time2 = productOutTime;

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		long milliseconds = date2.getTime() - date1.getTime(); 
        long minutes = (milliseconds / 1000) / 60;
        long seconds = (milliseconds / 1000) % 60;

        int hours = (int) (minutes / 60); //since both are ints, you get an int
        int min = (int) (minutes % 60);
        
        t.setTime(hours, min, (int) seconds);
        String workingTime =  t.toMilitry();
        System.out.println(workingTime);
        
        int h = 00;
        int m = 00;
        int s = 00;
        t.setTime(h, m, s);
        String waitingTime = t.toMilitry();
        
        AddProductVo addProductVo = new AddProductVo();
		addProductVo.setProductId(ProductId);
		
		
		MachineOneVo machineOneVo = new MachineOneVo();
		machineOneVo.setProductInTime(productInTime);
		machineOneVo.setProductOutTime(productOutTime);
		machineOneVo.setWorkingTime(workingTime);
		machineOneVo.setWaitingTime(waitingTime);
		machineOneVo.setAddProductVo(addProductVo);
		
		MachineDao machineOneDao = new MachineDao();
		machineOneDao.machineOneDetail(machineOneVo);
		
		ProductDao productDao = new ProductDao();
		List l = productDao.selectProductName(ProductId);
		
		AddProductVo addProductVo2 = (AddProductVo) l.get(0);
		String ProName = addProductVo2.getProductName();
		
		HttpSession session = request.getSession();
		session.setAttribute("ProName", ProName);
		session.setAttribute("ProId", ProductId);
		session.setAttribute("workingTimeOfMachineOne", workingTime);
		
		List l1 = machineOneDao.getMachineDetail(ProductId);
		MachineOneVo vo  = (MachineOneVo) l1.get(0);
		int mId = vo.getMachineId();
		session.setAttribute("mId", mId);
		
		
		response.sendRedirect("view/MachineTwo.jsp");
		

/*  		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Calendar c = Calendar.getInstance();

		c.setTime(format.parse(productInTime));
		long startMillis = c.getTimeInMillis();

		c.setTime(format.parse(productOutTime));
		long endMillis = c.getTimeInMillis();

		long sec =( (endMillis - startMillis )/1000);
		int day = (int)TimeUnit.SECONDS.toDays(sec);
		long hours = TimeUnit.SECONDS.toHours(sec) - (day *24);
		long minute = TimeUnit.SECONDS.toMinutes(sec) - (TimeUnit.SECONDS.toHours(sec)* 60);
		 long second = TimeUnit.SECONDS.toSeconds(sec) - (TimeUnit.SECONDS.toMinutes(sec) *60);
		 System.out.println(" Hour " + hours + " Minute " + minute + " Seconds " + second);
		
		//System.out.println("time difference is " + ((endMillis - startMillis)/1000) + " seconds");
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		 Date d1 = sdf.parse(productInTime);
		 Date d2 = sdf.parse(productOutTime);
		 
		 
		 if(d1.after(d2)){
		     long diffMs = d1.getTime() - d2.getTime();
		     long diffSec = diffMs / 1000;
		     long min = diffSec / 60;
		     long sec = diffSec % 60;
		     System.out.println("The difference is"+min+" minutes and "+sec+" seconds.");
		     String workingTime = String.format("%02d:%02d", min,sec); 
		    }

		    if(d1.before(d2)){
		     long diffMs = d2.getTime() - d1.getTime();
		     long diffSec = diffMs / 1000;
		     long min = diffSec / 60;
		     long sec = diffSec % 60;
		     System.out.println("The difference is   "+min+" minutes and "+sec+" seconds.");
		     String workingTime = String.format("%02d:%02d", min,sec);
		    }

		    if(d1.equals(d2)){
		    	String workingTime = null;
		    }
		 
		 System.out.println("Time: " + sdf.format(d1));
		 System.out.println("Time: " + sdf.format(d2));
		 
		productInHour = productInHour * 3600;
		productInMin = productInMin * 60;
		int totalInSec = (productInHour + productInMin )+ productInSec;
		
		productOutHour = productOutHour * 3600;
		productOutMin = productOutMin * 60;
		int totalOutSec =( productOutHour + productOutMin )+ productOutSec;
		
		int sec = totalOutSec - totalInSec;
		
		float waitingTime = sec/3600;
		
		System.out.println(waitingTime);*/
		
		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
