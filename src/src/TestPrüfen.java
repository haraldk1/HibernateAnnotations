package src;


import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class TestPrüfen {
   
   
   private static SessionFactory factory;    
   
   public static void main(String[] args) {
       
      //Sitzung erstellen 
      
      try {
         factory = new AnnotationConfiguration().
                 //configure kommentiert 
                   configure().
                   //addPackage("com.xyz") //add package if used.
                   //addPackage("src").
                   addAnnotatedClass(Test.class).
                   buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object.   " + ex);
         throw new ExceptionInInitializerError(ex); 
      }
    
   TestPrüfen p = new TestPrüfen();
   
   //Einträge aus Tabelle test abfragen und anzeigen 
   p.anzeigen();
           
      
   } 
   
   
   
      /* Einträge anzeigen */
   public void anzeigen( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List tests = session.createQuery("FROM Test").list(); 
         //List tests = session.get(Test.class, session);   // --> muss noch angepasst werden um ohne Abfrage auszuführen
         for (Iterator iterator = tests.iterator(); iterator.hasNext();){
            Test test = (Test) iterator.next(); 
            System.out.print("Id: " + test.getId()); 
            System.out.print("  a: " + test.getA()); 
            System.out.println("  b: " + test.getB()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   
   
   
   
   
   
   
   
}
