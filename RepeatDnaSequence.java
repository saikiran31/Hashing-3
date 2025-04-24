class RepeatDnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
        int n= s.length();
        if(n<10)
        return new ArrayList<>();
        Map<Character,Integer> m = new HashMap<>();
        m.put('A',1);
        m.put('C',2);
        m.put('G',3);
        m.put('T',4);
        int curhash=0;
        HashSet<Integer> subseqs = new HashSet<>();
        HashSet<String> res = new HashSet<>();
         for(int i=0;i<10;i++)
        {
            char in = s.charAt(i);
             curhash = curhash*4+ m.get(in);
        }
        subseqs.add(curhash);
        for(int i=1;i<n-9;i++)
        {
            //out
            char out = s.charAt(i-1);
            curhash = curhash - (int)Math.pow(4,9)*m.get(out);

            char in = s.charAt(i+9);
            curhash = curhash*4+ m.get(in);
            if(subseqs.contains(curhash))
            {
                res.add(s.substring(i,i+10));
            }
            else{
                subseqs.add(curhash);
            }
        }
        return new ArrayList<>(res);
        
    }
}

//tc: O(n)
//sc: O(n)