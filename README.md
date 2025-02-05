# Java Data Structures Library

[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/Vinokaa/JavaDataStructures/blob/master/README.pt-br.md)

This library contains the most common data structures used, and was completely made by me during my 4º semester in college for the Structured Problem Solving in Computing classes (originally Resolução de Problemas Estruturados
em Computação).

The data structures available in this library are:

# Linked List

Basically a data structure that allocates memory as needed, so that it can store values dinamically.

The way that it works is that the list is initially null, but as values are inserted into it, nodes are created (allocated in memory) with the value that was inserted into the list along with the memory address of the next node of the list, which will always be null at the end of the list.

# Doubly Linked List

Same as the Linked List, but can be traversed backwards.

The node from the Doubly Linked List also contains the memory address of the node before it, making it possible for it to be traversed in both ways. The node before the first one, and the node after the last are always null, signaling the end.

# Circular Linked List

A Doubly Linked List that goes back to the start if it reaches the end, or goes to the end if it goes backwards at the first value.

Differently from the Doubly Linked List, the last node of the list has the first node as its next, and the first node has the last node as its previous.

# Stack

A Linked List that follows the LIFO (Last In First Out) principle, in which the value that is inserted into the Stack always goes at the top/end of the List, and when a value is removed, it gets removed from the top/end.

One common example of where this structure is used is in code parsers, where a symbol like ( needs to be closed in the correct order.

# Queue

A Linked List that follows the FIFO (First In First Out) principle, in which the value that is inserted into the Queue always goes at the top/end of the List, and when a value is removed, it gets removed from the bottom/start.

One common example of where this structure is used is when two sorted Lists need to be merged into another sorted List, since you always take the first value of the List to move it to the new one.

# Hash Table

An array of Linked Lists, where the values inserted go through a hashing algorithm to determine the index of the array where it goes into.

Hash Tables can use many different hashing algorithms, but in this case, I used the simplest one, which is the modulo (remainder after division) to determine the index. It is a great structure due to the fact that when searching for a value, you know in which array index this value has to be, ignoring the many other values that could be before it in a Linked List equivalent.

# Binary Tree

The most complex data structure, but also very good at performance.

The rule of the Binary Tree is that every node can have two child nodes, a left node and a right node, and the left node always has to contain a value that is lower than the parent node, and the right node always has to contain a value higher or equal to the parent node.

It has a great performance because you reduce about half of the amount of searches for every node that you search, considering that the Binary Tree is balanced.

The Binary Tree provided in this library has an automatic balancing mechanism, meaning that whenever a value is inserted or removed, the Binary Tree is checked to see if it became unbalanced due to the change, and if it is, it is automatically adjusted.
