
import People.*;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Human olgaKartaeva = new Human("Olga", "Serduk", LocalDate.of(1965, 3, 13), Gender.Female);
        Human sergeyKartaev = new Human("Sergey", "Kartaev", LocalDate.of(1964, 6, 15), Gender.Male);

        Human nikolayKartaev = new Human("Nikolay", "Kartaev", LocalDate.of(1987, 1, 3), olgaKartaeva, sergeyKartaev,
                Gender.Male);
        Human anastasiaKartaeva = new Human("Anastasia", "Kartaeva", LocalDate.of(1986, 8, 26), Gender.Female);
        Human platonKartaev = new Human("Platon", "Kartaev", LocalDate.of(2022, 1, 30), Gender.Male);
        Human ivanKartaev = new Human("Ivan", "Kartaev", LocalDate.of(1990, 12, 14), Gender.Male);
        Human vladMakarov = new Human("Vlad", "Makarov", LocalDate.of(2004, 06, 13), Gender.Male);

        nikolayKartaev.addChildF(platonKartaev);
        anastasiaKartaeva.addChildM(platonKartaev);

        olgaKartaeva.addChildM(nikolayKartaev);
        sergeyKartaev.addChildF(nikolayKartaev);

        olgaKartaeva.addChildM(ivanKartaev);
        sergeyKartaev.addChildF(ivanKartaev);

        anastasiaKartaeva.addChildM(vladMakarov);


        service.addHuman("Ivan", "Kartaev", LocalDate.of(1990, 12, 14), olgaKartaeva, sergeyKartaev,
                Gender.Male);
        service.addHuman("Platon", "Kartaev", LocalDate.of(2022, 1, 30), anastasiaKartaeva, nikolayKartaev,
                Gender.Male);
        service.addHuman("Nikolay", "Kartaev", LocalDate.of(1987, 1, 3), olgaKartaeva, sergeyKartaev,
                Gender.Male);


        System.out.println(service.getInformation());

        service.sortByAge();
        System.out.println(service.getInformation());

        service.sortByBirthdate();
        System.out.println(service.getInformation());


    }
}