# chat
# Chat Forum Server

Welcome to the server! This project is a chat forum server developed using Spring Java and a MySQL database. In this README.md file you will find information about server functionality, API and usage examples.

## Description

This server is designed to run a chat forum and has a system of user authentication. The MySQL database is used to store data.

## Examples of API usage

List of links available to unauthorized users:

- `/user/registration` - New user registration. Accepts JSON object as input. Example object: { "nickname": "Dracula", "login": "vlad", "password": "1111" }

- `/login` - Authorization on the server. Performs by POST request with parameters `username` (это поле `login` в `user`) and `password`.

- `/index.html` - Here you will find brief instructions on how to use the server.

### User (/user)

- `/user/{id}` - Returns the specific user by `id` from `@PathVariable`.
- `/user/nicknames` - Returns a list of all user nicknames.
- `/user/all` - Returns a list of all users and their messages.
- `/user/registration` - `@PostMapping`, registers a new user in the system. Accepts JSON as input. Example: { "nickname": "Dracula", "login": "Vlad", "password": "1111" }
- `/user/update/{id}` - `@PutMapping`, updates user data. Accepts JSON as input. Example: { "nickname": "Updated", "login": "Ivan", "password": "2222" }
- `/user/delete/{id}` - `@DeleteMapping` deletes the message by `id` transmitted with `@PathVariable`.

### Message (/message)

- `/message/all` - Outputs all messages.
- `/message/{id}` - Outputs a specific message by `id` from `@PathVariable`.
- `/message/ofUser/{id}` - Outputs all messages of the user found by `id` from `@PathVariable`.
- `/message/create` - `@PostMapping`, which takes JSON as input. Example: { "text": "Hello Im first!", "date": "2023 Aug 20:48", "user_id": 2 }
- `/message/update` - `@PutMapping`, accepts 2 parameters as input:
    - `String text` - new message text.
    - `Long id` - The id of the message you want to update.
- `/message/delete/{id}` - `@DeleteMapping` deletes the message by `id` passed with `@PathVariable`.

---

I hope this information will help you get started using our chat forum server. If you have any questions or comments, please contact us. Thank you for your interest in my project!


