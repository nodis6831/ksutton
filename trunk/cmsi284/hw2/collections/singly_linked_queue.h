#ifndef SINGLY_LINKED_QUEUE_H_
#define SINGLY_LINKED_QUEUE_H_

#endif /*SINGLY_LINKED_QUEUE_H_*/

/*
 * singly_linked_queue.h
 * 
 * An abstract data type for a singly-linked list of strings
 */

 
 typedef struct Q* LinkedQueue;
 
 typedef int (*QueueFunction)(char*);
 
 /*
  * Queue Operations
  */
  
  LinkedQueue createSinglyLinkedQueue(unsigned int capacity, QueueFunction queue);
  void enqueue(LinkedQueue queue, char* item);
  void removeItem(LinkedQueue queue, char* item);
  int containsItem(LinkedQueue queue, char* item);
  void destroyLinkedQueue(LinkedQueue queue);
  
  