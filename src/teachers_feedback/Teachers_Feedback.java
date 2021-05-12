package teachers_feedback;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Numbering
{
    int gc=0,bc=0,ac=0;
}
class Teacher
{
    int tp=0,eca=0,pt=0,rs=0;
    Numbering Teaching_Proficiency=new Numbering();
    Numbering Evalution_and_consulting_ability=new Numbering();
    Numbering Personal_traits=new Numbering();
    Numbering Respect_student=new Numbering();
    String course_name,name,id,password,unoff_cmnt;
    Teacher(String a,String b,String c,String d)
    {
        this.name=a;
        this.course_name=b;
        this.id=c;
        this.password=d;
    }
}
class Student
{
    String name,id,password;
    Student(String a,String b,String c)
    {
        this.name=a;
        this.id=b;
        this.password=c;
    }
}
class Admin
{
    void first()
    {
        System.out.println("To enroll new student press 1");
        System.out.println("To enroll new teacher press 2");
        System.out.println("To see students feedback about teacher press 3");
        System.out.println("To Change Password press 4");
        System.out.println("To see your students list press 5");
        System.out.println("To see your teachers list press 6");
        System.out.println("For log out press 0");
    }
}
class Controller
{
    Scanner input=new Scanner(System.in);
    Vector<Student> s=new Vector<Student>();
    Vector<Teacher> t=new Vector<Teacher>();
    Controller()
    {
        s.add(new Student("Abu Sayed","19511011","sayed"));
        s.add(new Student("Sanjid Hasan Ssajib","19511014","sanjid"));
        s.add(new Student("Muntarin Rahman","19511049","muntarin"));
        s.add(new Student("Rakibul Hasan","19511033","rakib"));
        t.add(new Teacher("Abu Yousuf","OODP","AY", "thankyousir"));
        t.add(new Teacher("Sohel Rana","OODP","SoRa", "youwillbemissed"));
        t.add(new Teacher("Sharwat Shamim","LAW","SS","GTFO"));
    }
    void show_student()
    {
        for(int i=0;i<s.size();i++)
        {
            System.out.println((i+1)+"."+"Name -"+s.get(i).name+" ID -"+s.get(i).id);
        }
    }
    void show_teacher()
    {
        for(int i=0;i<t.size();i++)
        {
            System.out.println((i+1)+"."+"Name -"+t.get(i).name+" ID -"+s.get(i).id+" Course -"+t.get(i).course_name);
        }
    }
    void print_comments(int index)
    {
        System.out.println("Teachers Name : "+t.get(index).name);
        System.out.println("Course name :"+t.get(index).course_name);
        System.out.println("Teaching Proficiency :");
        System.out.println("Given by "+t.get(index).tp+" students");
        System.out.println("Good -"+t.get(index).Teaching_Proficiency.gc);
        System.out.println("Avarage -"+t.get(index).Teaching_Proficiency.ac);
        System.out.println("Bad -"+t.get(index).Teaching_Proficiency.bc);
        System.out.println("Evalution and consulting ability :");
        System.out.println("Given by "+t.get(index).eca+" students");
        System.out.println("Good -"+t.get(index).Evalution_and_consulting_ability.gc);
        System.out.println("Avarage -"+t.get(index).Evalution_and_consulting_ability.ac);
        System.out.println("Bad -"+t.get(index).Evalution_and_consulting_ability.bc);
        System.out.println("Personal traits :");
        System.out.println("Given by "+t.get(index).pt+" students");
        System.out.println("Good -"+t.get(index).Personal_traits.gc);
        System.out.println("Avarage -"+t.get(index).Personal_traits.ac);
        System.out.println("Bad -"+t.get(index).Personal_traits.bc);
        System.out.println("Respect student :");
        System.out.println("Given by "+t.get(index).rs+" students");
        System.out.println("Good -"+t.get(index).Respect_student.gc);
        System.out.println("Avarage -"+t.get(index).Respect_student.ac);
        System.out.println("Bad -"+t.get(index).Respect_student.bc);
        System.out.println("Normal Comment about teacher -");
        System.out.println("# "+t.get(index).unoff_cmnt+" #");
    }
    void find(String j)
    {
        boolean ok=false;
        int tru;
        for(tru=0;tru<t.size();tru++)
        {
            if(t.get(tru).id.equals(j)==true)
            {
                ok=true;
                break;
            }
        }
        if(ok==false) System.out.println("Sorry this teachers id doesnt exist try again");
        else
        {
            print_comments(tru);
        }
    }
    boolean checking_t(String a,String b)
    {
        boolean ok=false;
        for(int i=0;i<t.size();i++)
        {
            if(t.get(i).id.equals(a)==true)
            {
                if(t.get(i).password.equals(b)==true){
                    ok=true;
                    break;
                }
            }
        }
        if(ok==false) return false;
        else return true;
    }
    boolean checking_s(String a,String b)
    {
        boolean ok=false;
        for(int i=0;i<t.size();i++)
        {
            if(s.get(i).id.equals(a)==true)
            {
                if(s.get(i).password.equals(b)==true){
                    ok=true;
                    break;
                }
            }
        }
        if(ok==false) return false;
        else return true;
    }
    void tp_change(String x)
    {
        int tru;
        System.out.println("Enter New Password");
        String np;
        np = input.nextLine();
        for(tru=0;tru<t.size();tru++)
        {
            if(t.get(tru).id.equals(x)==true)
            {
                t.get(tru).password=np;
                break;
            }
        }
    }
    void ts_change(String x)
    {
        int tru;
        System.out.println("Enter New Password");
        String np;
        np = input.nextLine();
        for(tru=0;tru<s.size();tru++)
        {
            if(s.get(tru).id.equals(x)==true)
            {
                s.get(tru).password=np;
                break;
            }
        }
    }
    String selectcourse()
    {
        Map< String,Integer> temp =  new HashMap< String,Integer>();
        for(int i=0;i<t.size();i++)
        {
            if(temp.get(t.get(i).course_name)==null)
            {
                System.out.println("press "+(i)+" for "+t.get(i).course_name);
                temp.put(t.get(i).course_name,1);
            }
        }
        int selection=input.nextInt();
        input.nextLine();
        return t.get(selection).course_name;
    }
    void final_job(String selected)
    {
        System.out.println("Press 1 for Good ");
        System.out.println("Press 2 for Average");
        System.out.println("Press 3 for Bad");
        for(int i=0;i<t.size();i++)
        {
            if(t.get(i).course_name.equals(selected)==true)
            {
                
                System.out.println(t.get(i).name);
                System.out.println("Teaching Proficiency :");
                t.get(i).tp++;
                int bb;
                while(true){
                System.out.println("Press 0 to skip for this time otherwise give right input");
                bb=input.nextInt();
                input.nextLine();
                if(bb==1)
                {
                    t.get(i).Teaching_Proficiency.gc++;
                    break;
                }
                else if(bb==2)
                {
                    t.get(i).Teaching_Proficiency.ac++;
                    break;
                }
                else if(bb==3)
                {
                    t.get(i).Teaching_Proficiency.bc++;
                    break;
                }
                else if(bb==0) {t.get(i).tp--;
                break;
                }
                else System.out.println("Wrong Keyword");
                }
                System.out.println("Evalution and consulting ability :");
                t.get(i).eca++;
                while(true){
                System.out.println("Press 0 to skip for this time otherwise give right input");
                bb=input.nextInt();
                input.nextLine();
                if(bb==1)
                {
                    t.get(i).Evalution_and_consulting_ability.gc++;break;
                }
                else if(bb==2)
                {
                    t.get(i).Evalution_and_consulting_ability.ac++;break;
                }
                else if(bb==3)
                {
                    t.get(i).Evalution_and_consulting_ability.bc++;break;
                }
                else if(bb==0) {t.get(i).eca--;
                break;
                }
                else System.out.println("Wrong Keyword");
                }
                System.out.println("Personal traits :");
                t.get(i).pt++;
                while(true){
                System.out.println("Press 0 to skip for this time otherwise give right input");
                bb=input.nextInt();
                input.nextLine();
                if(bb==1)
                {
                    t.get(i).Personal_traits.gc++;break;
                }
                else if(bb==2)
                {
                    t.get(i).Personal_traits.ac++;break;
                }
                else if(bb==3)
                {
                    t.get(i).Personal_traits.bc++;break;
                }
                else if(bb==0) {t.get(i).pt--;
                break;
                }
                else System.out.println("Wrong Keyword");
                }
                System.out.println("Respect student :");
                t.get(i).rs++;
                while(true){
                System.out.println("Press 0 to skip for this time otherwise give right input");
                bb=input.nextInt();
                input.nextLine();
                if(bb==1)
                {
                    t.get(i).Respect_student.gc++;break;
                }
                else if(bb==2)
                {
                    t.get(i).Respect_student.ac++;break;
                }
                else if(bb==3)
                {
                    t.get(i).Respect_student.bc++;break;
                }
                else if(bb==0) {t.get(i).rs--;
                break;
                }
                else System.out.println("Wrong Keyword");
                }
                System.out.println("Wanna make any written comment? if so press 1 else press 0");
                int last=input.nextInt();
                input.nextLine();
                if(last==1){
                System.out.println("comment :");
                t.get(i).unoff_cmnt=input.nextLine();
                }
            }
        }
    }
}
public class Teachers_Feedback {
    String authority_password="ys2b7";
    void initial()
    {
        System.out.println("For Admin logIN press 1 ");
        System.out.println("For Teachers logIN press 2 ");
        System.out.println("For Students logIN press 3 ");
        System.out.println("To exit the portal press 0");
    }
    public static void main(String[] args){
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        Scanner input=new Scanner(System.in);
        Teachers_Feedback innerobj=new Teachers_Feedback();
        Admin ad=new Admin();
        Controller cr=new Controller();
    while(true)
    {
        innerobj.initial();
        int q;
        q=input.nextInt();
        input.nextLine();
        if(q==1)
        {
            System.out.println("Enter Admin Password");
            String pass;
            pass=input.nextLine();
            if(pass.equals(innerobj.authority_password)==true)
            {
            while(true){
            ad.first();
            int k;
            k=input.nextInt();
            input.nextLine();
            if(k==1)
            {
                while(true){
                String a,b,c;
                System.out.println("New students name :");
                a=input.nextLine();
                System.out.println("New students ID :");
                b=input.nextLine();
                System.out.println("New students Password :");
                c=input.nextLine();
                cr.s.add(new Student(a,b,c));
                 System.out.println("Want to add again ? if so then press 1 else 0");
                    int ans;
                    ans=input.nextInt();
                    input.nextLine();
                    if(ans==0) break;
                }
            }
            else if(k==2)
            {
                while(true){
                String a,b,c,d;
                System.out.println("New teachers name :");
                a=input.nextLine();
                System.out.println("Course name :");
                b=input.nextLine();
                System.out.println("New teachers ID :");
                c=input.nextLine();
                System.out.println("New teachers Password :");
                d=input.nextLine();
                cr.t.add(new Teacher(a,b,c,d));
                    System.out.println("Want to add again ? if so then press 1 else 0");
                    int ans;
                    ans=input.nextInt();
                    input.nextLine();
                    if(ans==0) break;
                }  
            }
            else if(k==3)
            {
                while(true){
                System.out.println("Enter teachers ID :");
                String x;
                x=input.nextLine();
                cr.find(x);
                System.out.println("Want to check again ? if so then press 1 else 0");
                 int ans;
                 ans=input.nextInt();
                 input.nextLine();
                 if(ans==0) break;
             }
            }
            else if(k==5)
            {
                cr.show_student();
            }
            else if(k==6)
            {
                cr.show_teacher();
            }
            else if(k==0) break;
            else if(k==4)
            {
                System.out.println("Enter new password");
                innerobj.authority_password=input.nextLine();
            }
            else System.out.println("Wrong Keyword");
            }
            }
            else System.out.println("Wrong Password try again");
        }
        else if(q==2)
        {
            System.out.println("Enter Your ID");
            String id,p;
            id=input.nextLine();
            System.out.println("Enter Your Password");
            p=input.nextLine();
            if(cr.checking_t(id, p)==true)
            {
                while(true){
                System.out.println("To See your students feedback about you press 1");
                System.out.println("To change your password press 2");
                System.out.println("To logout press 0");
                int k;
                k=input.nextInt();
                input.nextLine();
                if(k==1)
                {
                    cr.find(id);
                }
                else if(k==2)
                {
                    cr.tp_change(id);
                    System.out.println("Done");
                }
                else if(k==0) break;
                else System.out.println("Wrong Keyword");
                }
            }
            else System.out.println("Password or ID missmatch try again");
        }
        else if(q==3)
        {
            System.out.println("Enter Your ID");
            String id,p;
            id=input.nextLine();
            System.out.println("Enter Your Password");
            p=input.nextLine();
            if(cr.checking_s(id,p)==true)
            {
                while(true){
                System.out.println("To give your feedback about teacher press 1");
                System.out.println("To change your password press 2");
                System.out.println("To logout press 0");
                int k;
                k=input.nextInt();
                input.nextLine();
                if(k==1)
                {
                    while(true){
                    System.out.println("Select Course :");
                    String sc=cr.selectcourse();
                    cr.final_job(sc);
                    System.out.println("Job Done");
                    System.out.println("Wanna give again ? if so press 1 else press 0");
                    int ans;
                    ans=input.nextInt();
                    input.nextLine();
                    if(ans==0) break;
                    }
                }
                else if(k==2)
                {
                    cr.ts_change(id);
                    System.out.println("Done");
                }
                else if(k==0) break;
                else System.out.println("Wrong Keyword");
                }
            }
            else System.out.println("Password or ID missmatch try again");
        }
        else if(q==0) break;
        else System.out.println("Wrong Keyword");
    }    
}
}
