import base64
import io
import os
import cv2
import face_recognition
from PIL import Image
from flask import *
import random
from pathlib import Path

def getEncoded():
    imgFile = face_recognition.load_image_file('ImageBasic/Obama.jpg')
    imgFile = cv2.cvtColor(imgFile, cv2.COLOR_BGR2RGB)
    encodedImage = face_recognition.face_encodings(imgFile)[0]
    return json.dumps(encodedImage.tolist())


def addImage(encoded, name):
    imageData = base64.b64decode(str(encoded), ' /')
    img = Image.open(io.BytesIO(imageData))
    imagePath = 'Data/' + name
    if not Path(imagePath).exists():
        os.mkdir(imagePath)

    img.save(imagePath+"/"+str(random.random()) + ".jpeg", 'jpeg')
    #imgFile = face_recognition.load_image_file(imagePath)
    #imgFile = cv2.cvtColor(imgFile, cv2.COLOR_BGR2RGB)
    #encodedImage = face_recognition.face_encodings(imgFile)[0]
    #os.remove(imagePath)
    #return json.dumps(encodedImage.tolist())
    return str(Path(imagePath).exists())


def getMatch(encoded):
    print("decoding image!!!")
    #print("decoding!!!!",base64.b64decode(str(encoded), ' /'))
    imageData = base64.b64decode(str(encoded), ' /')
    print("Byte image!!!")
    img = Image.open(io.BytesIO(imageData))
    imagePath = 'temp/' + str(random.random()) + ".jpeg"
    img.save(imagePath, 'jpeg')
    print("image saved in temp!!!")
    imgFile = face_recognition.load_image_file(imagePath)
    print("image read from temp!!!")
    #imgFile = cv2.cvtColor(imgFile, cv2.COLOR_BGR2RGB)
    encodedImage = face_recognition.face_encodings(imgFile)[0]
    print("image encoded for comparing!!!")
    os.remove(imagePath)

    imagesData = getImages()
    imagesList = getImagesNames()

    encodeListKnownFaces = findEncodings(imagesData)

    i = 0
    for enc in encodeListKnownFaces:
        print("Comparing encodings of faces to get match")
        res = face_recognition.compare_faces([enc], encodedImage)
        # print(res)
        if res[0]:
            name = imagesList[i];
            print("the image found in ", name)
            return name
        else:
            name = "no match found"
            print("no match found")
        i = i + 1
    return name


# https://stackoverflow.com/questions/53548127/post-numpy-array-with-json-to-flask-app-with-requests
# getEncoded()

def findEncodings(images):
    encodeList = []
    for img in images:
        img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
        encodedImage = face_recognition.face_encodings(img)[0]
        encodeList.append(encodedImage)
    return encodeList

def getImagesNames():
    path = 'Data'
    images = []
    myList = os.listdir(path)

    for cls in myList:
        if Path(f'{path}/{cls}').is_dir():
            imageList = os.listdir(f'{path}/{cls}')
            for imgCont in imageList:
                if imgCont[-4:] == 'jpeg':
                    images.append(f'{cls}')
    return images

def getImages():
    path = 'Data'
    images = []
    myList = os.listdir(path)

    for cls in myList:
        if Path(f'{path}/{cls}').is_dir():
            imageList = os.listdir(f'{path}/{cls}')
            for imgCont in imageList:
                if imgCont[-4:] == 'jpeg':
                    curImage = cv2.imread(f'{path}/{cls}/{imgCont}')
                    images.append(curImage)
    return images

def inv():
    return "hi"
