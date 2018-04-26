# Performance tuning tips

#### Skews
**what are skews ?**  
in distributed systems we assume that work is being divided over servers cores/nodes but when 1 core is doing all the work that can be divided and takes longer because of that, this is call skew. this could happen for a variety of reasons.  
**how to fix it ?**  
- salting  
- isolated salting  
- mapjoins  

**how to detect it?**

#### Cartesian joins
**what is it ?**  
**how to fix it ?**  
- nested structures  
- windowing  
- skip steps  

**how to detect it ?**

use methods that force the workers to do the work and not the driver
example treerduce over reduce, tree reduce sends the results to the driver and not the entire data over.

#### Out of memory
need to watch out for the usages of actions/methods that return unbounded data, example collect, countbykey etc

#### toDebugString  
  the numbers in the brackets indicate the level of parallelism
  
#### using Coalesce  
suppose you are reading a large quantity of data and filter on it such that a large portion of the data has been removed from it, spark keeps the same number of partitions, this can be seen by using .getNumPartitions(),
does leaving some partitions empty this can be coalesced manually to a smaller number, thus reducing the work spark has to do and shaving off a couple of seconds,
also if you have lots of idle tasks then it could be good to use coalesce

#### Serializers  
by default spark uses java serializers, there are others out there that are faster such as kryo

#### Compression  
the default spark compression is snappy, which works really well for large databases, 100k partitions, better there,
switching to LZF might help

#### Speculative execution  
Spark when it sees something running slowly it will create a copy of that job and see which one completes first, this could prevent stragglers.  
`
conf.set("spark.speculation","true"
`

#### Caching  
memory_only - stores as deserialized jvm objects, heavy on the gc
memory_only_ser - will help cut down on a gc but could be a little slower bcos its serialized
memory_and_disk - self explanatory

#### Questions thoughts for myself  
 sql does not seem to be the best etl language, but in out prod application case we have used it so brace for changes ie used stored procedures so that we can make changes to the stored procedure and not to the code, note to self try to find better alternative.

 does runjob() run on driver or the workers ? i am assuming the driver but will need to see it somewhere in print :-)
 
  


