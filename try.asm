.MODEL SMALL
.STACK 1000H
.Data
	 CR EQU 0DH
	 LF EQU 0AH
	 number DB "00000$"
.CODE
main PROC
	MOV AX,@DATA
	MOV DS,AX
	PUSH BP
	MOV BP,SP
	SUB SP,2
	SUB SP,2
	SUB SP,2
	MOV AX,3
L1:
	MOV [BP-2],AX
	MOV AX,8
L2:
	MOV [BP-4],AX
	MOV AX,6
L3:
	MOV [BP-6],AX
L4:
	MOV AX,[BP-2]
	 MOV DX,AX
	MOV AX,3
	MOV AX,3
	CMP DX,AX
	JE L5 ;true 
	JMP L6 ;false
L5:
	MOV AX,1 ;equal
	JMP L7 ;print
L6:
	MOV AX,0 ;not equal
	JMP L8 ;dont print,else or new rule 
L7:
	MOV AX,[BP-4]
	CALL print_output
	CALL new_line
L8:
L9:
	MOV AX,[BP-4] ;new rule
	 MOV DX,AX
	MOV AX,8
	MOV AX,8
	CMP DX,AX
	JL L10 ;true, 
	JMP L11 ;false
L10:
	MOV AX,1
	JMP L12 ;go to print
L11:
	MOV AX,0
	JMP L13 ;go to else if,make it L14
L12:
	MOV AX,[BP-2]
	CALL print_output
	CALL new_line ;cannot sit here, have to jump to else's end,so call label+2 at L13
L13: ;JMP L15
L14:
	MOV AX,[BP-6]
	CALL print_output
	CALL new_line
L15:
L16:
	MOV AX,[BP-6]
	 MOV DX,AX
	MOV AX,6
	MOV AX,6
	CMP DX,AX
	JNE L17
	JMP L18
L17:
	MOV AX,1
	JMP L19
L18:
	MOV AX,0
	JMP L20
L19:
	MOV AX,[BP-6]
	CALL print_output
	CALL new_line
L20:
L21:
	MOV AX,[BP-4]
	 MOV DX,AX
	MOV AX,8
	MOV AX,8
	CMP DX,AX
	JMP L23
L22:
	MOV AX,[BP-4]
	CALL print_output
	CALL new_line
L23:
L24:
	MOV AX,[BP-2]
	 MOV DX,AX
	MOV AX,5
	MOV AX,5
	CMP DX,AX
	JL L25
	JMP L26
L25:
	MOV AX,1
	JMP L27
L26:
	MOV AX,0
	JMP L28
L27:
	MOV AX,[BP-2]
	CALL print_output
	CALL new_line
L28:
	MOV AX,0
L29:
	MOV [BP-6],AX
L30:
	MOV AX,[BP-6]
	CALL print_output
	CALL new_line
L31:
L32:
L33:
	MOV AX,0
	MOV AX,4CH
	INT 21H
main ENDP
new_line proc
    push ax
    push dx
    mov ah,2
    mov dl,cr
    int 21h
    mov ah,2
    mov dl,lf
    int 21h
    pop dx
    pop ax
    ret
new_line endp
print_output proc  ;print what is in ax
    push ax
    push bx
    push cx
    push dx
    push si
    lea si,number
    mov bx,10
    add si,4
    cmp ax,0
    jnge negate
print:
    xor dx,dx
    div bx
    mov [si],dl
    add [si],'0'
    dec si
    cmp ax,0
    jne print
    inc si
    lea dx,si
    mov ah,9
    int 21h
    pop si
    pop dx
    pop cx
    pop bx
    pop ax
    ret
negate:
    push ax
    mov ah,2
    mov dl,'-'
    int 21h
    pop ax
    neg ax
    jmp print
print_output endp

end main
