#numbers=[1,2,3,4,5]
	
numbers = list(input("Enter a sequence of comma separated values: ").split(","))
# calculate sum
result=0
for x in numbers:
    result =result + int(x)
    #print(x)
print(result)