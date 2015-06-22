package efficiency;


public class EfficiencyTest2 {

	public static void main(String[] args) {
		long start, end;
		
		new DeleteDatabaseRow();
		//multivalue insert
		//string concat uses + operator
		//time: 1.5s for 10000 insert
		start= System.currentTimeMillis();
		Efficiency4 efficiency4 = new Efficiency4(3000, 10000);
		efficiency4.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		//multivalue insert
		//string concal use concat method
		//time: 0.79s for 10000 insert
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		Efficiency5 efficiency5 = new Efficiency5(3000, 10000);
		efficiency5.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
	}

}
