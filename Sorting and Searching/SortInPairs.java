/*
A circus is designing a tower routine consisting of people standing atop one another's shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
*/

//have a list of pairs of items. Find the longest sequence such that both the first and second items are in non-decreasing order
//simply sort one list, then apply the longest increasing subsequence algorighm on the other list

//runtime: O(N^2)