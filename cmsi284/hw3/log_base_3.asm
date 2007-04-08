;Here is an asm function that computes
; ln(x) 
;
; double ln(double x)

	global	log_base_3
log_base_3:
	fld1			;
	fld	qword	[three]
	fyl2x			; log base 2 of 3
	fld1
	fdiv	st1		; computing reciprocal of log base 2 of 3
	fld	qword	[esp+4] ; load in our x as a 64-bit float
	fyl2x			; taking the log base 2 of y, pops the stack
				; we've got the log base 3 of x
	ret

three:	dq	3.0		; loading 3.0 into memory

