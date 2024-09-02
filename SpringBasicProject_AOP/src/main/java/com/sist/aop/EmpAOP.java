package com.sist.aop;
import java.util.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Component // �޸� �Ҵ�
public class EmpAOP {

	@Autowired
	private EmpDAO dao; // ���۰� ���ÿ� ó�� => ���������� ���
	/*
	 * 	public void insert()
	 * 	{
	 * 		SqlSession session=null;
	 * 		try
	 * 		{
	 * 			session=ssf.openSession(); // before
	 * 			session.insert("insert");
	 * 		}catch(Exception ex)
	 * 		{
	 * 			ex.printStackTrace(); // afterThrowing
	 * 		}
	 * 		finally
	 * 		{
	 * 			if(session!=null) // after
	 * 				session.close();
	 * 		}
	 * 	}
	 * 
	 * 	public void aaa()
	 * 	{
	 * 		=== @Before => getConnection()
	 * 		try
	 * 		{
	 * 			=== @Around => setAutoCommit(false)
	 * 			�ҽ� �ڵ�
	 * 			=== @Around => commit()
	 * 		}catch(Exception ex)
	 * 		{
	 * 			=== @AfterThrowing
	 * 		}
	 * 		finally
	 * 		{
	 * 			=== @After
	 * 		}
	 * 		return === @AfterReturning
	 * 	}
	 */
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	// try ù��° ��
	public void getConnection()
	{
		dao.getConnection();
	}

	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	// finally�� �߰�
	public void disConnection()
	{
		dao.disConnection();
	}
	
	// log ����, Ʈ�����, ����
	@Around(value = "execution(* com.sist.dao.EmpDAO.emp*(..))")
	public Object log(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		
		try
		{
			long start=System.currentTimeMillis();
			obj=jp.proceed(); // �Լ� ȣ��
			System.out.println("ȣ��� �޼ҵ� : "+jp.getSignature().getName());
			long end=System.currentTimeMillis();
			System.out.println("�ҿ� �ð� : "+(end-start));
		}catch(Exception ex) {}
		
		return obj;
	}
	
	// ���� ���� => return ���� �޾Ƽ� ó��
	@AfterReturning(value = "execution(* com.sist.dao.EmpDAO.emp*())",returning = "obj")
	public void afterReturning(Object obj)
	{
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getSal());
		}
	}
	
	// catch ����
	@AfterThrowing(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",throwing="obj")
	public void afterThrowing(Throwable ex) throws Throwable
	{
		System.out.println("=== ���� �߻� ===");
		ex.printStackTrace();
	}
}
