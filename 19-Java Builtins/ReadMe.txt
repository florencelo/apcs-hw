1. The difference between Hashmap and Hashset is Hashmap uses hashtable while Hashset uses hash functions. Hashset also has basic operations that Hashmap doesn't have and vice versa. Treemap uses keys and Treeset uses comparable interface. 

2. Treemap implementation is log(n) time cost for the containsKey, get, put and remove operations. Hashmap implementation provides constant-time performance for the basic operations (get and put), assuming the hash function disperses the elements properly among the buckets. Hashset has constant time performance for the basic operations (add, remove, contains and size), assuming the hash function disperses the elements properly among the buckets. TreeSet implementation is log(n) time cost for the basic operations (add, remove and contains).

3. Speed comparison: hashmap vs treemap
Observation: Hashmap inserts and looks up information much faster than Treemap. Since Hashmap uses arrays, it's easy to look up information without iterating over everything.

4. Does Java have a builtin heap? Yes. HeapPriorityQueue. 

5. Implement running medium using it.
