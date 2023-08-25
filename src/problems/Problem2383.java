package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2383
 * @since 2023/3/13 17:54
 */
public class Problem2383 {
    public static void main(String[] args) {

    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length, ans = 0, energies = 0;
        for (int i = 0, t; i < n; i++) {
            if (initialExperience <= experience[i]) {
                ans += (t = experience[i] + 1 - initialExperience);
                initialExperience += t;
            }
            initialExperience += experience[i];
            energies += energy[i];
        }
        return ans + Math.max(0, energies - initialEnergy + 1);
    }
}
