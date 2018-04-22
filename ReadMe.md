This repo is for notes and the tests i want run on spark and scala

the terminology used in spark and their explanations are below

REPL = read eval print loop

under sbt > console  
compile = to compile the code
run = run the code  
test = run the test

Scala classes are like java classes

Traits are like interfaces in java but they can also contain concrete members

Objects in scala are like classes, but with one instance. members of the object are accessible.

Packages work same as java

DataFrames  
a table of data with rows and columns, the columns are names and the dataframe can be partitioned across several machines

Driver  
its what sends which process to run to the executors

Cluster manager  
its the process that keeps track of the resources available on the executors

Partitions  
partitions exist for parallelism, the data is partitioned to several machines, if only one partition exists then there will be no parallelism.

Transformations  
modifying a data frame is called a transformation, dataframes are immutable.
transformations allow us to build up a logical transformation plan but it not perform the transformation till an action is called.
there are two type of transformations narrow and wide, if the transformation can be done without requiring data from other severs then its narrow else its wide.

Shuffle
when spark exchanges partitions across the cluster. When we perform a shuffle spark writes the results to the disk. default shuffle partitions is 200. can be changed by example spark.conf.set("spark.sql.shuffle.partitions", "5")

Pipelining  
with narrow transformations spark will automatically perform an opetaion called pipelinning which is if we specify multiple filters on dataframes they will all be performed in memory.

Predicate pushdown  
certain parts of the sql queries can be "pushed"(implemented) on the server where the data lives. this can drastically optimise the processing time by filering out data earlier rather than later. example: filering out data before it is sent over the network.
what the heck is a predicate ? a predicate is a function that returns a boolean.

Lazy evaluation  
it means that spark will wait till the very last moment that the information is required, and gather all the specified operations perform optimisations such as the predicate pushdown mentioned above.

Actions  
Action methods instruct spark to compute the transformations requested by the user.

Count action  
by specifying a count action we start a spark job that runs the transformations on narrow or wide level and collects the count on a per partition basis and then brings the result to the native object being used.

Schema inference  
means that we want spark to take the best guess at what the df should be. spark reads a bit into the data and then attempts to to parse those data types that are valid in spark

explain method  
explain on any dataframe object will give the df's lineage

Structured apis are:   
datasets  
dataframes  
sql tables and views  

Dataset api  
it gives us the ability to assign a java scala ckass to the records within a df and manipulate it as a collection of typed objects. dataset is typesafe which is that you cannot view the contents of the dataset from another class.

spark uses an internal engine called catalyst.

dataframes and datasets diff  
dataframes are datasets of the type ROW which is sparks internal representation of its opeimized in memory format for computation, is uses this instead of using jvm types becos then it avoids the the costs of high garbage collection and objection instantiation.
datasets are only avaliable to jvm based langs.
df's checks types line up to those specified at runtime and datasets on the do that at compile time.

what spark does with the code you write

1) you write dataframe/dataset/sqlcode
2) if valid code spark converts this to a logical plan
3) then this is transformed into a physical plan, checking for optimizations along the way
4) execute the physical plan

remember that we can check the physical plans by using the explain method
dataframe/dataset/sqlcode goes through the catalyst optimizer

Catalog
spark uses the catalog, a repo of all the table and df information to resolve column names and tables in the analyser, lies in between creating logical plan and analysing user code.

logical plan  
user code is passed through the analyser and the analyser check the catalog for column and tables, using which is creates a non optimised/resolved logical plan which is sent to the catalyst optimiser and we get the optimized logical plan, this plan is internal to spark and nothing is being executed, optimization could be pushing down predicated or selections.

physical plan  
this is the plan that will be executed, it specifies how the lofical plan will be executed on the cluster. it decides the best physical execution plan depending on the cost model, example choosing how to perform a join by looking at the physical attributes of a given table. this results in a series of rdds.

printSchema  
this can be used to view the schema of the df

Schemas  
when using spark for production its good to define schemas manually. sometimes long can be considered as when we leave it to spark
on running the .schema the last boolean field specifies if null and missing values are allowed.

Expression  
an expression is a set of transformations on one or more values on a record in a dataframe.  expr("someCol") is equivalent to col("someCol")

Memory Managerment
spark uses a dynamic memory management cache for execution and storage. execution can override storage and storage blocks of LRU memory will be dropped.

 









Sources used:
Spark the definitive guide

Questions to readup on:
if spark converts dataframes and datasets to rdd then why are they called efficient as opposed to direclty using rdds

why functional programming ?
