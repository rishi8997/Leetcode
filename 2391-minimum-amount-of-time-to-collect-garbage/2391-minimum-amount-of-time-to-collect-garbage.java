// Approach: Create an arraylist of 3 Pairs(for each garbage type), each pair storing number of units and the last house where that garbe is present. Create prefix array for travel, and compute for each pair, depending on whether travel needs to be added(If last house is first house then not required)


class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        ArrayList<Pair> truck = new ArrayList<>();
        Pair p1 = new Pair(0, -1);
        Pair p2 = new Pair(0, -1);
        Pair p3 = new Pair(0, -1);
        truck.add(p1);
        truck.add(p2);
        truck.add(p3);
        int ans = 0;
        for(int i=0; i<garbage.length; i++){
            for(int j=0; j<garbage[i].length(); j++){
                char c = garbage[i].charAt(j);
                if(c == 'P'){
                    truck.get(0).first++;
                    truck.get(0).second=i;
                }
                if(c == 'M'){
                    truck.get(1).first++;
                    truck.get(1).second=i;
                }
                if(c == 'G'){
                   truck.get(2).first++;
                    truck.get(2).second=i; 
                }
            }
        }
        //prefix travel:
        for(int i=1; i<travel.length; i++){
            travel[i]+=travel[i-1];
        }
        for(int i=0; i<3; i++){
            if(truck.get(i).second>0){
                ans+=travel[truck.get(i).second - 1] + truck.get(i).first;
            } else{
                ans+=truck.get(i).first;
            }
        }
        
        return ans;
        
    }
}