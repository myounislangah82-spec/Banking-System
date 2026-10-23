import java.util.ArrayList;
import java.util.Scanner;




class Mybank{



public  static class action{

        protected   Double balance = 0.0;
     
  }
  public static class user extends action{
            
          private  String name;
          private  long Pin;
          private  static  long id = 0;
          private  String CNIC;


          Scanner sc = new Scanner(System.in);

          user(){ id++;}

          public void getter(){
          
           System.out.println("Enter the user Name: ");
            name = sc.nextLine();

           System.out.println("Enter the CNIC number: ");
           CNIC = sc.nextLine(); 

           System.out.println("Enter the Pin: ");
           Pin = sc.nextInt();

          

        
          
          }

         
  }


      public static ArrayList<user> ADD(ArrayList<user> custom){
                   
            user us_1 = new user();
            us_1.getter();

            System.out.println("\n"+"\n");
            custom.add(us_1); 
            return  custom;
      }


      public static void Delete(ArrayList<user> custom){

            Scanner st = new Scanner(System.in);
            
            

            System.out.println("Enter the following credential of the account you want to delete.");
            

              System.out.println("Enter the username:");
              String username = st.nextLine();


              System.out.println("Enter the pin: ");
              int pin = st.nextInt();

              
              

              for(int i = 0; i <custom.size(); i++){
                     
                      if(custom.get(i).Pin == pin && custom.get(i).name.equalsIgnoreCase(username)){                 
                        custom.remove(i);
                           System.out.println("The account has been deleted succefully."); 
                      }
            
              
                     }


               
      }

       public static void check_balance(user USER){ 
                    
                  
                  Scanner su = new Scanner(System.in);
                  int attempts = 0;

                  do{

                  attempts++;
                  System.out.println("Enter Pin first: ");
                  int pin = su.nextInt();

                  if(USER.Pin == pin){
                  System.out.println("$ "+USER.balance);
                   return;
                  }else{
                    if(attempts < 3){
                        System.out.println("Enter the valid Pin Please be careful!");
                        System.out.println("You have"+(3-attempts)+" attempts Remaining!");
                    }else{
                          System.out.println("X Wrong Authenctication!");
                         
                    }
                  }
                }while(attempts < 3);

       }


       
       /**
       * @param USER
       * @return
       */
      public static user deposite(user USER){
                
                int pin;
                int attempts = 0;

                do{

                Scanner  sp = new Scanner(System.in);
                System.out.println("Enter the Pin first: ");
                pin = sp.nextInt();
                
                  attempts++;
                  

                if(USER.Pin == pin){

                Double amount;
                System.out.print("Enter the amount here: ");
                amount = sp.nextDouble();
                USER.balance+= amount;
                return USER;
                }else{ 
                    if(attempts < 3){
                     System.out.println("Wrong Pin!"); 
                     System.out.println("You have "+(3-attempts)+" Remaining attempts please be Careful & try again!");
                    }else{
                          System.out.println(" X Wrong authenticaton!");
                    }
                }
              }while(attempts < 3);
         
                
               return USER; 

       }



       public static user withdraw(user USER){
                   
                Scanner sh = new Scanner(System.in);
                int pin;
                int attempts = 0;

                  do{

                  attempts++;
                  System.out.println("Enter Pin first: ");
                  pin = sh.nextInt();

                if(USER.Pin == pin ){

                 if( USER.balance > 0.0){
                    
                      Double amount;
                      System.out.print("Enter the amount here: ");
                      amount = sh.nextDouble();
               
                  if(amount < USER.balance){
                          USER.balance-= amount;
                }else{
                      System.out.println("Your balance is insuficient for this amount!");
                      System.out.println("Thank You.");
                }            
                }else{ System.out.println("Insuficient balance, withdraw failed!");
                   return USER;  
                }

                

              }else{ 
                     if(attempts < 3 ){                            

                               System.out.println("Enter the valid Pin!");
                               System.out.println("You have "+ (3-attempts)+" attempts Remaining Please enter carefully.");   
                     } else{
                           System.out.println(" X Wrong Authentication!");
                     }
              }

              }while(attempts < 3);
                                           
                return USER;
       }  
               
            


      
      public static void UI(user USER){

                   Scanner sq = new Scanner(System.in);

                   int choice = 0;
                   int attempt = 0;
                    
               
              do{
                  
                  attempt++;
                  System.out.println("\n"+"\n");

                  System.out.println("1.Press to check balance.");
                  System.out.println("2.Press to deposite.");
                  System.out.println("3.Press to Withdraw.");
                  System.out.println("4.Press to exit.");

                  System.out.println("Enter your choice: ");
                  choice = sq.nextInt();

                  switch ( choice) {
                    case 1: {check_balance(USER);}
                        break;
                    case 2 : deposite(USER);
                        break;
                    case 3:
                         withdraw(USER);
                         break;
                    case 4: 
                        System.out.println("\n Thanks for visiting sir\n");
                        
                        return;     
                    default:
                         System.out.println("Enter the valid choice");
                        
                         System.out.println("You have"+attempt+"attempt remaining.");
                         if(attempt == 3 ){
                        System.out.println("Wrong authentication!");
                             return;
                         }     
                      break;
                  }
                  
                      
                  }while(true);

              }
             
      
      public static void login(ArrayList<user> list){

              Scanner sj = new Scanner(System.in);
              System.out.println("\n"+"\n");
              int pin;
              String username;
              

              if(list.isEmpty()){
                    System.out.println("No any account found!\n First Register.");
              }else{

                 System.out.println("Enter the pin: ");
                 pin = sj.nextInt();
              

              System.out.println("Enter the username:");
              sj.nextLine();
               username = sj.nextLine();

             
              
              for(int i = 0; i < list.size(); i++){
                     
                      if(list.get(i).Pin == pin && list.get(i).name.equalsIgnoreCase(username)){                    
                                   
                                   System.out.println("\n Sir "+list.get(i).name+" wellcome back to your account.");    //waitin
                                   UI(list.get(i));
                      }else{ 
                                                       
                             System.out.println("\n"+"\n");
                             System.out.println("NO account exist with the given credientals!");
                             System.out.println("Please confirm and try again.");
                      }
            
              
                     }
                    }
                    return;
               }


           public static void CHOICE(ArrayList<user> list){

            Scanner sy = new Scanner(System.in);

            
             int choice = 0;

                        
                 do{

                  System.out.println("\n"+"\n");
                  System.out.println("1.Press to add account: ");
                  System.out.println("2.Press to delete account: ");
                  System.out.println("3.Press to login account: ");
                  System.out.println("4.Press to exit account: ");
        
                  System.out.println("Enter your choice: ");
                  choice = sy.nextInt();

                  switch (choice) {
                    case 1:
                         ADD(list);
                         System.out.println("\n"+"\n");
                      break;
                    case 2: 
                         Delete(list);  
                      break;
                    case 3: 
                         login(list);
                         break;
                    case 4:
                         System.out.println("Thanks for visiting us!");  
                         return;   
                    default:
                      System.out.println("Enter valid choice");
                      break;
                  }
                    
                     
                    
                 }while(true);
           }
              
 
        public static void main(String[]  str){


          System.out.println("\n"+"\n"+"\n");
          System.out.println("<<<<----welcome to the khushali bank---->>>>");
          System.out.println("\n");
          System.out.println("Choose any from Menu");

          ArrayList<user> customer = new ArrayList<>(); 
          CHOICE(customer);
        

        


        }
      }
 



  