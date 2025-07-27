import java.util.*;

public class Alteracao 
{
	
	public Alteracao()
	{
		
	}
	public void alterarPassword(ArrayList a,String pass,int poz)
	{
		Usuario u;
		
		for(int i=0;i<a.size();i++)
		{
			u=(Usuario)a.get(i);
			if(i==poz)
				u.setpin(pass);
		}
	}
}
