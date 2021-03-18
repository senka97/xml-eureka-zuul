

# Opis: 

Predmetni projekat iz predmeta "XML i veb servisi".

Rent-a-Car sistem se sastoji od:

 - **glavne aplikacije** 
     koja ima **frontend** (za klijente, agente i administratore) i **backend** koji je mikroservisne arhitekture 
 - **agentske aplikacije** koja ima **frontend** (samo jedan agent) i **backed** koji predstavlja monolitnu aplikaciju 

Agentska aplikacija sa glavnom aplikacijom komunicira preko SOAP poruka. 

 Glavna aplikacija:
  - Frontend: 
  https://github.com/senka97/xml-front
  
   Mikroservisi:

  - User microservice:
  https://github.com/senka97/xml-user-microservice
  
  - Car microservice:
  https://github.com/senka97/xml-car-microservice
  
  - Ad microservice:
  https://github.com/senka97/xml-ad-microservice
  
  - Rent microservice
  https://github.com/senka97/xml-rent-microservice
  
 Agentska aplikacija: 
  - Frontend:
  https://github.com/senka97/xml-agent-front
  
  - Backend:
  https://github.com/senka97/xml-agent-back
  
 # Upustvo za pokretanje:
  - Da bi se pokrenule glavna i agentska aplikacija neophodno je:
     - klonirati ovaj repozitorijum 
     - pozicionirati se u njega i komandom **docker-compose up** pokrenuti sve mikroservise 
     - Glavnoj aplikaciji pristupiti na: http://localhost:8080 
     - Agentskoj aplikaciji na http://localhost:8086
