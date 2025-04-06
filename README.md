# 🔒 Secure File Hiding System with OTP Verification (Java + MySQL)

A Java-based desktop application that allows users to securely **hide**, **unhide**, and **view hidden files** with **OTP-based verification**, leveraging the JavaMail API, MySQL database, and Maven build tool.

---

## 📌 Features

- ✅ User **Sign Up / Login** with OTP verification via email
- 🔐 **Hide files** securely by encrypting and storing them in the database
- 📂 **Unhide files** and restore them to their original location
- 📬 Email OTPs using **JavaMail API** and Gmail App Password
- 🗃️ Uses **MySQL** for persistent file and user management
- ⚙️ Built with **Maven** for dependency management and portability

---

## 🛠️ Tech Stack

| Layer         | Tech Used             |
|---------------|------------------------|
| Language      | Java                   |
| Database      | MySQL                  |
| Email Service | JavaMail API (SMTP)    |
| Build Tool    | Maven                  |
| IDE           | IntelliJ IDEA          |

---

## 🔧 Setup Instructions

### 1. Clone the Repo

```bash
git clone https://github.com/yourusername/secure-file-hider.git
cd secure-file-hider
2. MySQL Configuration
Create a MySQL database:

sql
Copy
Edit
CREATE DATABASE securefiledb;
USE securefiledb;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    path VARCHAR(500),
    email VARCHAR(100),
    bin_data LONGTEXT
);
Update DB credentials in MyConnection.java:

java
Copy
Edit
String url = "jdbc:mysql://localhost:3306/securefiledb";
String user = "root";
String password = "your_mysql_password";
3. Configure Gmail App Password
Enable 2-Step Verification on your Gmail account

Generate an App Password for "Mail"

Use that App Password in SendOTPService.java:

java
Copy
Edit
return new PasswordAuthentication(from, "your_app_password");
4. Run the App
bash
Copy
Edit
mvn clean compile
Then run the Main.java file using your IDE (IntelliJ recommended)

💻 Application Flow
🔐 Sign up / Login

📧 OTP sent to email via JavaMail

🧾 Enter OTP to authenticate

📁 Choose to:

Show hidden files

Hide a file

Unhide a file

📸 Screenshots
(Optional — Add screenshots or terminal outputs to show working UI)

📬 Contact
Author: Shivam Prasad
📧 prasadshivam818@gmail.com

📝 License
This project is open-source and free to use under the MIT License.

yaml
Copy
Edit

---

Would you also like me to generate a proper `pom.xml` file for Maven with dependencies (JavaMail, MySQL, et
