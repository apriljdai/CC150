/*
Imgagine you have a 20GB file with one string per line. Explain how you would sort the file.
*/

//Do NOT bring all the data into memory->bring part of the data into memory

Divided the file into chunks which are x megabytes each, where x is the amount of memory we have available.
Each chunk is sorted separately and then saved back to the file system.
Once all the chunks are sorted, we then merge the chunks, one by one.
At the end, we have a fully sorted file.
This algorighm is known as external sort.

External Sort:
--	a term for a class of sorting algorithms that can handle massive amount of data.
--	required when the data being sorted not fit into the main memory of a computing device(usually RAM) and instead they must reside in the slower external memory(usually a hard drive)
--	tipically uses a gybrid sort-merge strategy
--	chunks of data small enough to fit in main memory are read, sorted, and written out to a temporary file
--	in the merge phase, the sorted subfiles are combined into a single large file.