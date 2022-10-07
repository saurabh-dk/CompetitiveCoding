class Solution {
    public int largestVariance(String s) {
        int [] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++)
            freq[(int)(s.charAt(i) - 'a')] += 1;
        
        int maxVariance = 0;
        for(int a = 0 ; a < 26 ; a++){
            for(int b = 0 ; b < 26 ; b++){
                int remainingA = freq[a];
                int remainingB = freq[b];
                if(a == b || remainingA == 0 || remainingB == 0) continue;
                
				// run kadanes on each possible character pairs (A & B)
                int currBFreq = 0, currAFreq = 0;
                for(int i = 0 ; i < s.length() ; i++){
                    int c =  (int)(s.charAt(i) - 'a');
                    
                    if(c == a) {
                        remainingA--;
                        currAFreq++;
                    }
                    
                    if(c == b) currBFreq++;
                    
                    if(currBFreq < currAFreq &&  remainingA >= 1){
                        currAFreq = 0;
                        currBFreq = 0;
                    }
                    
                    if(currAFreq > 0)
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);
                }
            }
        }
        
        return maxVariance;
    }
}