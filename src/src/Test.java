
package src;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * Klasse als entity bean vermerken und Tabelle angeben womit das entity bean persistent sein wird 
 */
@Entity
//erzeugt Fehler mit dieser Annotation (Table) (es wird neue Version geben etc...)
//@Table (name = "test")
public class Test {

    //Primärschlüssel und Spalten zu Variablen zuordnen
    
     @Id @GeneratedValue
     @Column (name = "id")
     private int id;
     
     @Column (name ="a")
     private String a;
     
     @Column (name ="b")
     private String b;

    public Test() {
    }

	

   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getA() {
        return this.a;
    }
    
    public void setA(String a) {
        this.a = a;
    }
    public String getB() {
        return this.b;
    }
    
    public void setB(String b) {
        this.b = b;
    }




}





















//    public Test(int id) {
//        this.id = id;
//    }
//    public Test(int id, String a, String b) {
//       this.id = id;
//       this.a = a;
//       this.b = b;
//    }
