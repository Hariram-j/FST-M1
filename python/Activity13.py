# Write a function sum() such that it can accept a list of elements and print the sum of all elements

def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum
numList = [10, 40, 60, 90]

# Call the sum() function with numList as argument
result = calculate_sum(numList)

# Print result with message
print("The sum of all the elements is: " + str(result))