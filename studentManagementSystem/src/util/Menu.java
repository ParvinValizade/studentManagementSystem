/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import bean.Config;
import service.menu.MenuAddStudentService;
import service.menu.MenuAddTeacherService;
import service.menu.MenuLoginService;
import service.menu.MenuRegisterService;
import service.menu.MenuShowStudentService;
import service.menu.MenuShowTeacherService;
import service.inter.Process;

/**
 *
 * @author Parvin
 */
public enum Menu {
    LOGIN(1, "Login", new MenuLoginService()),
    REGISTER(2, "Register", new MenuRegisterService()),
    ADD_TEACHER(3, "Add teacher", new MenuAddTeacherService()),
    ADD_STUDENT(4, "Add student", new MenuAddStudentService()),
    SHOW_ALL_TEACHER(5, "Show all teachers", new MenuShowTeacherService()),
    SHOW_ALL_STUDENT(6, "Show all students", new MenuShowStudentService()),
    UNKNOWN;
    
    
    private int number;
    private String lebel;
    private Process service;
    

    Menu (){
    }
    
    Menu(int number, String lebel, Process service) {
        this.lebel = lebel;
        this.service = service;
        this.number = number;
    }

    public String getLebel() {
        return lebel;
    }

    @Override
    public String toString() {
        return number+"."+ lebel;
    }

    public void process() {
        service.process();
        MenuUtil.showMenu();
    }
    public int getNumber (){
        return this.number;
    }
    
    public static Menu find(int number) {
           Menu[] menus=Menu.values();
                for (int i = 0; i < menus.length; i++) {
                    if (menus[i].getNumber()==number) {
                        return menus[i];
                    }
        }
             return Menu.UNKNOWN;
    
    }
    public static void showAllMenu(){
          Menu[] menus=Menu.values();
             for (int i = 0; i < menus.length; i++) {
                 if(menus[i]!=UNKNOWN){
                     if (menus[i]==LOGIN || menus[i]==REGISTER ) {
                         if (!Config.isLoogedIn()) {
                             System.out.println(menus[i]);
                         }
                     } else if (Config.isLoogedIn()) {
                         System.out.println(menus[i]);
                     }
                 
        }
    }
}
}
