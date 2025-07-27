import java.util.*;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.*;

public class Visualizar extends JFrame
{
	private DecimalFormat meticais;
	
	public Visualizar()
	{
		meticais=new DecimalFormat("###,###,###,###.00 Mts");
		
	}
	public void visualizar_MulherMocambicana(ArrayList a)
	{
		Cliente pai;
		String mes1,dia1,s="";
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			mes1=pai.getdataCompra().substring(0,2);
			dia1=pai.getdataCompra().substring(3,5);
			
			if(mes1.equalsIgnoreCase("04") && dia1.equalsIgnoreCase("07"))
				s+=pai.toString()+"\n";
		}
		System.out.println(s);
	}
	public void visualizar_Situacao(float valorTotal,float margem)
	{
		if(valorTotal>1900000)
		{
			System.out.println("|--------------------------------------|");
			System.out.println("| A empresa BeForward Mz esta em lucro |");
			System.out.println("|--------------------------------------|");
			 System.out.printf("| Com valor de: %-22s |\n",meticais.format(margem));
			System.out.println("|--------------------------------------|");
		}
		else
		{
			System.out.println("|-----------------------------------------|");
			System.out.println("| A empresa BeForward Mz esta em prejuiso |");
			System.out.println("|-----------------------------------------|");
			 System.out.printf("| Com valor de: %-25s |\n",meticais.format(margem));
			System.out.println("|-----------------------------------------|");
		}
	}
	public void visualizar_Pesquisa(int posicao,ArrayList a)
	{
		
		if(posicao==-1)
		{
			System.out.println("|---------------------------------------|");
			System.out.println("| O cliente nao existe na base de dados |");
			System.out.println("|---------------------------------------|");
		}
		else
		{
			Cliente pai;
			pai=(Cliente)a.get(posicao);
			System.out.println("|---------------------|");
			System.out.println("| O cliente a procuta |");
			System.out.println("|------------------------------------------------\\\\");
			System.out.println(pai);
			System.out.println("|------------------------------------------------//");
		}
	}
	public void visualizar_AcumuladorAdoaneiro(float valorAdoaneiro)
	{
		JTable tab;
		JScrollPane scr;
		JFrame f;
		String cabecalho[]=
		{
			" O valor total pago em direitos adoaneiro (Mts)"
		};
		String s[][] =new String [1][cabecalho.length];
		
		s[0][0]=meticais.format(valorAdoaneiro);
		
		tab=new JTable(s,cabecalho);
		tab.setEnabled(false);
		scr=new JScrollPane(tab);
		scr.setBackground(new Color(0, 255, 204));
		scr.setBackground(new Color(255, 140, 0));
		tab.setForeground(new Color(255, 140, 0));
		
		f = new JFrame("Resumo de Tipos de Cliente");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 150);
        f.add(scr);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
	public void visualizar_AcumuladorGeral(double valorTotal)
	{
		JTable tab;
		JScrollPane scr;
		JFrame f;
		String cabecalho[]=
		{
			" O valor total pago a pela BeForward Mz (Mts) "
		};
		String s[][] =new String [1][cabecalho.length];
		
		s[0][0]=meticais.format(valorTotal);
		
		tab=new JTable(s,cabecalho);
		tab.setEnabled(false);
		scr=new JScrollPane(tab);
		scr.setBackground(new Color(0, 255, 204));
		scr.setBackground(new Color(255, 140, 0));
		tab.setForeground(new Color(255, 140, 0));
		
		f = new JFrame("Resumo de Tipos de Cliente");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 150);
        f.add(scr);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
	public void visualizar_Doutorado(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|----------------------|");
		System.out.println("| Lista dos Doutorados |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
				s+=pai.toString()+"\n";
			}	
		}
		System.out.print(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_Normal(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|-------------------|");
		System.out.println("| Lista dos Normais |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Normal)
			{
				pai=(Normal)pai;
				s+=pai.toString()+"\n";
			}	
		}
		System.out.println(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_Revendedor(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|------------------------|");
		System.out.println("| Lista dos Revendedores |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Revendedor)
			{
				pai=(Revendedor)pai;
				s+=pai.toString()+"\n";
			}		
		}
		System.out.println(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_Estado(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|-------------------|");
		System.out.println("| Lista dos Estados |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Estado)
			{
				pai=(Estado)pai;
				s+=pai.toString()+"\n";
			}	
		}
		System.out.println(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizarTClientes(ArrayList <Cliente> a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=a.get(i);
			s+=pai.toString()+"\n";
		}
		System.out.print(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizarUser(ArrayList user,int poz)
	{
		Usuario u;
		u=(Usuario)user.get(poz);
		JTable tab;
		JScrollPane scr;
		JFrame f;
		String cabecalho[]=
		{
			"Nome do utilizador","Numero de telefone"
		};
		String s[][] =new String [1][cabecalho.length];
		s[0][0]=u.getnome();
		s[0][1]=u.getnumeroTelefone();
		
		tab=new JTable(s,cabecalho);
		tab.setEnabled(false);
		scr=new JScrollPane(tab);
		scr.setBackground(new Color(0, 255, 204));
		scr.setBackground(new Color(255, 140, 0));
		tab.setForeground(new Color(255, 140, 0));
		
		f = new JFrame("Dados do utilizador");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 150);
        f.add(scr);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
	public void visualizar_CT(ArrayList a)
	{
		JTable tab;
		JScrollPane scr;
		JFrame f;
		String cabecalho[]=
		{
			"Doutorado","Normal","Revendedor","Estado"
		};
		String s[][] =new String [1][cabecalho.length];
		
		s[0][0]=Doutorado.ctDoutorado+"";
		s[0][1]=Normal.ctNormal+"";
		s[0][2]=Revendedor.ctRevendor+"";
		s[0][3]=Estado.ctEstado+"";
		
		tab=new JTable(s,cabecalho);
		tab.setEnabled(false);
		scr=new JScrollPane(tab);
		scr.setBackground(new Color(0, 255, 204));
		scr.setBackground(new Color(255, 140, 0));
		tab.setForeground(new Color(255, 140, 0));
		
		f = new JFrame("Resumo de Tipos de Cliente");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 150);
        f.add(scr);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
	public JTable visualizar_CT_JSCROLL(ArrayList a)
	{
		JTable tab;
		String cabecalho[]=
		{
			"Doutorado","Normal","Revendedor","Estado"
		};
		String s[][] =new String [1][cabecalho.length];
		
		s[0][0]=Doutorado.ctDoutorado+"";
		s[0][1]=Normal.ctNormal+"";
		s[0][2]=Revendedor.ctRevendor+"";
		s[0][3]=Estado.ctEstado+"";
		
		tab=new JTable(s,cabecalho);
		tab.setEnabled(false);
		tab.setForeground(new Color(255, 140, 0));
        
        return tab;
	}
}














