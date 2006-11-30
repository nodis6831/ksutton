# 
# CMSI 281
# Ray Toal
#
# Homework #3
# Garrett Shannon 
# Kelly Sutton
#

#### 
# ACCESS
####

 To access the source for this project, enter 
 
 	svn checkout http://ksutton.googlecode.com/svn/trunk/hw3 ksutton
 	
 into your preferred Subversion-enabled shell.
 
### ASSIGNMENT CHECKLIST
# ( "+" indicates complete assignment )

    + Problems 7.6 and 7.8
    + Exercise 8.1 
    + Exercise 8.4
    + Exercise 10.5
    + Exercise 10.6
    + Exercise 10.12
    + Problem 10.8
    + Problem 10.11
    + Write a recursive method for the function A defined like this:
    	A(0, y) = y + 1				if y >= 0
    	A(x, 0) = A(x-1, 1 )		if x >  0
    	A(x, y) = A(x-1, A(x, y-1))	if x >  0, y > 0
    	#Should we be getting a stack overflow error when computing A(4, 2)??
    	
    	
    	
    	
