package tachograph;

import com.google.common.collect.Table;
import java.time.LocalDate;

public class Tachograph{
	private Table<LocalDate,Integer,Integer> data;
	
	public Tachograph() {
		data=Table.create();
		 
	 }
	
	public Table getTable() {
		return this.data;
	}
	

 
}
