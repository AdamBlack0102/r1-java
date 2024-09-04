import java.util.List;
import java.util.Collections;

public class Perm {
  public void nextPermutation(List<Integer> perm) {
    int n = perm.size();

    // Find the longest non-increasing suffix
    int i = n - 2;
    while (i >= 0 && perm.get(i) >= perm.get(i + 1)) {
      i--;
    }

    if (i >= 0) {
      // Find the smallest element in the suffix that is greater than perm[i]
      int j = n - 1;
      while (perm.get(j) <= perm.get(i)) {
        j--;
      }

      // Swap perm[i] and perm[j]
      Collections.swap(perm, i, j);
    }

    // Reverse the suffix starting at i+1
    Collections.reverse(perm.subList(i + 1, n));
  }
}
