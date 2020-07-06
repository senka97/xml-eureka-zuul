import pika
import json
import time

print("Pocetak izvrsavanja skripte...")


class MapData:
    def __init__(self, lat, lng, token):
        self.lat = lat
        self.lng = lng
        self.token = token

    def to_json(self):
        return json.dumps(self, default=lambda o: o.__dict__,
                          sort_keys=True, indent=4)


coordinates = []
c1 = MapData(45.245581, 19.879947, 'abcd123456789')
coordinates.append(c1)
c2 = MapData(45.251540, 19.882901, '123456789abcd')
coordinates.append(c2)
c3 = MapData(45.228618, 19.895053, 'abcd123456789')
coordinates.append(c3)
c4 = MapData(45.219578, 19.865373, '123456789abcd')
coordinates.append(c4)
c5 = MapData(45.211076, 19.919550, 'abcd123456789')
coordinates.append(c5)
c6 = MapData(45.193454, 19.842027, '123456789abcd')
coordinates.append(c6)
c7 = MapData(45.193527, 19.950988, 'abcd123456789')
coordinates.append(c7)
c8 = MapData(45.168287, 19.826921, '123456789abcd')
coordinates.append(c8)
c9 = MapData(45.163308, 19.957112, 'abcd123456789')
coordinates.append(c9)
c10 = MapData(45.136327, 19.839280, '123456789abcd')
coordinates.append(c10)
c11 = MapData(45.138546, 19.986100, 'abcd123456789')
coordinates.append(c11)
c12 = MapData(45.086899, 19.857133, '123456789abcd')
coordinates.append(c12)
c13 = MapData(45.110315, 20.02611, 'abcd123456789')
coordinates.append(c13)
c14 = MapData(45.067504, 19.851640, '123456789abcd')
coordinates.append(c14)
c15 = MapData(45.077169, 20.050609, 'abcd123456789')
coordinates.append(c15)
c16 = MapData(45.041310, 19.837907, '123456789abcd')
coordinates.append(c16)
c17 = MapData(45.040183, 20.089130, 'abcd123456789')
coordinates.append(c17)
c18 = MapData(45.008308, 19.848893, '123456789abcd')
coordinates.append(c18)
c19 = MapData(45.014789, 20.121175, 'abcd123456789')
coordinates.append(c19)
c20 = MapData(44.983059, 19.817307, '123456789abcd')
coordinates.append(c20)
c21 = MapData(44.979082, 20.163416, 'abcd123456789')
coordinates.append(c21)
c22 = MapData(44.955855, 19.804948, '123456789abcd')
coordinates.append(c22)
c23 = MapData(44.959502, 20.194976, 'abcd123456789')
coordinates.append(c23)
c24 = MapData(44.934471, 19.785722, '123456789abcd')
coordinates.append(c24)
c25 = MapData(44.938884, 20.227506, 'abcd123456789')
coordinates.append(c25)
c26 = MapData(44.900435, 19.763749, '123456789abcd')
coordinates.append(c26)
c27 = MapData(44.924791, 20.246928, 'abcd123456789')
coordinates.append(c27)
c28 = MapData(44.863458, 19.773362, '123456789abcd')
coordinates.append(c28)
c29 = MapData(44.901754, 20.284314, 'abcd123456789')
coordinates.append(c29)
c30 = MapData(44.842040, 19.767869, '123456789abcd')
coordinates.append(c30)
c31 = MapData(44.883180, 20.323156, 'abcd123456789')
coordinates.append(c31)
c32 = MapData(44.808923, 19.755509, '123456789abcd')
coordinates.append(c32)
c33 = MapData(44.866664, 20.361999, 'abcd123456789')
coordinates.append(c33)
c34 = MapData(44.793333, 19.723924, '123456789abcd')
coordinates.append(c34)
c35 = MapData(44.840850, 20.366369, 'abcd123456789')
coordinates.append(c35)
c36 = MapData(44.772863, 19.728044, '123456789abcd')
coordinates.append(c36)
c37 = MapData(44.828454, 20.385790, 'abcd123456789')
coordinates.append(c37)
c38 = MapData(44.750436, 19.721177, '123456789abcd')
coordinates.append(c38)
c39 = MapData(44.816401, 20.411523, 'abcd123456789')
coordinates.append(c39)
c40 = MapData(44.719219, 19.737657, '123456789abcd')
coordinates.append(c40)

print(len(coordinates))

# ako se skripta pokrece u kontejneru onda za host ide rabbitmq-broker
connection = pika.BlockingConnection(
    pika.ConnectionParameters(host='localhost', port=5672))
channel = connection.channel()
channel.queue_declare(queue='location-queue', durable=True)

i = 0
while True:
    if i == len(coordinates):
        i = 0
    channel.basic_publish(exchange='', routing_key='location-queue', body=coordinates[i].to_json())
    print("Poslalo se: " + coordinates[i].to_json())
    i = i + 1
    time.sleep(5)

connection.close()
