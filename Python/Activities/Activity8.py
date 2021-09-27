
#Main list 
lstmain = []
 
# number of elements as input
n = int(input("Enter number of elements : "))
 
# iterating till the range
for i in range(0, n):
    ele = int(input())
 
    lstmain.append(ele) # adding the element
     
print(lstmain)

firstElement = lstmain[0]
lastelement = lstmain[-1]

if(firstElement == lastelement):
    print(True)
else:
    print(False)