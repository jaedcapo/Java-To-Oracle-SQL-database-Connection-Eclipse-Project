import java.sql.*;
import java.util.Scanner;

public class mainClass {
	
	public static void add_emp(String user, String pass) {
		System.out.println("f1");
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Ingresar numero de empleado");
		int empno=scan.nextInt();
		System.out.println("Ingresar nombre de empleado");
		String ename = scan2.nextLine();
		System.out.println("Ingresar nombre de trabajo");
		String job = scan2.nextLine();
		System.out.println("Ingresar numero de gerente");
		int mgr = scan.nextInt();
		System.out.println("Ingresar ano de contratacion");
		int YYYY= scan.nextInt();
		System.out.println("Ingresar num de mes de contratacion");
		int MM = scan.nextInt();
		System.out.println("Ingresar num de dia de contratacion");
		int DD = scan.nextInt();
		System.out.println("Ingresar salario");
		int sal = scan.nextInt();
		System.out.println("Ingresar comision");
		double comm = scan.nextDouble();
		System.out.println("Ingresar numero de departamento");
		int deptno = scan.nextInt();
		
		Date hiredate = new Date(YYYY, MM, DD);
		
		try {
			
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        conn = DriverManager.getConnection(url, user, pass);
		CallableStatement s = conn.prepareCall("{call ADD_EMP(?,?,?,?,?,?,?,?)}");
		
		s.setInt(1, empno);
		s.setString(2, ename);
		s.setString(3, job);
		s.setInt(4, mgr);
		s.setDate(5, hiredate);
		s.setInt(6, sal);
		s.setDouble(7, comm);
		s.setInt(8, deptno);
		s.execute();
		System.out.println("executed");
		conn.close();
		System.out.println("Connection closed");
		}catch(Exception e) {
			
		}
		
	}
	
	public static void del_emp(String user, String pass) {
		//Delete Employee Function
		System.out.println("f2");
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresar numero de empleado");
		int empno = scan.nextInt();
		
		try {
				
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        conn = DriverManager.getConnection(url, user, pass);
		CallableStatement s = conn.prepareCall("{call DELETE_EMP(?)}");
		
		s.setInt(1, empno);
		s.execute();
		System.out.println("executed");
		conn.close();
		System.out.println("Connection closed");
		}catch(Exception e) {
			System.out.println("cringe " + e);
		}
		
	}
	
	public static void upd_emp(String user, String pass) {
		//Edit Function
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Cambiar empleado numero: ");
		int empno=scan.nextInt();
		System.out.println("Ingresar nombre de empleado");
		String ename = scan2.nextLine();
		System.out.println("Ingresar nombre de trabajo");
		String job = scan2.nextLine();
		System.out.println("Ingresar numero de gerente");
		int mgr = scan.nextInt();
		System.out.println("Ingresar ano de contratacion");
		int YYYY= scan.nextInt();
		System.out.println("Ingresar num de mes de contratacion");
		int MM = scan.nextInt();
		System.out.println("Ingresar num de dia de contratacion");
		int DD = scan.nextInt();
		System.out.println("Ingresar salario");
		int sal = scan.nextInt();
		System.out.println("Ingresar comision");
		double comm = scan.nextDouble();
		System.out.println("Ingresar numero de departamento");
		int deptno = scan.nextInt();
		
		Date hiredate = new Date(YYYY, MM, DD);
		
		try {
			
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        conn = DriverManager.getConnection(url, user, pass);
		CallableStatement s = conn.prepareCall("{call UPDATE_EMP(?,?,?,?,?,?,?,?)}");
		
		s.setInt(1, empno);
		s.setString(2, ename);
		s.setString(3, job);
		s.setInt(4, mgr);
		s.setDate(5, hiredate);
		s.setInt(6, sal);
		s.setDouble(7, comm);
		s.setInt(8, deptno);
		s.execute();
		System.out.println("executed");
		conn.close();
		System.out.println("Connection closed");
		}catch(Exception e) {
			
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("Enter your DB connection Username");
		String usern = scan2.next();
		System.out.println("Enter your DB connection Password");
		String passw = scan2.next();
		
		System.out.println("#1 Create Employee: \n");
		System.out.println("#2 Delete Emplotee: \n");
		System.out.println("#3 Update Employee: \n");
		
		int opt = scan.nextInt();
		switch(opt) {
		
		case 1:
		add_emp(usern, passw);
		break;
		
		case 2:	
		del_emp(usern, passw);
		break;
		
		case 3:
		upd_emp(usern, passw);
		break;
		
		}
		
	}
	private static void debug() {
		
		System.out.println("...");
	}

}
