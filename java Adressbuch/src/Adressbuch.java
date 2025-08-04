//2. Adressbuch

//Entwickeln Sie ein Adressbuch-Programm, das Kontakte speichern und verwalten kann. Erstellen Sie eine Contact-Klasse mit Attributen wie Name, Telefonnummer und E-Mail-Adresse.

public class Adressbuch {




    public static void main(String[] args){

      Adressdaten obAdresse1 = new Adressdaten("Deniz", "Kül", "0-122-222-222", "die.email@adresse.com");
      Adressdaten obAdresse2 = new Adressdaten("Peter", "Smits", "0-132-322-222", "snob.email@adresse.com");
      Adressdaten obAdresse3 = new Adressdaten("Dennis", "Brammen", "0-143-222-222", "b43.email@adresse.com");

      
      String saveAll = obAdresse1.print_all();
    
      System.out.println(saveAll);

             saveAll = obAdresse2.print_all();

      System.out.println(saveAll);

             saveAll = obAdresse3.print_all();

      System.out.println(saveAll);
      


      obAdresse1.setFname("Jay");
      obAdresse2.setLname("Stachelhaus");
      obAdresse3.setTel("0-444-222-222");
      obAdresse1.setEmail("iwas.email@adresse.com");


      System.out.println(obAdresse1.getFname());
      System.out.println(obAdresse2.getLname());
      System.out.println(obAdresse3.getTel());
      System.out.println(obAdresse1.getEmail());
      


    }







}