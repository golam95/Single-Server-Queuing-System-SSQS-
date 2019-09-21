import java.util.Scanner;

public class Multi {
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		// declar variable
		int clock_arrival = 0;
		// Declar array
		int num_Customer[] = new int[6];
		int time_Arrival[] = new int[6];
		int clock_Arrival[] = new int[6];
		int randomdigit_Service[] = new int[6];
		// Array for able server
		int timeservice_begin_able[] = new int[6];
		int servicetime_able[] = new int[6];
		int timeserviceend_able[] = new int[6];

		// Array for baker server
		int timeservice_begin_baker[] = new int[6];
		int servicetime_baker[] = new int[6];
		int timeserviceend_baker[] = new int[6];
		int wa[] = new int[6];

		// Array for waiting time
		int waiting_Time[] = new int[6];

		System.out.println("Enter (6) customers:");
		for (int c = 0; c < 6; c++) {
			num_Customer[c] = in.nextInt();
		}

		System.out.println("Enter Time Between Arrival Time: ");

		for (int a = 1; a < 6; a++) {
			time_Arrival[a] = in.nextInt();
			clock_arrival += time_Arrival[a];
			clock_Arrival[a] = clock_arrival;
		}

		System.out.println("Enter Random Digit for service: ");

		for (int s = 0; s < 6; s++) {
			randomdigit_Service[s] = in.nextInt();
		}

		// check the random digit service for able

		for (int j = 0; j < 6; j++) {
			if (randomdigit_Service[j] >= 1 && randomdigit_Service[j] <= 30) {
				servicetime_able[j] = 2;
			} else if (randomdigit_Service[j] >= 31 && randomdigit_Service[j] <= 58) {
				servicetime_able[j] = 3;
			} else if (randomdigit_Service[j] >= 59 && randomdigit_Service[j] <= 83) {
				servicetime_able[j] = 4;
			} else if (randomdigit_Service[j] >= 84 && randomdigit_Service[j] <= 100) {
				servicetime_able[j] = 5;

			}
		}

		// check the random digit service baker

		for (int j = 0; j < 6; j++) {
			if (randomdigit_Service[j] >= 1 && randomdigit_Service[j] <= 35) {
				servicetime_baker[j] = 3;
			} else if (randomdigit_Service[j] >= 36 && randomdigit_Service[j] <= 60) {
				servicetime_baker[j] = 4;
			} else if (randomdigit_Service[j] >= 61 && randomdigit_Service[j] <= 80) {
				servicetime_baker[j] = 5;
			} else if (randomdigit_Service[j] >= 81 && randomdigit_Service[j] <= 100) {
				servicetime_baker[j] = 6;

			}
		}

		// check where it go able or baker
		for (int i = 0; i < 6; i++) {

			if (timeserviceend_able[0] == 0 && timeserviceend_baker[0] == 0) {
				// access the code for able
				timeservice_begin_able[i] = clock_Arrival[i];
				timeserviceend_able[i] = timeservice_begin_able[i] + servicetime_able[i];
				servicetime_able[i] = servicetime_able[i];

			} else if (clock_Arrival[i] < timeserviceend_able[i - 1]
					&& clock_Arrival[i] > timeserviceend_baker[i - 1]) {
				// baker
				timeservice_begin_baker[i] = clock_Arrival[i];
				timeserviceend_baker[i] = timeservice_begin_baker[i] + servicetime_baker[i];
				servicetime_baker[i] = servicetime_baker[i];

			} else if (clock_Arrival[i] > timeserviceend_able[i - 1]
					&& clock_Arrival[i] > timeserviceend_baker[i - 1]) {
				// able
				timeservice_begin_able[i] = clock_Arrival[i];
				timeserviceend_able[i] = timeservice_begin_able[i] + servicetime_able[i];
				servicetime_able[i] = servicetime_able[i];

				// New able

			} else if (clock_Arrival[i] > timeserviceend_able[i - 1]
					&& clock_Arrival[i] < timeserviceend_baker[i - 1]) {
				timeservice_begin_able[i] = clock_Arrival[i] + 1;
				timeserviceend_able[i] = timeservice_begin_able[i] + servicetime_able[i];
				servicetime_able[i] = servicetime_able[i];
				wa[i] = 1;
			} else {
				System.out.println("Not working");
			}
		}

		// check service time

		for (int m = 0; m < 6; m++) {
			if (timeservice_begin_able[m] == 0 && timeserviceend_able[m] == 0) {
				servicetime_able[m] = 0;
			} else if (timeservice_begin_baker[m] == 0 && timeserviceend_baker[m] == 0) {
				servicetime_baker[m] = 0;
			}
		}

		// cehck service time

		//

		System.out.println("Cus" + "\t" + "A_T" + "\t" + "C_T" + "\t" + "R_S" + "\t" + "T_S_B" + "\t" + "S_T" + "\t"
				+ "T_S_E" + "\t\t" + "T_S_B" + "\t" + "S_T" + "\t" + "T_S_E" + "\t" + "WCC");
		for (int i = 0; i < 6; i++) {

			System.out.println(num_Customer[i] + "\t" + time_Arrival[i] + "\t" + clock_Arrival[i] + "\t"
					+ randomdigit_Service[i] + "\t" + timeservice_begin_able[i] + "\t" + servicetime_able[i] + "\t"
					+ timeserviceend_able[i] + "\t\t" + timeservice_begin_baker[i] + "\t" + servicetime_baker[i] + "\t"
					+ timeserviceend_baker[i] + "\t" + wa[i]);
		}

	}

}
