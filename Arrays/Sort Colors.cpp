/*            Scroll below to see JAVA Code also                */
/*
    MY YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=KDiZ3jGXxO8
    Company Tags                : Adobe, Amazon, Hike, MakeMyTrip, MAQ Software, Microsoft, Morgan Stanley, Ola Cabs,
                                  OYO Rooms, Paytm, Qualcomm, Samsung, SAP Labs, Snapdeal, Walmart, Yatra.com, Flipkart
    Leetcode Link               : https://leetcode.com/problems/sort-colors/
*/


/**************************************************** C++ ****************************************************/
//Approach-1 : Sorting
//T.C : O(n*log(n))
//S.C : O(1)
class Solution {
public:
    void sortColors(vector<int>& nums) {
        sort(begin(nums), end(nums));
    }
};
  

//Approach-2 (Using counting)
//T.C : O(n+n)
//S.C : O(1)
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        
        for(int &num : nums) {
            if(num == 0)
                count_0++;
            else if(num == 1)
                count_1++;
            else
                count_2++;
        }
        
        for(int i = 0; i<n; i++) {
            if(count_0 > 0) {
                nums[i] = 0;
                count_0--;
            } else if(count_1 > 0) {
                nums[i] = 1;
                count_1--;
            } else if(count_2 > 0) {
                nums[i] = 2;
                count_2--;
            }
        }
    }
};

  
//Approach-3 (Follow up) : O(n)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        
        int i = 0;   //denotes for 0
        int j = 0;   //denotes for 1
        int k = n-1; //denotes for 2
        
        while ( j <= k) {
            if(nums[j] == 1) {
                j++;
            } else if(nums[j] == 2) {
                swap(nums[j], nums[k]);
                k--;
            } else { //nums[j] == 0
                swap(nums[j], nums[i]);
                i++;
                j++;
            }
        }
    }
};



/**************************************************** Java ****************************************************/
// Approach-1 : Sorting
// T.C : O(n*log(n))
// S.C : O(1)
class Solution1 {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

// Approach-2 (Using counting)
// T.C : O(n+n)
// S.C : O(1)
class Solution2 {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        for (int num : nums) {
            if (num == 0)
                count_0++;
            else if (num == 1)
                count_1++;
            else
                count_2++;
        }

        for (int i = 0; i < n; i++) {
            if (count_0 > 0) {
                nums[i] = 0;
                count_0--;
            } else if (count_1 > 0) {
                nums[i] = 1;
                count_1--;
            } else if (count_2 > 0) {
                nums[i] = 2;
                count_2--;
            }
        }
    }
}

// Approach-3 (Follow up) : O(n)
// T.C : O(n)
// S.C : O(1)
class Solution3 {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;   // denotes for 0
        int j = 0;   // denotes for 1
        int k = n - 1; // denotes for 2

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            } else { // nums[j] == 0
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}

