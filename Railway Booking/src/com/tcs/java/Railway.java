package com.tcs.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

import com.tcs.bean.BeanClass;
import com.tcs.bean.BookBean;
import com.tcs.bean.TrainBean;
import com.tcs.database.DBConnection;
public class Railway {
	private static Connection cn=DBConnection.start();
	public int add(BeanClass bc) {
		try {
		PreparedStatement ps=cn.prepareStatement("insert into customer values(?,?,?,?,?)");
		ps.setString(1, bc.getName());
		ps.setString(2, bc.getAge());
		ps.setString(3, bc.getGender());
		ps.setString(4, bc.getPassword());
		ps.setString(5, bc.getPlace());
		return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int log(BeanClass b) {
		try {
			PreparedStatement ps=cn.prepareStatement("select * from customer where name=?");
			ps.setString(1, b.getName());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("coming here");
				String pass=rs.getString(4);
				if(b.getPassword().equals(pass)) {
					return 1;
				}else {
					return 0;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<TrainBean> trainlist(TrainBean tb) {
		ArrayList<TrainBean> at=new ArrayList<TrainBean>();
		try {
			PreparedStatement ps=cn.prepareStatement("select * from trainlist where from1=? and to1=?");
			ps.setString(1, tb.getFrom());
			ps.setString(2, tb.getTo());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				tb=new TrainBean();
				tb.setFrom(rs.getString(1));
				tb.setTo(rs.getString(2));
				tb.setTrainName(rs.getString(3));
				tb.setSeat(rs.getString(4));
				at.add(tb);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return at;
	}
	/*public int registertic(BeanClass bc) {
		try {
			PreparedStatement ps=cn.prepareStatement("insert into customer values(?,?,?,?,?)");
			ps.setString(1, bc.getName());
			ps.setString(2, bc.getAge());
			ps.setString(3, bc.getGender());
			return ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
	}*/
	public int cus(BookBean bc) {
		try {
			PreparedStatement ps=cn.prepareStatement("insert into book values(?,?,?,?,?,?)");
			ps.setString(1, bc.getName());
			ps.setString(2, bc.getAge());
			ps.setString(3, bc.getGender());
			ps.setString(4, bc.getTrainName());
			ps.setString(5, bc.getUname());
			ps.setString(6, getSeat(bc));
			update(bc);
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void update(BookBean bc) {
		Integer seat=0;
		try {
			PreparedStatement ps=cn.prepareStatement("select * from trainlist where trainname=?");
			ps.setString(1, bc.getTrainName());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 seat=Integer.parseInt(rs.getString(4));
			}
			seat--;
			ps=cn.prepareStatement("update trainlist SET seat=? where trainname=?");
			ps.setString(2, bc.getTrainName());
			ps.setString(1, seat.toString());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getSeat(BookBean bc) {
		String seat="0";
		try {
			PreparedStatement ps=cn.prepareStatement("select seat from trainlist where trainname=?");
			ps.setString(1,bc.getTrainName());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				seat=rs.getString(1);
			}
			return seat;
		}catch(Exception e){
			e.printStackTrace();
		}return "0";
	}
	public ArrayList<BookBean> book(BookBean bc) {
		ArrayList<BookBean> at=new ArrayList<BookBean>();
		try {
			PreparedStatement ps=cn.prepareStatement("select * from book where uname=?");
			ps.setString(1, bc.getUname());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bc=new BookBean();
				bc.setName(rs.getString(1));
				bc.setAge(rs.getString(2));
				bc.setGender(rs.getString(3));
				bc.setTrainName(rs.getString(4));
				bc.setSeat(rs.getString(6));
				at.add(bc);
			}return at;
		}catch(Exception e) {
			e.printStackTrace();
		}return at;
	}
}
