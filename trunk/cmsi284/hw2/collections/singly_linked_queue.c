

#include <stdlib.h>
#include "singly_linked_queue.h"

struct Node;
typedef struct Node* Link;



/*
 * This sucker is implemented as an array of linked strings
 */
 
struct Node {
	char* item;
	Link next;
};

struct Q {
	Link* data;
	unsigned int capacity;
	QueueFunction queue;
};

Link newNode(char* item, Link next){
	
	
	
	
	
	
	
}