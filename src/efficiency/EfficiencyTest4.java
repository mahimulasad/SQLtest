package efficiency;


public class EfficiencyTest4 {

	public static void main(String[] args) {
		long start, end;
		
		// multivalue insert
		// string concat uses + operator
		// time: 1.6s for 10000 insert
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		Efficiency4 efficiency4 = new Efficiency4(3000, 10000);
		efficiency4.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		
		// multivalue insert
		// string concal use concat method
		// time: 0.7s for 10000 insert
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		Efficiency5 efficiency5 = new Efficiency5(3000, 10000);
		efficiency5.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		// bulk insert
		// time: 28.1 for 500 insert
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		Efficiency6 efficiency6 = new Efficiency6(3000, 500);
		efficiency6.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
	}

}
