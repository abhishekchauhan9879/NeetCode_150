class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int result[] = new int[triplets[0].length];//created array to store the max

        for(int triplet[]:triplets){
            int a=triplet[0];
            int b=triplet[1];
            int c=triplet[2];

            if(a>target[0] || b> target[1] || c>target[2]){
                continue;
            }
            for(int i=0;i<triplet.length;i++){
                result[i]=Math.max(result[i], triplet[i]);
            }
        }

        return Arrays.equals(result, target);
    }
}
