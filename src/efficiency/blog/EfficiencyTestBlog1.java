package efficiency.blog;

import efficiency.DeleteDatabaseRow;


public class EfficiencyTestBlog1 {

	public static void main(String[] args) {
		long start, end;
		
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		BlogEfficiency1 blogEfficiency1 = new BlogEfficiency1(0, 0);
		blogEfficiency1.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
		new DeleteDatabaseRow();
		start= System.currentTimeMillis();
		BlogEfficiency2 blogEfficiency2 = new BlogEfficiency2(0, 0);
		blogEfficiency2.execute();
		end= System.currentTimeMillis();
		System.out.println(end-start);
		
	}

}
