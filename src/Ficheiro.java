import java.io.*;
import java.util.*;
import javax.swing.*;

public class Ficheiro
{
	public Ficheiro()
	{
		
	}
	public void actualizarFicheiro_users(ArrayList a,String pass,String numero,int poz)
	{
		Usuario u;
		
		try
		{
			FileWriter fr=new FileWriter("users.txt");
			BufferedWriter b=new BufferedWriter(fr);
			for(int i=0;i<a.size();i++)
			{
				u=(Usuario)a.get(i);
				if(u.getnumeroTelefone().equals(numero))
				{
					b.write(u.getnome()+";"+pass+";"+u.getnumeroTelefone());
					b.newLine();
				}
				else
				{
					b.write(u.getnome()+";"+u.getpin()+";"+u.getnumeroTelefone());
					b.newLine();
				}
			}
			b.close();
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null,io.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	public ArrayList lerOBJ()
	{
		ArrayList a=null;
		
		try
		{
			FileInputStream fi=new FileInputStream("Bilhete.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			
			a=(ArrayList)oi.readObject();
			oi.close();
			
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("|----------------------------------------|");
		System.out.println("| Fecheiro de Objecto lido com Sucesso ! |");
		System.out.println("|----------------------------------------|");
		return a;
	}
	public void escreverOBJ(ArrayList a)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Bilhete.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			
			oo.writeObject(a);
			oo.close();
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		
		System.out.println("|--------------------------------------|");
		System.out.println("| File de Objecto criado com Sucesso ! |");
		System.out.println("|--------------------------------------|");
	}
}