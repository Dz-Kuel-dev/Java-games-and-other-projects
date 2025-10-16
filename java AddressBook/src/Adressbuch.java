
public class Adressbuch {


    public static void main(String[] args){

      Addressdata address1 = new Addressdata("Manuel", "Karlson", "0-122-222-222", "die.email@adresse.com");
      Addressdata address2 = new Addressdata("Peter", "Schmidt", "0-132-322-222", "snob.email@adresse.com");
      Addressdata address3 = new Addressdata("Dennis", "Wagner", "0-143-222-222", "b43.email@adresse.com");

      
      String saveAll = address1.print_all();
    
      System.out.println(saveAll);

             saveAll = address2.print_all();

      System.out.println(saveAll);

             saveAll = address3.print_all();

      System.out.println(saveAll);
      


      address1.setFname("Jay");
      address2.setLname("Stachelhaus");
      address3.setTel("0-444-222-222");
      address1.setEmail("iwas.email@adress.com");


      System.out.println(address1.getFname());
      System.out.println(address2.getLname());
      System.out.println(address3.getTel());
      System.out.println(address1.getEmail());
      


    }







}