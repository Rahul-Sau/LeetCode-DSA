class Solution {
        class Pair {
            char first;
            int second;

            Pair(char f, int s) {
                first = f;
                second = s;
            }
        }

    public String reorganizeString(String s) {
        int seat=0; StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> f = new HashMap<>();
        for (char c : s.toCharArray()) {
            f.put(c, f.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.second-a.second //max
        );
        for (Map.Entry<Character, Integer> i : f.entrySet()) {
            pq.add(new Pair(i.getKey(), i.getValue()));
        }
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(seat==0 || res.charAt(seat-1)!=p.first){
                res.append(p.first);
            seat++;
            p.second--;
            if(p.second>0)
            pq.add(p);
            }
            else{
                if(pq.isEmpty())
                return "";
                Pair p2=pq.poll();
                res.append(p2.first);
                seat++;
                p2.second--;
                if(p2.second>0)
                pq.add(p2);
                pq.add(p);
            }
        }
        return res.length() == s.length() ? res.toString() : "";
    }
}