package com.tcs.java;

import java.util.ArrayList;

import com.tcs.bean.BeanClass;
import com.tcs.bean.TrainBean;
import com.tcs.bean.BookBean;

public class DAOClass {
	Railway r=new Railway();
	public int insert(BeanClass b) {
		return r.add(b);
	}

	public int login(BeanClass b) {
		return r.log(b);
	}

	public ArrayList<TrainBean> train(TrainBean tb) {
		return r.trainlist(tb);
	}

	/*public int registertic(BeanClass bc) {
		return r.registertic(bc);
	}*/
    public int trainnm(BookBean bc) {
    	return r.cus(bc);
    }

	public ArrayList<BookBean> bookedTrain(BookBean bc) {
		return r.book(bc);
	}
	
}
