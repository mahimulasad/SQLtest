package efficiency;


public class EfficiencyTest {

	public static void main(String[] args) {
		long start, end;
		new DeleteDatabaseRow();
		
		//normal insert 
		//connection created for each insert
		//time: 33.6s for 500 insert
		start= System.currentTimeMillis();
		Efficiency1 efficiency1 = new Efficiency1(0, 500);
		efficiency1.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		//normal insert
		//connection created once
		//time: 30.4s for 500 insert
		start= System.currentTimeMillis();
		Efficiency2 efficiency2 = new Efficiency2(1000, 500);
		efficiency2.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		//insert with prepared statement
		//time: 31.6s for 500 insert
		start= System.currentTimeMillis();
		Efficiency3 efficiency3 = new Efficiency3(2000, 500);
		efficiency3.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		//multiple insert
		//time 0.086s for 500 insert
		start= System.currentTimeMillis();
		Efficiency4 efficiency4 = new Efficiency4(3000, 500);
		efficiency4.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
	}

}
