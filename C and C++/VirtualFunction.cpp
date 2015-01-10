/*
How do virtual functions work in C++
*/

Virtual function
--	a virtual function depends on a "vtbl"
--	if any function of a class is declared to be virtual, a vtable is constructed which stores addresses of the virtual functions of this class
--	the compiler also adds a hidden vptr variable in all such classes which points to the vtble of that class name
--	if a virtual function is not overridden in the derived class, the vable of the derived class stores the address of the function in its parent class name
--	the vtable is used to resolve the address of the function when the virtual function is called
