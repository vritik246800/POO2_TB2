import java.util.*;

public class Calculos 
{
	public Calculos()
	{
		
	}
	public int calcular_Quantidade(ArrayList a)
	{
		int ct=0,ctEst=0,ctRev=0;
		Cliente pai;
		Estado est;
		Revendedor rev;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Estado)
			{
				est=(Estado)pai;
				ctEst+=est.getqtyViaturas();
			}
			else if(pai instanceof Revendedor)
			{
				rev=(Revendedor)pai;
				ctRev+=rev.getqtyViaturas();
			}
		}
		ctEst*=Estado.ctEstado;
		ctRev*=Revendedor.ctRevendor;
		ct=Normal.ctNormal+Doutorado.ctDoutorado+ctEst+ctRev;
		
		return ct;
	}
	public double calculo_margem(double valorTotal)
	{
		return valorTotal-1900000;
	}
	public float acumulador_Normal(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Normal)
			{
				pai=(Normal)pai;
				acumulador+=pai.valorFinal();
			}
		}
		return acumulador;
	}
	public float acumulador_Revendedor(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Revendedor)
			{
				pai=(Revendedor)pai;
				acumulador+=pai.valorFinal();
			}
		}
		return acumulador;
	}
	public float acumulador_Estado(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Estado)
			{
				pai=(Estado)pai;
				acumulador+=pai.valorFinal();
			}
		}
		return acumulador;
	}
	public float acumulador_Doutorado(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
				acumulador+=pai.valorFinal();
			}
		}
		return acumulador;
	}
	public float acumuladorAdoaneiro(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
			}
			else
			{
				if(pai instanceof Normal)
				{
					pai=(Normal)pai;
				}
				else
				{
					if(pai instanceof Revendedor)
					{
						pai=(Revendedor)pai;
					}
					else
					{
						if(pai instanceof Estado)
						{
							pai=(Estado)pai;
						}
					}
				}
			}
			acumulador+=pai.direitosAdoaneiro();
		}
		
		return acumulador;
	}
	public double acumuladorGeral(ArrayList a)
	{
		double acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
			}
			else
			{
				if(pai instanceof Normal)
				{
					pai=(Normal)pai;
				}
				else
				{
					if(pai instanceof Revendedor)
					{
						pai=(Revendedor)pai;
					}
					else
					{
						if(pai instanceof Estado)
						{
							pai=(Estado)pai;
						}
					}
				}
			}
			acumulador+=pai.valorFinal();
		}
		return acumulador;
	}
}
