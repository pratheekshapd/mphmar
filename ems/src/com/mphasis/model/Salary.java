package com.mphasis.model;
import java.io.Serializable;
public class Salary implements Serializable {
	private int basic;
	private int da;
	private int hra;
	private int pf;
	private int gross;
	private int net;

	

	public Salary(int basic, int da, int hra, int gross, int net) {
		super();
		this.basic = basic;
		this.da = da;
		this.hra = hra;
		
		//this.gross = gross;
		this.net = net;
	}


	public Salary(double basic2) {
		// TODO Auto-generated constructor stub
	}


	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getDa() {
		return da;
	}

	public void setDa(int basic) {
		this.da = (30*basic)/100;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int basic) {
		this.hra = (20*basic)/100;
	}
	
	

	public int getPf() {
		return pf;
	}

	public void setPf(int basic) {
		this.pf = (10*basic)/100;
	}

	public int getGross() {
		return gross;
	}

	public void setGross(int basic, int da, int hra) {
		this.gross = basic+da+hra;
	}

	public int getNet() {
		return net;
	}

	public void setNet(int gross,int pf) {
		this.net = gross-pf;
	}

	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", da=" + da + ", hra=" + hra + ", gross=" + gross + ", net=" + net + "]";
	}

}