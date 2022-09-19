import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15591 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String[] sarr = s.split(" ");
		
		int n = Integer.parseInt(sarr[0]);
		int q = Integer.parseInt(sarr[1]);
		
		int count = n*(n-1);
		
		int arr1[][] = new int[n][n];
		
		for(int i=0; i<n-1; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			arr1[a-1][b-1] = Integer.parseInt(sarr[2]);
			arr1[b-1][a-1] = Integer.parseInt(sarr[2]);
			count-=2;
		}
		
		while(count>0) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<n; k++) {
						if(j==k||arr1[j][k]!=0||arr1[i][j]==0||arr1[i][k]==0) continue;
						
						arr1[j][k] = Math.min(arr1[i][j], arr1[i][k]);
						arr1[k][j] = Math.min(arr1[i][j], arr1[i][k]);
						count-=2;
					}
				}
			}
			System.out.println();
		}
		
		for(int i=0; i<q; i++) {
			sarr = br.readLine().split(" ");
			int k=Integer.parseInt(sarr[0]);
			int v=Integer.parseInt(sarr[1])-1;
			int answer = 0;
			for(int j=0; j<n; j++) {
				if(arr1[v][j]>=k) {
					answer++;
				}
			}
			bw.append(answer+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}	

}
