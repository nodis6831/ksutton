;------------------------------------
; CMSI 284, Homework #3, Problem #4
; Kelly Sutton
; Assembly language program printing UTF characters 32 through 126
;------------------------------------

	global 	main
	extern	printf

	section .text
main:
	mov	eax, 32		; start at character 32
	mov	ecx, 0 		; 16 characters per line
	pus	0		; terminating character
	push	10		; first new line

top:
	cmp	eax, 128	; last character
	je	done		; we're done

	cmp	ecx, 16		; if ecx == 16
	je	write_newline	; write a newline

	push	eax
	;push	format
	;call	printf
	;add	esp, 4		; moving down the stack


	inc 	ecx
	inc	eax

	jmp	top
	

write_newline:
	push	newline
	;call	printf
	add	esp, 4
	mov	ecx, 0
	jmp	top


done:
	call printf
	ret

format:
	db	'%c', 0

newline:
	db	10, 0		; just the newline character
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


