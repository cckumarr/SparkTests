Trouble shooting frequent spark issues and why it happens

1) bytebuffer issue

- spark shuffles can store only 2gb of data per partition, why ?
- ByteBuffer.allocate(length.toInt)
which makes the max size 2 gb
- solution increase the number of shuffle partitions, also there if the partitions used are over 2000 then spark has a different procedure to implement it.
-  default shuffle partitions size is 200, the lower the partitions the higher the shuffle block size.