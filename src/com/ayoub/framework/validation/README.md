# Ayoub Validation Framework v0.1

A lightweight, annotation-driven validation framework for Java. This project provides a simple yet powerful engine to validate object fields at runtime using custom annotations, inspired by modern frameworks like Jakarta Bean Validation and Spring.

---

### Core Features in v0.1

*   **Annotation-Driven**: Declare validation rules directly on your model fields.
*   **Simple Core Annotations**:
    *   `@NotNull`: Ensures a field's value is not `null`.
    *   `@Range(min, max)`: Checks if a numeric field's value falls within a specified range.
    *   `@Email`: Validates that a String field has a valid email format.
*   **Dynamic Validator Engine**: A `Validator` class that uses reflection to discover and process validation annotations.
*   **Colored Console Output**: Get clear and immediate feedback with color-coded success (`✅`) and error (`❌`) messages in your console.

---

### Getting Started

Follow these simple steps to integrate and use the validation framework in your project.

#### Step 1: Annotate Your Model Class

Add validation annotations to the fields of your Plain Old Java Object (POJO).

**Example:** `User.java`

```java
package com.ayoub.framework.validation.demo;

import com.ayoub.framework.validation.core.Email;
import com.ayoub.framework.validation.core.NotNull;
import com.ayoub.framework.validation.core.Range;

public class User {

    @NotNull(message = "Username cannot be null or empty")
    private String username;

    @Email(message = "Please provide a valid email address")
    private String email;

    @Range(min = 18, max = 100, message = "User must be between 18 and 100 years old")
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}
```

#### Step 2: Run the Validator

Use the static `Validator.validate()` method to check an object instance. The method returns a list of validation errors.

**Example:** `Main.java`

```java
import com.ayoub.framework.validation.core.Validator;
import com.ayoub.framework.validation.demo.User;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // Create a valid user
        User user1 = new User("ayoub", "ayoub@example.com", 25);
        System.out.println("Validating user1...");
        List<Validator.ValidationError> errors1 = Validator.validate(user1);
        Validator.printErrors(errors1);

        System.out.println("\n-----------------------------------\n");

        // Create an invalid user to see the errors
        User user2 = new User(null, "invalid-email", 200);
        System.out.println("Validating user2...");
        List<Validator.ValidationError> errors2 = Validator.validate(user2);
        Validator.printErrors(errors2);
    }
}
```

#### Step 3: See the Output

Running the `Main` class will produce the following output:

```shell
Validating user1...
✅ All validations passed!

-----------------------------------

Validating user2...
❌ Validation failed with 3 error(s):
  - username: Username cannot be null or empty
  - email: Please provide a valid email address
  - age: User must be between 18 and 100 years old```

### Next Steps

The next major phase for this project is the development of a lightweight **Inversion of Control (IoC) Container**, which will manage object lifecycles and dependencies, similar to the Spring Framework's Core container.