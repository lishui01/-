count = 0
print(2,end=" ")
for i in range(2 ,2001):
	j = 2  
	while True:  
		if i % j != 0:  
			j += 1
		else: 
			break
		if j == i:   
			print(i,end=" ")
			count += 1  
			if count % 5 == 0:
				print(end="\n")