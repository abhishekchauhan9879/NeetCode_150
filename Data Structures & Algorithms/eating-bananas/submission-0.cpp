class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int maxElement = *max_element(piles.begin(), piles.end()); // Find the max element
        int left = 1, right = maxElement;

        while(left<right){
            int mid=left+(right-left)/2;//no of banana he can eat per hour

            int hoursNeeded=0;
            for (auto pile:piles){
                hoursNeeded+=(pile+mid-1)/mid;
            }
            if(hoursNeeded<=h){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
};
