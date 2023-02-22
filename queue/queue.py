class Queue:
  
    def __init__(self):
      self.items = []

    def is_empty(self):
      return len(self.items) == 0

    def enqueue(self, item):
      self.items.append(item)

    def dequeue(self):
      if self.is_empty():
        return None
      else:  
        return self.items.pop(0)

    def print_queue(self):
      print(self.items)


queue = Queue()

queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
queue.dequeue()

print(queue.print_queue())
