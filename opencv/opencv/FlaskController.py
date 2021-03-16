from flask import *
import Controller
import logging

log = logging.getLogger('werkzeug')
log.setLevel(logging.ERROR)


app = Flask(__name__)


@app.route('/')
def home():
    return "hello, welcome to face recognition software"


@app.route('/test', methods=['GET'])
def test():
    search = request.args.get("search")
    print(search)
    return Controller.inv()


@app.route('/encode', methods=['GET'])
def encode():
    return Controller.getEncoded()


@app.route('/addImage', methods=['PUT'])
def addImage():
    encoded = request.args.get("encoded")
    name = request.args.get("name")
    return Controller.addImage(encoded,name)

@app.route('/getMatch', methods=['PUT'])
def getMatch():
    print("getting match!!!")
    encoded = request.args.get("encoded")
    return Controller.getMatch(encoded)

if __name__ == '__main__':
    app.logger.disabled = True
    app.run(debug=False)

