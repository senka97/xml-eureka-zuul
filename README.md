# xml-eureka-zuul

 Main application:
  - Frontend: 
  https://github.com/senka97/xml-front

  - User microservice:
  https://github.com/senka97/xml-user-microservice
  
  - Car microservice:
  https://github.com/senka97/xml-car-microservice
  
 Agent application: 
  - Frontend:
  https://github.com/senka97/xml-agent-front
  
  - Backend:
  https://github.com/senka97/xml-agent-back

 # Model aplikacije
![Model aplikacije](https://i.imgur.com/y5XCuse.png)

**Mikroservisi:**

1. **User service (autentifikacija i funkcionalnosti admina)**
	
	- Klase:
		- Agent 
		- Klijent
		- Admin
		- User
		- Role
		- Permisije

	- Funkcionalnosti:
		- Registrovanje korisnika
		- Registrovanje agenata
		- Odobravanje registracije
		- Logovanje
		- Banovanje korisnika
		- Izmena podataka korsinika

2. **Search i oglasi:**
	
	- Klase:
	    - Oglasi
		- Cenovnik
		
	- Funkcionalnosti:
		- Dodavanje oglasa
		- Osnovna pretraga
		- Vracanje svih oglasa
		- Vracanje informacija o jednom oglasu
		- Definisanje cenovnika

3. **Narucivanje**
	
	- Klase:
		- Zahteve
		- Bundle
		- Cart item
		- Korpa
		- Poruka
		- Rezervacije

	- Funkcionalnosti:
		- Pravljenje zahteva
		- Promena statusa zahteva
		- Slanje poruka
		- Dodavanje u korpu
		- Brisanje iz korpe
		- Fizicko rentiranje

4. **Sifranik (Car service)**
	
	- Klasa:
		- Model
		- Marka
		- Klasa Automobila
		- Tip Menjaca
		- Vrsta Goriva
		- Slika
		- Izvestaj
		- Automobil
		- Komentar

	- Funkcionalnosti:
		- Manipulacija sifrarnikom(Dodavanje/brisanje)
		- Dodavanje komentara
		- Odobravanje/odbijanje komentara
		- Dodavanje automobila
		- Unos izvestaja
		- Dobavljanje statistike

5. **Email service**
