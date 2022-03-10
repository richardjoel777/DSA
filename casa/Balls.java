import java.util.*;

class Balls {
    
    static boolean isPossible(int[] d, int n)
    {
        int temp[] = d.clone();
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            if (temp[i] > i)
                return false;
        }
        return true;
    }

    static int merge(int arr[], int temp[],
			int left, int mid, int right)
{
	int inv_count = 0;

	/* i is index for left subarray*/
	int i = left;
	
	/* j is index for right subarray*/
	int j = mid;
	
	/* k is index for resultant merged subarray*/
	int k = left;
	
	while ((i <= mid - 1) && (j <= right))
	{
		if (arr[i] <= arr[j])
			temp[k++] = arr[i++];
		else
		{
			temp[k++] = arr[j++];

			/* this is tricky -- see above /
			explanation diagram for merge()*/
			inv_count = inv_count + (mid - i);
		}
	}

	/* Copy the remaining elements of left
	subarray (if there are any) to temp*/
	while (i <= mid - 1)
		temp[k++] = arr[i++];

	/* Copy the remaining elements of right
	subarray (if there are any) to temp*/
	while (j <= right)
		temp[k++] = arr[j++];

	/*Copy back the merged elements
	to original array*/
	for (i=left; i <= right; i++)
		arr[i] = temp[i];

	return inv_count;
}

// An auxiliary recursive function that
// sorts the input array and returns
// the number of inversions in the array.
static int _mergeSort(int arr[], int temp[],
						int left, int right)
{
	int mid, inv_count = 0;
	if (right > left)
	{
		// Divide the array into two parts and
		// call _mergeSortAndCountInv() for
		// each of the parts
		mid = (right + left)/2;

		/* Inversion count will be sum of
		inversions in left-part, right-part
		and number of inversions in merging */
		inv_count = _mergeSort(arr, temp,
								left, mid);
								
		inv_count += _mergeSort(arr, temp,
								mid+1, right);

		/*Merge the two parts*/
		inv_count += merge(arr, temp,
						left, mid+1, right);
	}

	return inv_count;
}

// This function sorts the input
// array and returns the number
// of inversions in the array
static int countSwaps(int arr[], int n)
{
	int temp[] = new int[n];
	return _mergeSort(arr, temp, 0, n - 1);
}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] g = new int[n][n];
        int[] d = new int[n];
        for(int i=0;i<n;i++)
        {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j) == 'G' ? 0 : 1;
                if (g[i][j] == 1)
                    d[i] = Math.max(d[i], j);
            }
        }

        // for (int i = 0; i < n; i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         g[i][j] = sc.nextInt();
        //         if(g[i][j] == 1)
        //             d[i] = Math.max(d[i], j);
        //     }
        // }
        
        sc.close();

        boolean possibility = isPossible(d, n);

        if (!possibility)
            System.out.println(-1);
        else
        {
            System.out.println(countSwaps(d, n));
        }
        // for(int i=0;i<n;i++)
        //     System.out.println(d[i]);
    }
}
