import pika
import json
import time

print("Pocetak izvrsavanja skripte...")
class Position:
    def __init__(self, lat, lng):
        self.lat = lat
        self.lng = lng

    def to_json(self):
        return json.dumps(self, default=lambda o: o.__dict__,
                          sort_keys=True, indent=4)

coordinates = []
c1 = Position(45.245581, 19.879947)
coordinates.append(c1)
c2 = Position(45.228618, 19.895053)
coordinates.append(c2)
c3 = Position(45.211076, 19.919550)
coordinates.append(c3)
c4 = Position(45.193527, 19.950988)
coordinates.append(c4)
c5 = Position(45.163308, 19.957112)
coordinates.append(c5)
c6 = Position(45.138546, 19.986100)
coordinates.append(c6)
c7 = Position(45.110315, 20.02611)
coordinates.append(c7)
c8 = Position(45.077169, 20.050609)
coordinates.append(c8)
c9 = Position(45.040183, 20.089130)
coordinates.append(c9)
c10 = Position(45.014789, 20.121175)
coordinates.append(c10)
c11 = Position(44.979082, 20.163416)
coordinates.append(c11)
c12 = Position(44.959502, 20.194976)
coordinates.append(c12)
c13 = Position(44.938884, 20.227506)
coordinates.append(c13)
c14 = Position(44.924791, 20.246928)
coordinates.append(c14)
c15 = Position(44.901754, 20.284314)
coordinates.append(c15)
c16 = Position(44.883180, 20.323156)
coordinates.append(c16)
c17 = Position(44.866664, 20.361999)
coordinates.append(c17)
c18 = Position(44.840850, 20.366369)
coordinates.append(c18)
c19 = Position(44.828454, 20.385790)
coordinates.append(c19)
c20 = Position(44.816401, 20.411523)
coordinates.append(c20)

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
    time.sleep(10)


connection.close()