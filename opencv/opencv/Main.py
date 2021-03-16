import cv2
import numpy
import face_recognition
import os

from numpy.distutils.tests.test_exec_command import redirect_stderr

path = 'Images'
images = []
classNames = []
myList = os.listdir(path)
print(myList)

for cls in myList:
    curImage = cv2.imread(f'{path}/{cls}')
    images.append(curImage)
    classNames.append(os.path.splitext(cls)[0])

print(classNames)


def findEncodings(images):
    encodeList = []
    for img in images:
        img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
        encodedImage = face_recognition.face_encodings(img)[0]
        encodeList.append(encodedImage)
    return encodeList


encodeListKnownFaces = findEncodings(images)
print(len(encodeListKnownFaces))

imageObama = face_recognition.load_image_file('ImageBasic/Obama.jpg')
imageObama = cv2.cvtColor(imageObama, cv2.COLOR_BGR2RGB)

faceLoc = face_recognition.face_locations(imageObama)[0]
encodedObama = face_recognition.face_encodings(imageObama)[0]

results = face_recognition.compare_faces([encodeListKnownFaces], encodedObama)
faceDist = face_recognition.face_distance([encodeListKnownFaces], encodedObama)
i = 0
for enc in encodeListKnownFaces:
    res = face_recognition.compare_faces([enc], encodedObama)
    #print(res)
    if res[0]:
        print(classNames[i])
    i = i + 1

#print(results)
#print(faceDist)

#match = numpy.argmin(faceDist)
#print(match)
#if results[match]:
#    print(classNames[match])

