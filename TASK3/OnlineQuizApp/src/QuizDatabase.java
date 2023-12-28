import java.util.ArrayList;
import java.util.List;

public class QuizDatabase {
    private List<QuizQuestion> questions;

    public QuizDatabase() {
        questions = new ArrayList<>();

        // Programming Language
        questions.add(new QuizQuestion("What does JVM stand for?", new String[]{"Java Virtual Machine", "Java Visual Machine", "Just Virtual Machine", "JavaScript Virtual Machine"}, 0, "JVM stands for Java Virtual Machine."));
        questions.add(new QuizQuestion("Which programming language is known for its simplicity and readability?", new String[]{"Java", "Python", "C++", "Ruby"}, 1, "Python is known for its simplicity and readability."));
        questions.add(new QuizQuestion("What is the main purpose of a constructor in Java?", new String[]{"To initialize the object", "To create an object", "To define methods", "To destroy the object"}, 0, "The main purpose of a constructor is to initialize the object."));

        // Cloud Computing
        questions.add(new QuizQuestion("What does IaaS stand for in Cloud Computing?", new String[]{"Internet as a Service", "Infrastructure as a Service", "Integration as a Service", "Instance as a Service"}, 1, "IaaS stands for Infrastructure as a Service."));
        questions.add(new QuizQuestion("What is the purpose of load balancing in cloud computing?", new String[]{"To increase server downtime", "To evenly distribute network traffic", "To reduce the number of servers", "To improve data security"}, 1, "Load balancing is used to evenly distribute network traffic across multiple servers."));

        // Operating System
        questions.add(new QuizQuestion("What is the function of the kernel in an operating system?", new String[]{"Manage hardware resources", "Run application software", "Control network connections", "Handle file storage"}, 0, "The kernel manages hardware resources in an operating system."));
        questions.add(new QuizQuestion("What is the purpose of virtual memory?", new String[]{"Increase RAM size", "Run virtual machines", "Store temporary files", "Manage user accounts"}, 0, "Virtual memory is used to increase the effective size of RAM."));

        // Computer Network
        questions.add(new QuizQuestion("What does DNS stand for?", new String[]{"Domain Name System", "Dynamic Network Service", "Data Network Security", "Digital Naming System"}, 0, "DNS stands for Domain Name System."));
        questions.add(new QuizQuestion("Which protocol is used for secure communication over a computer network?", new String[]{"HTTP", "FTP", "TCP/IP", "HTTPS"}, 3, "HTTPS (Hypertext Transfer Protocol Secure) is used for secure communication."));

        // Computer Graphics
        questions.add(new QuizQuestion("What is the process of creating the illusion of motion called in computer graphics?", new String[]{"Rasterization", "Animation", "Rendering", "Simulation"}, 1, "Animation is the process of creating the illusion of motion."));
        questions.add(new QuizQuestion("Which algorithm is used for anti-aliasing in computer graphics?", new String[]{"Bresenham's Line Algorithm", "Cohen-Sutherland Algorithm", "Xiaolin Wu's Line Algorithm", "Dithering"}, 2, "Xiaolin Wu's Line Algorithm is used for anti-aliasing."));

        // Database Management System
        questions.add(new QuizQuestion("What is the primary key in a database?", new String[]{"A key used for encryption", "A unique identifier for a record", "A key used for sorting records", "A foreign key"}, 1, "The primary key is a unique identifier for a record."));
        questions.add(new QuizQuestion("What is the purpose of SQL?", new String[]{"To create web pages", "To manage and manipulate databases", "To design user interfaces", "To write operating system commands"}, 1, "SQL is used to manage and manipulate databases."));

        // English
        questions.add(new QuizQuestion("What is a synonym for 'Benevolent'?", new String[]{"Malevolent", "Kind-hearted", "Cruel", "Malicious"}, 1, "'Kind-hearted' is a synonym for 'Benevolent'."));
        questions.add(new QuizQuestion("Identify the antonym for 'Conceal'", new String[]{"Reveal", "Hide", "Cover", "Mask"}, 0, "'Reveal' is the antonym for 'Conceal'."));

        // History
        questions.add(new QuizQuestion("Who was the first President of the United States?", new String[]{"Thomas Jefferson", "George Washington", "Abraham Lincoln", "John Adams"}, 1, "George Washington was the first President of the United States."));
        questions.add(new QuizQuestion("In which year did World War II end?", new String[]{"1945", "1939", "1941", "1942"}, 0, "World War II ended in 1945."));

        // Geography
        questions.add(new QuizQuestion("Which river is the longest in the world?", new String[]{"Amazon River", "Nile River", "Yangtze River", "Mississippi River"}, 1, "The Nile River is the longest river in the world."));
        questions.add(new QuizQuestion("What is the capital of Australia?", new String[]{"Sydney", "Canberra", "Melbourne", "Brisbane"}, 1, "Canberra is the capital of Australia."));

        // Science and Technology
        questions.add(new QuizQuestion("Who is known as the 'Father of Computer Science'?", new String[]{"Alan Turing", "Charles Babbage", "Ada Lovelace", "John von Neumann"}, 0, "Alan Turing is known as the 'Father of Computer Science'."));
        questions.add(new QuizQuestion("What does HTML stand for in web development?", new String[]{"Hypertext Markup Language", "Hyperlink and Text Markup Language", "High-Level Text Markup Language", "Home Tool Markup Language"}, 0, "HTML stands for Hypertext Markup Language."));

        // Economics
        questions.add(new QuizQuestion("What is inflation?", new String[]{"A decrease in the general price level of goods and services", "A steady increase in the general price level of goods and services", "A measure of economic output", "A trade deficit"}, 1, "Inflation is a steady increase in the general price level of goods and services."));
        questions.add(new QuizQuestion("What is GDP?", new String[]{"Gross Domestic Product", "General Domestic Price", "Global Development Plan", "Gross Disposable Profit"}, 0, "GDP stands for Gross Domestic Product."));

        // Logical and Analytical Reasoning
        questions.add(new QuizQuestion("If all cats can fly, and Fluffy is a cat, can Fluffy fly?", new String[]{"Yes", "No", "Not enough information", "It depends on Fluffy's mood"}, 1, "Not all cats can fly, so Fluffy cannot fly."));
        questions.add(new QuizQuestion("What comes next in the sequence: 2, 4, 8, 16, ___", new String[]{"32", "24", "64", "128"}, 0, "The sequence is doubling, so the next number is 32."));

        // Quantitative Aptitude
        questions.add(new QuizQuestion("Simplify: 3 + (5 * 2) - 4", new String[]{"11", "15", "13", "9"}, 3, "The correct answer is 9."));
        questions.add(new QuizQuestion("What is the square root of 144?", new String[]{"12", "14", "10", "16"}, 0, "The square root of 144 is 12."));
        // ... Add more questions for other topics

    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }
}
