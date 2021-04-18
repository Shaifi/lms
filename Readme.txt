1. This library management system is created using spring-boot framework using annotation based processing.
2. There is one controller - InventoryController - to expose APIs to be used for add book,return book, borrow book and
return the book.
3. There is one service - InventoryServiceImpl - It contains all the business logic for the APIs
4. There are 3 entities used in the project - User,Inventory and BookIssue
5. There is 1 DTO - BookDTO to transfer the information from UI to backend
6. For the transactions JPA data repository is used. There are 2 JPA repositories - InventoryRepository and BookIssueRepository
7. There are 2 custom made exceptions - BookNotFoundException and BorrowingLimitException
8. Constants are placed in the LMSConstants file


When an API is called its control goes from InventoryController to InventoryService to InventoryServiceImp to InventoryRepository/
BookIssueRepository and then it flows back


This project implements the following functionalities :
1. Add a book in the inventory
2. Remove a book from the inventory
3. Issue a book to the user
4. Return a book by the user

