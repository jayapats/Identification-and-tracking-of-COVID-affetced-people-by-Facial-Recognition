# Identification-and-tracking-of-COVID-affetced-people-by-Facial-Recognition

Abstract:
During the current situation of COVID situation all over the world, it is very risky to attend the in-person classes at the University. For enabling a safer premise on campus, I am working on developing a software which tracks the COVID affected people and monitors their timeline, like records their movement wherever they go inside the campus. Initially the affected person’s details would be stored in the database from various sources such as Student Health Centre at our university or other testing sites near by the campus. Images captured from various servers located around the campus would be sent to the Back end webservice via the Spring Boot application which acts as the middleware. The Back-end application handles the image detection and recognition using OpenCV and Python libraries.
As part of this project, the Back-end application is developed using Python and Flask API. The python code handles saving of encoded images into a storage location by converting the encoding to image format. It gets the face match for an existing request and outputs the name of the person by detecting the face locations in an image and comparing it with the other images in the database. This back-end is handled via a Spring Boot application developed using Java, Hibernate, Maven Framework and MySQL database.

Tools/Tech:
Python, Flask API, Spring Boot, Java, Hibernate,Rest API, OpenCV, MySQL



