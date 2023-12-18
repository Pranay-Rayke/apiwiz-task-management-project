# apiwiz-task-management-project (Backend Project)

Project Overview - The Task Management API facilitates CRUD operations on tasks. This documentation guides you through the API's feature, database integration and additional functionalities.

1. API Authentication:

1.1 User Authentication:
The API employs user authentication to restrict access to authorized users.
Admin users have full access to all tasks.

1.2 Implementation Details:
Describe the authentication mechanisms used.
Provide specifics on admin user privileges.
      
2. Task Operations:
   
2.1 Creating Tasks
   
2.2 Retrieving Tasks

2.3 Updating and Deleting Tasks:

3. Database Integration:
Database: task_management_api

4. Pagination and Sorting:
Pagination integrated into the /tasks endpoint.
Sorting options available for the task list.

5. Additional Features:
Filtering options for the task list based on specific criteria.
Proper error handling with clear status codes in API responses.

6. Conclusion:
The Task Management API presents a robust solution for handling tasks with a focus on simplicity, efficiency, and extensibility. With essential CRUD operations supported, coupled with user authentication and admin privileges, the API ensures a secure and customizable task management experience.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Pre Requisite - Intellij IDEA, MySQL (Database)

Tech Stack - Java, Spring Boot


How to run the project ?

1) Clone Repository - https://github.com/Pranay-Rayke/apiwiz-task-management-project.git

2) Create a MySQL Database - task_management_api

3) Go to application.properties - Set your MySQL Username and Password

4) Run the Project

5) Go to the browser and paste the url - http://localhost:8080/swagger-ui/index.html

6) Now you can directly access the API.


//Project Completed...But i am currently working on DTO & Transformer.
