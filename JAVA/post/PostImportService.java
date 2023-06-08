package post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;
import java.util.Calendar;

import comm.DbConnect;

public class PostImportService extends DbConnect{

	public static void main(String[] args) throws Exception{
		String path = "c:/Temp100/post1.csv";
		postImport(path);
	}
	public static void postImport(String path) throws Exception {
		//DB 연결
				Statement stmt = Connection().createStatement();
				
				Calendar cal = Calendar.getInstance();
				long t1 = cal.getTimeInMillis();
				//경로의 인식
				FileReader file = new FileReader(path);
				BufferedReader buffer = new BufferedReader(file);
				// 내용 읽기
				String rowData = "";
				int cnt = 0;
				while(true) {
					if((rowData = buffer.readLine())!=null) {
		
						rowData = rowData.replace("'","''");
						String[] datas = rowData.split(",");
//						 for (int i = 0; i < datas.length; i++) {
//			                   datas[i] = datas[i].replace("'", "''");
//			               }
						String sql = "insert into post2"
								+ "	 (a1,a2,a3,a4,a5,a6,a7)"
								+ " values("
								+ "  '"+datas[0]+"'"
								+ ", '"+datas[1]+"'"
								+ ", '"+datas[2]+"'"
								+ ", '"+datas[3]+"'"
								+ ", '"+datas[4]+"'"
								+ ", '"+datas[5]+"'"
								+ ", '"+datas[6]+"' )";
						// ' 가 포함된 데이터값은 ''로 바꿔 입력함.
						int result = stmt.executeUpdate(sql);
						if (result == 1) cnt++;

					}else break;
				}   //while  close
				
				cal = Calendar.getInstance();
				long t2 = cal.getTimeInMillis();
				long t3 = t2 - t1;
				System.out.println( t3 + " 밀리 초");
				System.out.println("총 " + cnt + "건 입력완료");
	}
}
