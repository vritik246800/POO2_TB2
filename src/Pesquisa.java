import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int posicaoPass(ArrayList user,String passValidar)
	{
		Usuario u;
		
		for(int i=0;i<user.size();i++)
		{
			u=(Usuario)user.get(i);
			if(u.getpin().equals(passValidar))
				return i;
		}
		return -1;
	}
	public int pesquisa_Code(ArrayList a,String campoTexto)
	{
		Cliente pai;
		int code=Integer.parseInt(campoTexto);
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai.getcodeViatura()==code)
				return i;
		}
		return -1;
	}
	public int pesquisa_Nome(ArrayList a,String campoTexto)
	{
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai.getnomeCliente().equalsIgnoreCase(campoTexto))
				return i;
		}
		return -1;
	}
	public int pesquisa(ArrayList a,int code,String nome)
	{
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai.getnomeCliente().equalsIgnoreCase(nome) && pai.getcodeViatura()==code)
				return i;
		}
		return -1;		
	}
	public int pesquisarNumeroTelefone_CLIENTE(String numeroTelefone,ArrayList a)
	{
		Cliente u;
		
		for(int i=0;i<a.size();i++)
		{
			u=(Cliente)a.get(i);
			if(u.getnumeroTelefone().equals(numeroTelefone))
				return i;
		}
		return -1;
	}
	public int pesquisarNumeroTelefone(String numeroTelefone,ArrayList a)
	{
		Usuario u;
		
		for(int i=0;i<a.size();i++)
		{
			u=(Usuario)a.get(i);
			if(u.getnumeroTelefone().equals(numeroTelefone))
				return i;
		}
		return -1;
	}

}
