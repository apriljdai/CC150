/*
Compare and contrast a hash table and an STL map. How is a hash table implemented? If the number of inputs is small, which data structure options can be used instead of a hash table
*/

Hash Table:
--	a value is stored by calling a hash function on a key. Values are not stored in sorted order.
--	hash tables use the key to find the index that will store the value, an insert or lookup can be done in amortized O(1) time
--	one must also handle potential collisions, often done by chaining(create a linked list)

STL Map:
--	inserts the key/value pairs into a binary search tree based on the keys
--	no need to handle collisions
--	the insert and lookup time is guaranteed to be O(logN) since the tree is balanced.

How is a Hash Table implemented
--	a hash table is traditionally implemented with an array of linked list. When we want to insert a key/value pair, we map the key to an index in the array using a hash function.
--	the elements in a linked list at a particular index of the array do not have the same key. But hashFunction(key) is the same for these values. In order to retrieve the value for a specific key, we need to stre in each node both the exact key and the value(the value and the original key)
--	if the number of inputs is small, we can use an STL map or a binary tree instead of a hash table