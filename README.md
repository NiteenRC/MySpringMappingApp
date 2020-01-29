## MySpringMappingApp ##
========================

#One to One mapping
GET http://localhost:8080/one2one/users

#Many to Many mapping
GET http://localhost:8080/many2many/courses
GET http://localhost:8080/many2many/students

#One to Many mapping
GET http://localhost:8080/one2many/books



#Spring data JPA#
-----------------
#findByFeeLessThan
GET http://localhost:8080/many2many/courses/900

#findByTitleContainingIgnoringCase
POST http://localhost:8080/many2many/courses/title?title=machine

#deleteById(in-built)
DELETE http://localhost:8080/many2many/courses/1

#findByAnnotatedQuery
POST http://localhost:8080/many2many/courses/abbreviation/modules?abbreviation=ML&modules=12

#pass collections of abbreviation and modules
POST http://localhost:8080/many2many/courses/abbreviation?abbreviation=ML&modules=2&abbreviation=DS