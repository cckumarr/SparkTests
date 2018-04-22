Things to watch our for

<H3>Skews</H3>  
what are skews ?  
in distributed systems we assume that work is being divided over servers cores/nodes but when 1 core is doing all the work that can be divided and takes longer because of that, this is call skew. this could happen for a variety of reasons.  
how to fix it ?  
salting  
isolated salting  
mapjoins

<H3>Cartesian joins</H3>
what is it ?  
how to fix it ?
nested structures
windowing
skip steps

use methods that force the workers to do the work and not the driver
example treerduce over reduce, tree reduce sends the results to the driver and not the entire data over.

<H3>Out of memory</H3>
need to watch out for the usages of actions/methods that return unbounded data, example collect, countbykey etc


<H6>Questions thoughts for myself
 sql does not seem to be the best etl language, but in out prod application case we have used it so brace for changes ie used stored procedures so that we can make changes to the stored procedure and not to the code, note to self try to find better alternative.

