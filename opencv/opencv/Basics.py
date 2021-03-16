import cv2
import numpy
import face_recognition

imageObama = face_recognition.load_image_file('ImageBasic/Obama.jpg')
imageObama = cv2.cvtColor(imageObama, cv2.COLOR_BGR2RGB)

imageObama2 = face_recognition.load_image_file('ImageBasic/Obama2.jpg')
imageObama2 = cv2.cvtColor(imageObama2, cv2.COLOR_BGR2RGB)

faceLoc = face_recognition.face_locations(imageObama)[0]
encodedObama = face_recognition.face_encodings(imageObama)[0]

faceLoc2 = face_recognition.face_locations(imageObama2)[0]
encodedObama2 = face_recognition.face_encodings(imageObama2)[0]

print(faceLoc)
#cv2.rectangle(imageObama,(faceLoc[3],faceLoc[0]), (faceLoc[1],faceLoc[2]),(255,0,255))

results = face_recognition.compare_faces([encodedObama], encodedObama2)
faceDist = face_recognition.face_distance([encodedObama],encodedObama2)
print(results)
print(faceDist)
print(encodedObama)

print("wow")

#cv2.imshow("img",imageObama)
#cv2.imshow("img2",imageObama2)
cv2.waitKey(0)