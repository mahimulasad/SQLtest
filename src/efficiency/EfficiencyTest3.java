package efficiency;


public class EfficiencyTest3 {

	public static void main(String[] args) {
		long start, end;
		
		//normal insert
		//use prepared statement
		//time: 26.8 for 500 insert
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		Efficiency3 efficiency3 = new Efficiency3(3000, 500);
		efficiency3.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		//bulk insert
		//time: 25.5 for 500 insert
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		Efficiency6 efficiency6 = new Efficiency6(3000, 500);
		efficiency6.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
	}

}
