/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.menu;

import bean.Config;
import bean.Student;
import java.util.Scanner;
import service.inter.menu.MenuAddStudentServiceInter;
import util.FileUtility;

/**
 *
 * @author Parvin
 */
public class MenuAddStudentService implements MenuAddStudentServiceInter {

    @Override
    public void processLogic() {
       Scanner sc=new Scanner(System.in);
        System.out.println("Please enter name:");
       String name=sc.nextLine();
       
       Scanner sc2=new Scanner(System.in);
       System.out.println("Please enter surname:");
       String surname=sc2.nextLine();
       
       Student s=new Student();
       s.setName(name);
       s.setSurname(surname);
       
     Config.instance().appendStudent(s);
        System.out.println("student added");

    }
    
}
