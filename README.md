# Book Store Api

Example Api for a simple Book Store.
----
### How to Run 
1. You need to set up your the following mysql properties to establish MySQL conneection. BD Name: bookstore

          spring.datasource.url=your_mysql_instance

          spring.datasource.username=your_username

          spring.datasource.password=your_password

2. From here you can run it using the command line or use the import project from option of your prefered IDE.

3. For command line you need to issue.

        maven package or mvn install // for build the project
        
        java -jar .\target\restapi-0.0.1-SNAPSHOT.jar //This will deploy the project
        
4. Now you will be able to hit the api from http://localhost:8080/api/books 

### API Structure 

There are three resources exposed:

   a) http://localhost:8080/api/books with GET Method.
    This returns all the books
    
         [
            {
                "id": 10,
                "title": "George .",
                "author": "Daniel Jones",
                "publisher": "Pingu",
                "publicationYear": 1949
            },
            {
                "id": 11,
                "title": "George Ore",
                "author": "Daniel Jones",
                "publisher": "Pingu",
                "publicationYear": 1949
            }
         ]
      
   b) http://localhost:8080/api/books with POST Method.
    For adding a new book with following body request
    
        {
          "id": 11,
          "title": "George Ore",
          "author": "Daniel Jones",
          "publisher": "Pingu",
          "publicationYear": 1949
        }
        
   c) http://localhost:8080/api/books/getEvenBooks with GET Method. 
    Retun a list of books whose sum of vowels in the title is equal to an even number. 
    Returned data should be sorted on publication year ascending 
    
        [
            {
                "vowels": 4,
                "publicationYear": 1949,
                "title": "Modern Love"
            },
            {
                "vowels": 4,
                "publicationYear": 2019,
                "title": "Antifragil"
            }
        ]
     
### Candidate Approch 

  I rely on spring framework annotations for autowired and connect all the application.
  
  For api/books/getEvenBooks.
  
  I choosed to use the stack to handle the sun of vowels, that means I created two methods one that inspects string to look for vowels and the second one to handle the sum.
  I call recursively countVowels method.

