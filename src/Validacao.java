import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Validacao
{
	private BufferedReader b;
	
	public Validacao()
	{
		b=new BufferedReader(new InputStreamReader(System.in));
	}
	public String [] ternomes(ArrayList list)
	{
		String [] s=new String[list.size()];
		Usuario u;
		
		for(int i=0;i<list.size();i++)
		{
			u=(Usuario)list.get(i);
			s[i]=u.getnome();
		}
		
		return s;
	}
	public String terPass(ArrayList list,String pass)
	{
		String p;
		Usuario usuario;
		
		for(int i=0;i<list.size();i++)
		{
			usuario=(Usuario)list.get(i);
			p=usuario.getpin();
			if(pass.equals(p))
				return usuario.getpin();
		}
		return "";
	}
	public String validarNome()
	{
		String nome="";
		
		do
		{
			System.out.println("|-------------------------------------------|");
			System.out.println("| Introduz o nome do cliente (>2 caractere) |");
			System.out.println("|-------------------------------------------|");
			
			try
			{
				nome=b.readLine();
			}
			catch(IOException io)
			{
				System.out.println(io.getMessage());
			}
			if(nome.length()<2)
			{
				System.out.println("|--------------------------------------------------|");
				System.out.println("| O nome introduzido e invalido, tenta novamente ! |");
				System.out.println("|--------------------------------------------------|");
			}
		}while(nome.length()<2);
		
		return nome;
	}
	public int validarCode()
	{
		int code=0;
		
		do
		{
			System.out.println("|-----------------------------------------------|");
			System.out.println("| Introduz o codigo que pretenge verificar (>0) |");
			System.out.println("|-----------------------------------------------|");
			try
			{
				code=Integer.parseInt(b.readLine());
			}
			catch(IOException io)
			{
				System.out.println(io.getMessage());
			}
			if(code<=0)
			{
				System.out.println("|----------------------------------------------------|");
				System.out.println("| O cogido introduzido e invalido, tenta novamente ! |");
				System.out.println("|----------------------------------------------------|");
			}
		}while(code<=0);
		
		return code;
	}

}
