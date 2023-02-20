class Stack:
	
    def __init__(self):
    	self.items = []
        
    # items 값이 비어있는지 아닌지를 검사하는 함수이다. 값이 없다면 true를 있다면 false를 반환한다
    def is_empty(self):
    	return len(self.items) == 0
        
	def push(self, item):
    	self.items.append(item)
        
	def pop(self, item):
    	# null Check
        if self.is_empty():
        	return None
        else:
        	return self.items.pop()
            
    # items 길이를 구한다.        
	def size(self):
    	return len(self.items)
        
    # 현재 item에 들어있는 값들을 보여준다.
    def print_stack(self):
    	print(self.items)
        
        
stack = Stack()

stack.push(1)
stack.push(2)
stack.push(3)

stack.pop()

print(stack.print_stack())