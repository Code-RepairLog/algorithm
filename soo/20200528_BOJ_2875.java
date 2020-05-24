import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		// 여학생의 수
		int N = Integer.parseInt(token.nextToken());
		// 남학생의 수
		int M = Integer.parseInt(token.nextToken());
		// 인턴쉽에 참여해야하는 인원 수
		int K = Integer.parseInt(token.nextToken());
		
		int max = matchMaxTeam(N, M, K);
		System.out.println(max);
	}
	/**
	 * 대회는 2명의 여학생과 1명의 남학생이 팀을 결성해야한다
	 * 인턴십에 참여하는 학생은 대회에 참여하지 못한다
	 * 
	 * @return 최대 매칭할 수 있는 팀 수
	 */
	public static int matchMaxTeam(int N, int M, int K) {
		int team = 0;
		int left = N+M;
		// 팀구성을 위한 남여학생수가 충분하면서 인턴십에 참여하는 학생수가 충분할동안 반복
		while(left>= K+3 && N>=2 && M>=1) {
			N -= 2;
			M -= 1;
			team ++;
			left = N+M;
		}
		return team;
	}
}
