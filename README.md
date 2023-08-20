# todoAPI
1. POST API : `http://localhost:8080/todoAPI/AddTodo`
    >Request JSON :
      ```json
      {
          "task": "Testing10"
      }
      ```

    >Response :
      ```json
      {
          "id": 10,
          "task": "Testing10",
          "createdOn": "2023-08-21T00:34:18.5608231",
          "updatedOn": null,
          "deletedOn": null
      }
      ```

2. PUT API : `http://localhost:8080/todoAPI/ChangeTodo`
    >Request JSONN :
    ```json
    {
        "id":"2",
        "task": "Updated Test Task"
    }
    ```
    >Response :
    ```json
    {
        "id": 2,
        "task": "Updated Test Task",
        "createdOn": "2023-08-20T22:51:07.570775",
        "updatedOn": "2023-08-21T00:17:07.1043311",
        "deletedOn": null
    }
    ```

3. DELELTE API : `http://localhost:8080/todoAPI/RemoveTodo?id=2`
    >Response :
    ```json
    {
        "message": "Successfully Deleted Task with id : 2"
    }
    ```

4. GET API : `http://localhost:8080/todoAPI/TodoList?page=2&size=5&sort=id,DESC`
    >Response :
    ```json
    {
        "taskList": [
            {
                "id": 5,
                "task": "Testing5",
                "createdOn": "2023-08-21T00:20:14.047385",
                "updatedOn": null,
                "deletedOn": null
            },
            {
                "id": 4,
                "task": "Testing4",
                "createdOn": "2023-08-21T00:20:08.979355",
                "updatedOn": null,
                "deletedOn": null
            },
            {
                "id": 3,
                "task": "Testing3",
                "createdOn": "2023-08-21T00:19:59.352299",
                "updatedOn": null,
                "deletedOn": null
            }
        ],
        "currentPageNo": 2,
        "totalPageNo": 2
    }
    ```
